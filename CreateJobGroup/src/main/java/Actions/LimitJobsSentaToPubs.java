package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LimitJobsSentaToPubs {

    WebDriver driver;
    DropDown dropDown;

    public LimitJobsSentaToPubs(WebDriver Driver)
    {
        driver=Driver;
        dropDown= new DropDown();
    }

    public void limitJobs(WebElement element) throws InterruptedException {
        WebElement elmnt = element.findElements(By.className("mt-4")).get(2);

        elmnt.findElement(By.tagName("mat-checkbox")).click();

        WebElement jobLimit = driver.findElement(By.name("jobLimit"));

        jobLimit.sendKeys("100");


        WebElement filterJobs = driver.findElement(By.xpath("//mat-select[@placeholder='Filter Jobs By*']"));

        //  filterJobs.click();
        dropDown.dropDown(filterJobs, driver,"Newest jobs");

        WebElement days = driver.findElement(By.xpath("//mat-select[@placeholder='From*']"));

        dropDown.dropDown(days,driver,"last 7 days");

    }
}
