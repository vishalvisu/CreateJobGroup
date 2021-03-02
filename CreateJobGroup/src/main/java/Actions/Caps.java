package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Caps {

    WebDriver driver;
    FillCaps fillCaps;

    public Caps(WebDriver Driver)
    {
        driver=Driver;
        fillCaps= new FillCaps(driver);
    }

    public  void SetCaps(WebDriver driver)
    {

        List<WebElement> caps= driver.findElements(By.className("cap"));

        //BUDGET CAP
        fillCaps.handleCaps(caps.get(0));

        //CLICK CAPS
        fillCaps.handleCaps(caps.get(1));

        //AppliesCap
        fillCaps.handleCaps(caps.get(2));

    }




}
