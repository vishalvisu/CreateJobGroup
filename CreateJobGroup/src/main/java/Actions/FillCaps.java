package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FillCaps {

    WebDriver driver;

    public FillCaps(WebDriver Driver)
    {
        driver=Driver;
    }

    public void handleCaps( WebElement cap)
    {
        WebElement body= cap.findElement(By.className("body"));

        List<WebElement> radioButtons= body.findElements(By.tagName("mat-radio-button"));

        for(WebElement e:radioButtons) {
            if(e.getText().equalsIgnoreCase("monthly"))
                e.click();
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


}
