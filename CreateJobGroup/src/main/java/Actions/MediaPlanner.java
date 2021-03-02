package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediaPlanner {

    WebDriver  driver;
    DropDown dropDown;
    public MediaPlanner(WebDriver Driver)
    {
        driver=Driver;
        dropDown= new DropDown();
    }

    public  void mediaPlanner() throws InterruptedException {
        WebElement generateOptimizedPlan=  driver.findElement(By.className("joveo-rec"));

        generateOptimizedPlan.click();
        System.out.println(generateOptimizedPlan.getText());

        // Set Paginator to lowest value
        WebElement paginator= driver.findElement(By.xpath("//mat-select[@aria-label='Items per page']"));

        dropDown.dropDown(paginator,driver,"5");

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
}
