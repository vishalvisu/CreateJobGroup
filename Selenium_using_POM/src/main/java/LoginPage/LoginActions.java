package LoginPage;

import Actions.ClickBtn;
import Actions.InputText;
import org.openqa.selenium.WebDriver;

public class LoginActions {

    WebDriver driver;
    LogInElements loginPage;
    ClickBtn clickBtn;
    InputText inputText;

   public LoginActions(LogInElements page,WebDriver Driver)
    {
        driver= Driver;
        loginPage=page;
        clickBtn= new ClickBtn();
        inputText=new InputText();

        //Actions
        inputText.enterText(loginPage.username,"reliability@joveo.com");
        inputText.enterText(loginPage.password,"joveo1520");
        clickBtn.click(page.submit);
    }


    //Actions

}
