package Base_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver=null;


     public static void main(String args[])
     {
         setUpWebDriver();
         lanchBrowser();
    //     Login();
      //   NavigateToCreateJobGroupPage();
     }

     public static void setUpWebDriver()
     {
         WebDriverManager.chromedriver().setup();

         driver=new ChromeDriver();

         driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     }

     public static void lanchBrowser()
     {
         driver.get("https://mojo2.joveo.com/clients");
         driver.manage().window().maximize();
     }







}
