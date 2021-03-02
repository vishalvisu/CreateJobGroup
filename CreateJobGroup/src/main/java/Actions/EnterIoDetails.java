package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EnterIoDetails {

    WebDriver driver;
    Calendar calendar;

  public  EnterIoDetails(WebDriver Driver)
    {
        driver=Driver;
        calendar= new Calendar();
    }

    public void enterIoDetails(WebElement ioDetails) throws InterruptedException {
        WebElement createIoDetails= ioDetails.findElement(By.className("job-group-form__ioDetails-actions"));
        WebElement createIoDetails_BTN=createIoDetails.findElement(By.tagName("button"));

        for(int i=0;i<1;i++) {
            createIoDetails_BTN.click();
            Thread.sleep(500);
        }

        //Fill_IO_Details
        //Update ioDetails as new fields may be created as in above loop
        ioDetails= driver.findElement(By.xpath("//div[@formarrayname='ioDetails']"));

        int noOfIODetails = ioDetails.findElements(By.className("job_group_form__iodetails")).size();


        System.out.println(noOfIODetails);

        List<WebElement> list_of_Io_Details= ioDetails.findElements(By.className("job_group_form__iodetails"));

        System.out.println(list_of_Io_Details.size());

        for(WebElement e:list_of_Io_Details)
        {
            WebElement iodetail= e;
            //Enter IO Number
            iodetail.findElement(By.xpath(".//input[@formcontrolname='number']")).sendKeys("45567");

            //Enter Amount
            iodetail.findElement(By.xpath(".//input[@formcontrolname='value']")).clear();
            iodetail.findElement(By.xpath(".//input[@formcontrolname='value']")).sendKeys("1000");

            //Set-Io-Start-Date
            WebElement IO_start_date= iodetail.findElement(By.xpath(".//input[@formcontrolname='startDate']"));

            calendar.setDate(driver,"2023","MAR","22",IO_start_date);
            // Thread.sleep(sleep_time);

            //Set-Io-End-Date
            WebElement IO_end_date= iodetail.findElement(By.xpath(".//input[@formcontrolname='endDate']"));
            calendar.setDate(driver,"2027","DEC","13",IO_end_date);

        }
    }

}
