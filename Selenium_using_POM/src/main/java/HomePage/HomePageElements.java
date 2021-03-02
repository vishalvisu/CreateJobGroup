package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageElements {

    WebDriver driver;
    public HomePageElements(WebDriver Driver)
    {
        driver=Driver;
    }
    @FindBy(how = How.CLASS_NAME,using = "create-button")
    WebElement createClient;
}
