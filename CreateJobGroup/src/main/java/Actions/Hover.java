package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hover {

    public void hovering (WebDriver driver,WebElement element)
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }
}
