package LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInElements {

   @FindBy(how = How.ID,using = "mat-input-0")
    WebElement username;

    @FindBy(how = How.ID,using = "mat-input-1")
    WebElement password;

    @FindBy(how = How.CLASS_NAME,using = "mat-raised-button")
    WebElement submit;
}
