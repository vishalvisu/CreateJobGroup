package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class JobFilter {

    DropDown dropDown;
    InputText inputText;
    WebDriver driver;

   public JobFilter(WebDriver Driver)
    {
        dropDown=new DropDown();
        inputText=new InputText();
        driver=Driver;
    }

   public void JobsFilter(WebElement filter) throws InterruptedException {
       WebElement jobfiter1= filter.findElement(By.tagName("mat-card"));

       //Get all immediate childs of job_filter
       //row one contains job-setting(any_all,add_rule,add_group)
       List<WebElement> parent1=jobfiter1.findElements(By.xpath("*"));

       //Set Any All
       WebElement AnyAll_DropDown= parent1.get(0).findElement(By.tagName("mat-form-field"));
       System.out.println(parent1.size());

       dropDown.dropDown(AnyAll_DropDown,driver,"ANY");


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
           WebElement elelment= parent2.get(0).findElement(By.tagName("mat-form-field"));
           dropDown.dropDown(elelment,driver,"ANY");

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
               dropDown.dropDown(AnyAll_DropDown,driver,"Any");

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

   }

    public    List<WebElement> getADD_RULE_GROUP_BTNS (List <WebElement> parent)
    {
        return parent.get(0).findElements(By.tagName("button"));
    }

    public  void fillrules(List<WebElement> parent,int noOfrules) throws InterruptedException {

        WebElement element;
        for(int i=1;i<=noOfrules;i++) {
            WebElement rule = parent.get(i).findElement(By.tagName("jv-rule")).findElement(By.className("rule_container"));

            List<WebElement> InnerElements = rule.findElements(By.xpath("*"));

            element=  InnerElements.get(0).findElement(By.tagName("mat-select"));

            dropDown.dropDown(element,driver,"City");


            element=  InnerElements.get(1).findElement(By.tagName("mat-select"));
            dropDown.dropDown(element,driver,"equal");

            InnerElements.get(2).findElement(By.tagName("input")).sendKeys("Delhi");
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


}
