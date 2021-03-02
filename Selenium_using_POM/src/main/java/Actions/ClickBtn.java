package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickBtn {



   public ClickBtn()
    {

    }
    public void click(WebElement elemnt)
    {
        System.out.println("clicked");
      elemnt.click();
    }

}
