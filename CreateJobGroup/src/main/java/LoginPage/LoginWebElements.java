package LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginWebElements {

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='email']")
    WebElement username;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='password']")
    WebElement password;

    @FindBy(how = How.XPATH,using = "//button[@type='submit']")
    WebElement submit;

}
