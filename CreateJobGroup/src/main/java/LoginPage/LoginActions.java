package LoginPage;

import Actions.ClickBtn;
import Actions.InputText;
import org.openqa.selenium.WebDriver;

public class LoginActions {

    WebDriver driver;
    LoginWebElements loginPage;
    ClickBtn clickBtn;
    InputText inputText;

    public LoginActions(LoginWebElements page,WebDriver Driver,String username,String password)
    {
        driver= Driver;
        loginPage=page;
        clickBtn= new ClickBtn();
        inputText=new InputText();

        //Actions
        inputText.enterText(loginPage.username,username);
        inputText.enterText(loginPage.password,password);
        clickBtn.click(page.submit);
    }


}
