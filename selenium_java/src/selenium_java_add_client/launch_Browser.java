package selenium_java_add_client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class launch_Browser {

	//public static WebDriver driver=null ; 
	
	static  int sleep_time=1000;
    static List<WebElement> list[];
	
	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");		
    
    WebDriver driver= new ChromeDriver();
    NgWebDriver ngdriver;
    JavascriptExecutor jsdriver;
    
    jsdriver= (JavascriptExecutor) driver;
    ngdriver= new NgWebDriver(jsdriver) ;
    WebElement parent,prv = null;
    
   
    
     driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
     
     driver.get("https://mojo2.joveo.com/clients");
     
       driver.manage().window().maximize();
       
       driver.findElement(By.id("mat-input-0")).sendKeys("reliability@joveo.com");
       
       driver.findElement(By.id("mat-input-1")).sendKeys("joveo1520");
      
    /*   WebElement ChkBox=  driver.findElement(By.cssSelector("#mat-checkbox-1>label>div"));;
       
       if(ChkBox.isSelected())
    	   ChkBox.click();*/
       
      
       
       driver.findElement(By.className("mat-raised-button")).click();;
     //  ngdriver.waitForAngularRequestsToFinish();
      
      
     try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         
     
     System.out.println(driver.getCurrentUrl());
     
     driver.findElement(By.className("create-button")).click();
       
     //ngdriver.waitForAngularRequestsToFinish();
     
     Thread.sleep(2000);
     
     
    WebElement form=   driver.findElement(By.className("client-container"));
      
     
   //  System.out.println(form.findElements(By.className("grid-container")).size());
    
    List<WebElement> childs = form.findElements(By.xpath("./child::*"));

   // List<ArrayList<WebElement>> list = new ArrayList<ArrayList<WebElement>>();
    
    int row=1;
    for (WebElement e  : childs)
    {
    	List<WebElement> list= new ArrayList<WebElement>();
    	
       // System.out.println(e.findElements(By.tagName("input")).size());
        
    	list=  e.findElements(By.tagName("input"));
        
        
      //  System.out.println(list.size());
             //cnt++;
         
        if(row==1)
        {	
        	list.get(0).sendKeys("ABC");
            list.get(1).sendKeys("DEF");
            
        }
        if(row==2)
        {
        	list.get(0).sendKeys("GHI");
        	
        	e.findElement(By.tagName("jv-multiselect")).click();
        	searchDropdownComboExecutor ("mat-select-content",driver);
        	
        	
        }
        if(row==3)
        {
        	e.findElement(By.tagName("jv-multiselect")).click();
        	searchDropdownComboExecutor ("mat-select-content",driver);
        	list.get(0).sendKeys("www.google.com");
        //	break;
        }
        
      
        if(row==4)
        {
        	list=  e.findElements(By.tagName("mat-form-field"));
        	
        	
        	list.get(0).click(); 
        	DropDownExecutor ("mat-select-content",driver,"6");
        	
        	Thread.sleep(sleep_time);
        	list.get(1).click(); 
        	DropDownExecutor ("mat-select-content",driver,"25");
        	
        	
        }
        if(row==5)
        {
        	list.get(0).sendKeys(" https://joveo-samplefeed.s3.amazonaws.com/abhinay/AbSample.xml");
           List<WebElement> btns=e.findElements(By.tagName("button"));
        	
            //System.out.println(list.size());
            
           btns.get(0).click();
            
           // for(WebElement e3: list)
            //	System.out.println(e3.getText());
            
        }
       
        if(row==8)
        {
        	// SCROLL-DOWN METHOD-1
        //	 jsdriver.executeScript("arguments[0].scrollIntoView();",e);
        	
        	//SCROLL-DOWN METHOD-2
        	//while(!e.isDisplayed())
        	//	prv.sendKeys(Keys.PAGE_DOWN);
        	
        		
        	e.findElement(By.tagName("jv-multiselect")).click();
        	Thread.sleep(sleep_time);
        	
        	searchDropdownComboExecutor ("mat-select-content",driver);
        	list.get(0).sendKeys("8877");
        }
        
        if(row==9)
        {
            list= e.findElements(By.tagName("mat-form-field"));
        
          WebElement st_elmnt = list.get(0).findElement(By.tagName("input"));
          WebElement end_elmnt = list.get(1).findElement(By.tagName("input"));
          
          
         // String start_date="20/03/2021",end_date="23/08/2022";
          
          setDate(st_elmnt,driver,"2022","FEB","17");
          Thread.sleep(sleep_time);
          
          setDate(end_elmnt,driver,"2024","SEP","27");
           }
        
        if(row==10)
        {
        	e.findElement(By.tagName("jv-multiselect")).click();
        	searchDropdownComboExecutor ("mat-select-content",driver);
        	break;
        }
        
        
       //  prv=e;
        
        row++;
    }
    
    
       
    
   
   
   
 }
	
	public static void setDate (WebElement elmnt,WebDriver driver,String year,String month,String date_of_month) throws InterruptedException
	{
            elmnt.click();
            
            Thread.sleep(sleep_time);
       WebElement Calender=  driver.findElement(By.tagName("mat-calendar"));
         
         List<WebElement> btns=Calender.findElements(By.tagName("button"));
         
         System.out.println(btns.size());
         
         btns.get(0).click();
         
         Thread.sleep(sleep_time);
        
          
         selectYearMonthDate (driver,year);
         selectYearMonthDate (driver,month);  
         selectYearMonthDate (driver,date_of_month);    
         //  btn.click();
		
		
		//jsdriver.executeScript("arguments[0].setAttribute('value'+'"+date+"');",elmnt);
	}
  	
	public static void selectYearMonthDate (WebDriver driver,String value) throws InterruptedException
	{
      
		List<WebElement> table= driver.findElement(By.tagName("table")).findElements(By.tagName("div"));
        
       // System.out.println(years.size());
           for(WebElement e: table)
         {
        	     if(e.getText().compareTo(value)==0)
              {
        	    	 e.click();
        	    	 Thread.sleep(sleep_time);
        	    	 break;
                }

         }
	}
	
	
	
  public static void DropDownExecutor (String CLASS,WebDriver driver,String value) throws InterruptedException
  {
	  List<WebElement> list= new ArrayList<WebElement>();
	  
	  Thread.sleep(sleep_time);
  	list=driver.findElements(By.tagName("span"));
  	
  	for(WebElement e3:list)
  	{
  		if(e3.getText().contains(value))
  		{
  			e3.click();
  			break;
  		}
  	//	System.out.println(e3.getText());
  	}
  
  }
	
	
	public static void searchDropdownComboExecutor (String CLASS,WebDriver driver) throws InterruptedException
	{
		WebElement parent;
		List<WebElement> list= new ArrayList<WebElement>();
		
		Thread.sleep(sleep_time);
		parent=driver.findElement(By.className(CLASS));
    	parent.findElement(By.tagName("input")).sendKeys("H");
    	
     	list=driver.findElements(By.tagName("mat-option"));
    	
    	for(WebElement e1: list)
    	{
    		if(e1.isDisplayed())
    		{
    			e1.click();
    			//ngdriver.waitForAngularRequestsToFinish();
    			 Thread.sleep(sleep_time);	 
    	     	break;
    		}
    	}
	}

}
