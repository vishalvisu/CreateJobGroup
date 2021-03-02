package Base;

import HomePage.HomePageActions;
import HomePage.HomePageElements;
import LoginPage.LogInElements;
import LoginPage.LoginActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {


    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver=new ChromeDriver();

        chromeDriver.get("https://mojo2.joveo.com/login");

        LogInElements loginpage= PageFactory.initElements(chromeDriver,LogInElements.class);
        new LoginActions(loginpage,chromeDriver);

        new WebDriverWait(chromeDriver,2000).until(ExpectedConditions.urlContains("client"));

        HomePageElements homePageElements=PageFactory.initElements(chromeDriver,HomePageElements.class);
        new HomePageActions(homePageElements,chromeDriver);


    }


}
