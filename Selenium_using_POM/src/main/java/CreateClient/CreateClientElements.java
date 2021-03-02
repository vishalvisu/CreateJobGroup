package CreateClient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CreateClientElements {

    WebDriver driver;
    WebElement ClientName;
    WebElement ExportedName;
    WebElement AdvertiserName;
    WebElement Timezone;
    WebElement ATSName;
    WebElement ATSURL;
    WebElement Frequency;
    WebElement ApplyConversionWindow;
    WebElement FeedUR;
    WebElement MapFeedURl;
    WebElement AddFeed;
    WebElement Industry;
    WebElement MonthlyBudget;
    WebElement ClientStartDate;
    WebElement ClientEndDate;
    WebElement CountryRegion;

    public CreateClientElements(WebDriver Driver)
    {
        driver=Driver;


        WebElement form=   driver.findElement(By.className("client-container"));
        List<WebElement> childs = form.findElements(By.xpath("./child::*"));

        //Temporaray Variables
        WebElement e;
        List<WebElement> list= new ArrayList<WebElement>();


        e= childs.get(0);
        list=  e.findElements(By.tagName("input"));
        ClientName= list.get(0);
        ExportedName=list.get(1);

        e= childs.get(1);
        list=  e.findElements(By.tagName("input"));

      AdvertiserName=list.get(0);

      Timezone= e.findElement(By.tagName("jv-multiselect"));
        searchDropdownComboExecutor ("mat-select-content",driver);






    }
}
