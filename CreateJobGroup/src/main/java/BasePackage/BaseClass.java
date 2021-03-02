package BasePackage;

import CampaignPage.CampaignActions;
import CampaignPage.CampaignWebElements;
import EnterJobGroupDetails.CreateJobGroupActions;
import EnterJobGroupDetails.CreateJobGroupFormWebElements;
import HomePage.HomePageActions;
import HomePage.HomePageWebElements;
import JobGroupPageWebElements.JobGroupActions;
import JobGroupPageWebElements.JobGroupWebElements;
import LoginPage.LoginActions;
import LoginPage.LoginWebElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseClass {

        public static WebDriver driver = new ChromeDriver();;

        public static void main(String args[]) throws InterruptedException {
            setUpWebDriver();
            lanchBrowser();
                 Login();
            //   NavigateToCreateJobGroupPage();
                 searchClient();
                 searchCampaign();
                 AddJobGroup();
                 enterJobGroupDetails();

        }

        public static void setUpWebDriver() {
            WebDriverManager.chromedriver().setup();


            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        public static void lanchBrowser() {
            driver.get("https://mojo2.joveo.com/clients");
            driver.manage().window().maximize();
        }

        public static void Login()
        {
            LoginWebElements loginpage= PageFactory.initElements(driver,LoginWebElements.class);
            new LoginActions(loginpage,driver,"reliability@joveo.com","joveo1520");
        }

        public static void searchClient () throws InterruptedException {
            new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("clients"));


            HomePageWebElements homePage= PageFactory.initElements(driver,HomePageWebElements.class);
            new HomePageActions(homePage,driver,"vishal");
        }

    public static void searchCampaign () throws InterruptedException {

            new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("clients"));

        CampaignWebElements campaignPage= PageFactory.initElements(driver,CampaignWebElements.class);
            new CampaignActions(campaignPage,driver,"c1");

        }

        public static void AddJobGroup() throws InterruptedException{

            new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("jobgroup"));

            JobGroupWebElements jobGroupPage= PageFactory.initElements(driver,JobGroupWebElements.class);

            new JobGroupActions(jobGroupPage,driver);
        }

        public static void enterJobGroupDetails() throws InterruptedException {
            new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("create"));

            CreateJobGroupFormWebElements createJobGroupFormWebElements= PageFactory.initElements(driver,CreateJobGroupFormWebElements.class);

            new CreateJobGroupActions(createJobGroupFormWebElements,driver);

        }


    }
/*
 public void select_Year_Month_Date (WebDriver driver, String value) throws InterruptedException
    {

        List<WebElement> table= driver.findElements(By.className("mat-calendar-body-cell-content"));

        System.out.println("year "+table.size());
        for(WebElement e: table)
        {
            if(e.getText().compareTo(value)==0)
            {
                e.click();
                Thread.sleep(1000);
                break;
            }

            //System.out.println(e.getText());
        }
    }

    public  void setDate (WebDriver driver, String year, String month, String date_of_month,WebElement calender) throws InterruptedException
    {

        selectYearMonthDate=new SelectYearMonthDate();
        clickBtn=new ClickBtn();

        clickBtn.click(calender);

        Thread.sleep(2000);
        WebElement Calender=  driver.findElement(By.tagName("mat-calendar"));

        List<WebElement> btns=Calender.findElements(By.tagName("button"));

        System.out.println(btns.size());

        //First button is for changing range
        btns.get(0).click();

        Thread.sleep(2000);



        selectYearMonthDate.select_Year_Month_Date (driver,year);
        selectYearMonthDate.select_Year_Month_Date (driver,month);
        selectYearMonthDate.select_Year_Month_Date (driver,date_of_month);

    }
 */