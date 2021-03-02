package Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EnterKey {

    public void Enter (WebElement element)
    {
        element.sendKeys(Keys.RETURN);
    }
}
