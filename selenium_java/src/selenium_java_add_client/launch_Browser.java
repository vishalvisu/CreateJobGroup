package selenium_java_add_client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class launch_Browser {

	//public static WebDriver driver=null ; 
	
	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");		
    
    WebDriver driver= new ChromeDriver();
     
     driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
     
     driver.get("https://mojo2.joveo.com/clients");
     
       driver.manage().window().maximize();
       
       driver.findElement(By.id("mat-input-0")).sendKeys("reliability@joveo.com");
       
       driver.findElement(By.id("mat-input-1")).sendKeys("joveo1520");
       
       driver.findElement(By.className("mat-raised-button")).click();;
       
  //     WebElement ChkBox=  driver.findElement(By.id("mat-checkbox-1"));
       
    //   if(ChkBox.isSelected())
    //	   ChkBox.click();
       
       
     try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     System.out.println(driver.getCurrentUrl());
     
     driver.findElement(By.className("create-button")).click();
       
     Thread.sleep(1000);
     
     System.out.println(driver.getCurrentUrl());
     
     
     driver.findElement(By.id("mat-input-4")).sendKeys("abc");;
     
     driver.findElement(By.id("mat-input-5")).sendKeys("abc");
     
     driver.findElement(By.id("mat-input-6")).sendKeys("abc");
     
  
   
   //  Thread.sleep(2000);
     
  // driver.findElement(By.cssSelector("#cdk-overlay-1 > div > div > div > input")).sendKeys("KOL");
   
 //  Thread.sleep(5000);
   
      
 

//   for (WebElement e  : childs)
  // {
 //      System.out.println(e.getTagName());
 //  }   
       
  //   Thread.sleep(5000);
    //      driver.close(); 
     //System.out.print(childs.size());
     
	}

}
