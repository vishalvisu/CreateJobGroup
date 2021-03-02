package Job_Group;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Rule
{
    String attibute;
    String operator;
    String value;
   public Rule(String a,String b,String c)
   {
       attibute=a;
       operator=b;
       value=c;
   }
}

enum Any_All
{
    Any,All;
}

/*class Group
{
    Any_All any_all;
    List<Rule> rules;
    List<Group> groups;

    public Group(Any_All anyAll,List<Rule> listRules,List<Group> ListGroups)
    {
        any_all=anyAll;
        rules=listRules;
        groups=ListGroups;
    }
}*/


public class Create_a_Job_Group {

    public static int n=2;
    public static int sleep_time=1000;
    public static WebDriver driver=null;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get("https://mojo2.joveo.com/clients");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("reliability@joveo.com");

        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("joveo1520");

        driver.findElement(By.className("mat-raised-button")).click();

      // String createJobGroupPage= "https://mojo2.joveo.com/clients/8e3187a8-b679-4a6c-87cc-efdab1243cbb/campaigns/7f46d90b-67c7-40d4-be3a-4db53ed84c0a/jobgroups/create";

        //driver.get(createJobGroupPage);
        WebElement client=getClientORCampaign("vishal");


        new WebDriverWait(driver,2000).until(ExpectedConditions.urlContains("campaigns"));
       // client.click();

        new WebDriverWait(driver,10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

     WebElement campaign= getClientORCampaign("c1");

        new WebDriverWait(driver,10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        CreateClientCampaignJobgroupButton();

        createJobGroup();
    }


    public static void createJobGroup() throws InterruptedException {

     //   System.out.println("input "+ driver.findElements(By.xpath("//input[@formcontrolname='name']")).size());

     //Enter Job Group Name
     driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("ABC");

     //Enter CampaignName
      WebElement dropDownCampaignName= driver.findElement(By.xpath("//mat-select[@formcontrolname='campaignId']"));
         handleDropDown("Default Campaign",dropDownCampaignName);

     //Set-Start-Date
     WebElement start_date= driver.findElement(By.xpath("//input[@formcontrolname='startDate']"));
     start_date.click();
        setDate(driver,"2022","FEB","17");
       // Thread.sleep(sleep_time);

     //Set-End-Date
        WebElement end_date= driver.findElement(By.xpath("//input[@formcontrolname='endDate']"));
        end_date.click();
        setDate(driver,"2025","JAN","27");
     //   Thread.sleep(sleep_time);


//Handle Job Filtering
        WebElement jobfiter1= driver.findElement(By.tagName("jv-jobs-filter")).findElement(By.tagName("mat-card"));

       //Get all immediate childs of job_filter
        //row one contains job-setting(any_all,add_rule,add_group)
        List<WebElement> parent1=jobfiter1.findElements(By.xpath("*"));

        //Set Any All
        WebElement AnyAll_DropDown= parent1.get(0).findElement(By.tagName("mat-form-field"));
        System.out.println(parent1.size());

        handleDropDown("ANY",AnyAll_DropDown);


        //Get add_rule_or_group_btns
      List<WebElement> ADD_Rule_Group_Btns= getADD_RULE_GROUP_BTNS(parent1);

      System.out.println(ADD_Rule_Group_Btns.size());
      WebElement add_rule_btn=ADD_Rule_Group_Btns.get(0);
      WebElement add_group_btn=ADD_Rule_Group_Btns.get(1);

      //Clear default job_rule

       WebElement default_job_rule= parent1.get(1).findElement(By.tagName("jv-rule")).findElement(By.className("rule_container"));

      List<WebElement> InnerElements = default_job_rule.findElements(By.xpath("*"));
      InnerElements.get(InnerElements.size()-1).click();

      int r=1,g=1;
      createNrules(r,add_rule_btn);
      createNgroups(g,add_group_btn);

      //0th index is job_setting parameters
       //rules are from index=1 to index=n
        // Here (n=2)
        parent1=jobfiter1.findElements(By.xpath("*"));
      fillrules(parent1,r);

      List<Integer> rules_in_group_i=new ArrayList<>();
      rules_in_group_i.add(1);
      //rules_in_group_i.add(2);
      //rules_in_group_i.add(3);

      List<Integer> groups_in_group_i= new ArrayList<>();
      groups_in_group_i.add(1);
      //groups_in_group_i.add(3);
      //groups_in_group_i.add(5);

      List<Integer> no_Of_Rules_innermost_group=new ArrayList<>();

      for(int i=0;i<g;i++)
      {
          for(int j=0;j<groups_in_group_i.get(i);j++)
              no_Of_Rules_innermost_group.add(1+(i+j)%2);
      }

      //for depth-1
        int k=0;
        for(int i=r+1;i<=r+g;i++)
        {
            int index=i-r-1;
            WebElement jobfilter2= parent1.get(i).findElement(By.className("group-container"));
           List <WebElement> parent2= jobfilter2.findElements(By.xpath("*"));

           //Any_All_DropDown
            AnyAll_DropDown= parent2.get(0).findElement(By.tagName("mat-form-field"));
            handleDropDown("ANY",AnyAll_DropDown);

            ADD_Rule_Group_Btns= getADD_RULE_GROUP_BTNS(parent2);
             add_rule_btn=ADD_Rule_Group_Btns.get(0);
             add_group_btn=ADD_Rule_Group_Btns.get(1);

            createNrules(rules_in_group_i.get(index),add_rule_btn);
            createNgroups(groups_in_group_i.get(index),add_group_btn);
        parent2= jobfilter2.findElements(By.xpath("*"));
            System.out.println("Size Of PARENT2 "+parent2.size());

            fillrules(parent2,rules_in_group_i.get(index));

            // for depth=2 // from n=3 to n=4(inner most groups)
            int ttl= rules_in_group_i.get(i-r-1) +groups_in_group_i.get(index);

         for(int j=rules_in_group_i.get(index)+1;j<=ttl;j++) {
             WebElement jobfilter3 = parent2.get(j).findElement(By.className("group-container"));
             List<WebElement> parent3 = jobfilter3.findElements(By.xpath("*"));

             //Any_All_DropDown
             AnyAll_DropDown= parent3.get(0).findElement(By.tagName("mat-form-field"));
             handleDropDown("ANY",AnyAll_DropDown);

             ADD_Rule_Group_Btns = getADD_RULE_GROUP_BTNS(parent3);
             add_rule_btn = ADD_Rule_Group_Btns.get(0);

             int no=no_Of_Rules_innermost_group.get(k++);
             // add_group_btn=ADD_Rule_Group_Btns.get(1);
              createNrules(no, add_rule_btn);
             // createNgroups(n,add_group_btn);

             parent3 = jobfilter3.findElements(By.xpath("*"));
             System.out.println("Size Of PARENT2 " + parent3.size());

             fillrules(parent3,no);
         }
        }

        //for depth-2

        //Handle-IO-Details
        WebElement ioDetails= driver.findElement(By.xpath("//div[@formarrayname='ioDetails']"));
        WebElement createIoDetails= ioDetails.findElement(By.className("job-group-form__ioDetails-actions"));
 WebElement createIoDetails_BTN=createIoDetails.findElement(By.tagName("button"));

        for(int i=0;i<1;i++) {
            createIoDetails_BTN.click();
            Thread.sleep(500);
        }

        //Fill_IO_Details
        //Update ioDetails as new fields may be created as in above loop
        ioDetails= driver.findElement(By.xpath("//div[@formarrayname='ioDetails']"));

        int noOfIODetails = ioDetails.findElements(By.className("job_group_form__iodetails")).size();


        System.out.println(noOfIODetails);

        List<WebElement> list_of_Io_Details= ioDetails.findElements(By.className("job_group_form__iodetails"));

        System.out.println(list_of_Io_Details.size());

        for(WebElement e:list_of_Io_Details)
        {
            WebElement iodetail= e;
            //Enter IO Number
            iodetail.findElement(By.xpath(".//input[@formcontrolname='number']")).sendKeys("45567");

            //Enter Amount
            iodetail.findElement(By.xpath(".//input[@formcontrolname='value']")).clear();
            iodetail.findElement(By.xpath(".//input[@formcontrolname='value']")).sendKeys("1000");

            //Set-Io-Start-Date
            WebElement IO_start_date= iodetail.findElement(By.xpath(".//input[@formcontrolname='startDate']"));
            IO_start_date.click();
            setDate(driver,"2023","MAR","22");
            // Thread.sleep(sleep_time);

            //Set-Io-End-Date
            WebElement IO_end_date= iodetail.findElement(By.xpath(".//input[@formcontrolname='endDate']"));
            IO_end_date.click();
            setDate(driver,"2027","DEC","13");
            //   Thread.sleep(sleep_time);
        }

        //Enable Tracking URL
//       driver.findElement(By.xpath("//input[@formcontrolname='trackingUrl']")).sendKeys("https://www.google.com");

        //Job Group Priority
      WebElement priority=  driver.findElement(By.xpath("//mat-select[@formcontrolname='priority']"));
      handleDropDown("5",priority);


      // Go To Next Page
     driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
         SecondPage(driver);
    }

    public static void  SecondPage(WebDriver driver) throws InterruptedException {
       SelectNetwork(driver);
       SetBids(driver);
       SetTradingGoals(driver);
       SetCaps(driver);
       ApplyCapsAtJobLevel(driver);
      LimitNumberOfJobsSentToPubsls(driver);
      MediaPlanner(driver);
    }

    public static void MediaPlanner(WebDriver driver) throws InterruptedException {
       WebElement generateOptimizedPlan=  driver.findElement(By.className("joveo-rec"));

       generateOptimizedPlan.click();
       System.out.println(generateOptimizedPlan.getText());

       // Set Paginator to lowest value
        WebElement paginator= driver.findElement(By.xpath("//mat-select[@aria-label='Items per page']"));

        handleDropDown("5",paginator);

       // System.out.println(driver.findElement(By.tagName("tbody")).findElements(By.tagName("mat-checkbox")).size());

        //Select all publishers one by one and use pagination

        while (true) {
            List<WebElement> list = driver.findElement(By.tagName("tbody")).findElements(By.tagName("mat-checkbox"));

            for (WebElement e : list) {
                if (!e.getAttribute("class").contains("checked"))
                    e.click();
            }
            WebElement nxtPage= driver.findElement(By.xpath("//button[@aria-label='Next page']"));
            if(nxtPage.isEnabled())
                nxtPage.click();
            else
                break;
        }


    }

    public static void LimitNumberOfJobsSentToPubsls(WebDriver driver) throws InterruptedException {
     //System.out.println(driver.findElement(By.className("campaign-form")).findElements(By.className("mt-4")).size());
     // gives 3

    WebElement elmnt=    driver.findElement(By.className("campaign-form")).findElements(By.className("mt-4")).get(2);

    elmnt.findElement(By.tagName("mat-checkbox")).click();

    WebElement jobLimit= driver.findElement(By.name("jobLimit"));

         jobLimit.sendKeys("100");


     WebElement filterJobs= driver.findElement(By.xpath("//mat-select[@placeholder='Filter Jobs By*']"));

   //  filterJobs.click();
        handleDropDown("Newest jobs",filterJobs);

        WebElement days= driver.findElement(By.xpath("//mat-select[@placeholder='From*']"));

        handleDropDown("last 7 days",days);

    }


    public static void SelectNetwork(WebDriver driver) {
        WebElement Networks = driver.findElement(By.className("job-group-form__placements-container"));

        List<WebElement> NetworksTypes = Networks.findElements(By.tagName("mat-checkbox"));
        System.out.println(NetworksTypes.size());

        for (WebElement e : NetworksTypes) {
            if (!e.getAttribute("class").contains("checked")) {
                e.findElement(By.className("mat-checkbox-inner-container")).click();
                System.out.println("clicked");
            }
        }
    }

    public static void SetBids(WebDriver driver)
    {

    WebElement cpcBid= driver.findElement(By.xpath("//input[@formcontrolname='cpcBid']"));

    cpcBid.sendKeys("1");

        WebElement cpaBid= driver.findElement(By.xpath("//input[@formcontrolname='cpaBid']"));

        cpaBid.sendKeys("1");
    }

    public static void SetTradingGoals(WebDriver driver)
    {
        WebElement cpcGoal= driver.findElement(By.xpath("//input[@formcontrolname='cpcTargeting']"));

        cpcGoal.sendKeys("1");

        WebElement cpaGoal= driver.findElement(By.xpath("//input[@formcontrolname='cpaTargeting']"));

        cpaGoal.sendKeys("1");
    }

    public static void SetCaps(WebDriver driver)
    {

        List<WebElement> caps= driver.findElements(By.className("cap"));

        //BudgetCap
        handleCaps(driver,caps.get(0));

        //clickCap
        handleCaps(driver,caps.get(1));

        //AppliesCap
        handleCaps(driver,caps.get(2));

    }



    public static void handleCaps(WebDriver driver,WebElement cap)
    {


        WebElement body= cap.findElement(By.className("body"));

      List<WebElement> radioButtons= body.findElements(By.tagName("mat-radio-button"));

      for(WebElement e:radioButtons) {
          if(e.getText().equalsIgnoreCase("monthly"))
              e.click();
        //  System.out.println(e.getText());
      }

        WebElement pacing= cap.findElement(By.className("header")).findElement(By.tagName("mat-slide-toggle"));
        if(!pacing.getAttribute("class").contains("checked"))
        {
            pacing.click();
            System.out.println("clicked");
        }

      WebElement Target= cap.findElement(By.xpath(".//input[@placeholder='Target']"));

      WebElement Threshold= cap.findElement(By.xpath(".//input[@placeholder='Threshold']"));

      Threshold.clear();
      Target.clear();

      Target.sendKeys("1000");
      Threshold.sendKeys("85");


    }

    public static void ApplyCapsAtJobLevel(WebDriver driver)
    {
     WebElement form=   driver.findElement(By.className("campaign-form")).findElement(By.tagName("mat-card"));

     List<WebElement> rows= form.findElements(By.xpath("*"));

     WebElement applyCapsAtJobLevel= rows.get(7).findElement(By.tagName("mat-checkbox"));

     applyCapsAtJobLevel.click();

     //System.out.println(list.size();
      WebElement caps= driver.findElements(By.className("caps-group")).get(1);

      List<WebElement> list= caps.findElements(By.className("job-group-form__caps"));

      // JobBudgetCap
         handleCaps(driver,list.get(0));

      //JobClicksCap
      handleCaps(driver,list.get(1));

      //JobAppliesCap
      handleCaps(driver,list.get(2));

    }

    public static void setDate (WebDriver driver,String year,String month,String date_of_month) throws InterruptedException
    {

        Thread.sleep(sleep_time);
        WebElement Calender=  driver.findElement(By.tagName("mat-calendar"));

        List<WebElement> btns=Calender.findElements(By.tagName("button"));

        System.out.println(btns.size());

        btns.get(0).click();

        Thread.sleep(sleep_time);


        selectYearMonthDate (driver,year);
        selectYearMonthDate (driver,month);
        selectYearMonthDate (driver,date_of_month);
        //  btn.click();


        //jsdriver.executeScript("arguments[0].setAttribute('value'+'"+date+"');",elmnt);
    }

    public static void selectYearMonthDate (WebDriver driver,String value) throws InterruptedException
    {

        List<WebElement> table= driver.findElements(By.className("mat-calendar-body-cell-content"));

         System.out.println("year "+table.size());
        for(WebElement e: table)
        {
           if(e.getText().compareTo(value)==0)
            {
                e.click();
                Thread.sleep(sleep_time);
                break;
            }

          //System.out.println(e.getText());
        }
    }

 public static   List<WebElement> getADD_RULE_GROUP_BTNS (List <WebElement> parent)
    {
       return parent.get(0).findElements(By.tagName("button"));
    }

    public static void fillrules(List<WebElement> parent,int noOfrules) throws InterruptedException {

        WebElement DropDown;
        for(int i=1;i<=noOfrules;i++) {
            WebElement rule = parent.get(i).findElement(By.tagName("jv-rule")).findElement(By.className("rule_container"));

           List<WebElement> InnerElements = rule.findElements(By.xpath("*"));

            System.out.println(InnerElements.size());
            DropDown=  InnerElements.get(0).findElement(By.tagName("mat-select"));
          handleDropDown("City",DropDown);

        DropDown=  InnerElements.get(1).findElement(By.tagName("mat-select"));
        handleDropDown("equal",DropDown);

        InnerElements.get(2).findElement(By.tagName("input")).sendKeys("Delhi");
        }
    }

    public static void handleDropDown(String value,WebElement dropDown) throws InterruptedException {
        dropDown.click();
        Thread.sleep(500);

        List<WebElement> options= driver.findElements(By.tagName("mat-option"));

        for(WebElement e:options) {
            if (e.getText().equalsIgnoreCase(value)) {
                e.click();
                return;
            }
        }
    }


    public static void createNrules(int n,WebElement add_rule_btn) throws InterruptedException {
        for(int i=0;i<n;i++) {
            add_rule_btn.click();
            Thread.sleep(500);
        }
    }

    public static void createNgroups(int n,WebElement add_group_btn) throws InterruptedException {
        for(int i=0;i<n;i++) {
            add_group_btn.click();
            Thread.sleep(500);
        }
    }


    public static void CreateClientCampaignJobgroupButton()
    {

        new WebDriverWait(driver,2000).until(ExpectedConditions.urlContains("jobgroups"));
        System.out.println("clicked");
        driver.findElement(By.className("create-button")).click();
        return;
    }

    public static  WebElement getClientORCampaign(String name) throws InterruptedException {

        WebElement element = driver.findElement(By.className("first-last-rule"));

//System.out.println(driver.findElements(By.className("first-last-rule")).size());

        //hovering
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();

        driver.findElement(By.className("remove-btn")).click();

        driver.findElement(By.className("search-icon")).click();

        Thread.sleep(1000);
        driver.findElements(By.tagName("input")).get(2).sendKeys(name);

        System.out.println(driver.findElements(By.xpath("//input[@type='text']")).size());


       Thread.sleep(1000);

       WebElement box=  driver.findElements(By.tagName("input")).get(2);

      //  driver.findElement(By.className("entity__datatable")).click();
        ;
        //  Thread.sleep(4000);

        //Option1
        //driver.findElement(By.className("mat-menu-item")).click();;

        box.sendKeys(Keys.RETURN);
        //Option2
       // Actions keys = new Actions(driver);
        //keys.sendKeys(Keys.RETURN);
         Thread.sleep(4000);
        WebElement dataTable = driver.findElement(By.className("entity__datatable"));

        List<WebElement> trElements = dataTable.findElements(By.tagName("tr"));

        System.out.print("rows "+trElements.size());

        int row = 0;
        WebElement clientElement = null,clientName=null;

        for (WebElement e : trElements) {

            if (row < 2) {
                row++;
                continue;
            }
            List<WebElement> list = e.findElements(By.tagName("td"));
            if (list.size() < 5)
                continue;

            String clientNameString = list.get(2).getText();

            //System.out.println(clientNameString);

            if (clientNameString.compareToIgnoreCase(name) == 0) {
                clientElement = e;
                clientName= list.get(2);
               // if(clientName!=null)
                e.findElement(By.linkText(clientNameString)).click();
            //    clientName.click();
               // else
                 //   System.out.println("client name is null");
                  System.out.println(clientName);
                  break;
            }
        }
    return clientElement ;
    }


    public static List<Rule> getRules()
    {
        List<Rule> Rules= new ArrayList<>();

        Rules.add(new Rule("City","equal","Hyderabad"));
        Rules.add(new Rule("Category","contains","Engineering"));
        Rules.add(new Rule("Type","equal","contract"));
        return Rules;
    }







}
