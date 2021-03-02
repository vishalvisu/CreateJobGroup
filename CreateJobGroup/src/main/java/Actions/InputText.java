package Actions;

import org.openqa.selenium.WebElement;

public class InputText {



    public InputText()
    {
    }

    public  void enterText(WebElement elmnt, String text)
    {
        elmnt.sendKeys(text);
    }
}
