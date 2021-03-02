package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Calendar {

    ClickBtn clickBtn;

   public Calendar()
    {
        clickBtn=new ClickBtn();
    }

    public  void setDate (WebDriver driver, String year, String month, String date_of_month, WebElement calender) throws InterruptedException
    {

        clickBtn=new ClickBtn();

        clickBtn.click(calender);

        Thread.sleep(2000);
        WebElement Calender=  driver.findElement(By.tagName("mat-calendar"));

        List<WebElement> btns=Calender.findElements(By.tagName("button"));

        System.out.println(btns.size());

        //First button is for changing range
        btns.get(0).click();

        Thread.sleep(2000);



        select_Year_Month_Date (driver,year);
        select_Year_Month_Date (driver,month);
        select_Year_Month_Date (driver,date_of_month);

    }

    public  void  select_Year_Month_Date (WebDriver driver, String value) throws InterruptedException
    {

        List<WebElement> table= driver.findElements(By.className("mat-calendar-body-cell-content"));

        System.out.println("year "+table.size());
        for(WebElement e: table)
        {
            if(e.getText().compareTo(value)==0)
            {
                clickBtn.click(e);
                Thread.sleep(1000);
                return;
            }
        }
    }

}
