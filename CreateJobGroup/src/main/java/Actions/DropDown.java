package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {


    public void dropDown (WebElement parent, WebDriver driver,String value) throws InterruptedException {
        parent.click();

        Thread.sleep(500);

        List<WebElement> options= driver.findElements(By.tagName("mat-option"));

        for(WebElement e:options) {
            if (e.getText().equalsIgnoreCase(value)) {
                e.click();
                return;
            }
        }
    }
}
