package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CapsAtJobLevel {

    WebDriver driver;
    FillCaps fillCaps;
    ClickBtn  clickBtn;

    public CapsAtJobLevel(WebDriver Driver)
    {
        driver=Driver;
        clickBtn= new ClickBtn();
        fillCaps= new FillCaps(driver);
    }

    public  void SetCaps(WebElement element)
    {

        WebElement form=  element.findElement(By.tagName("mat-card"));

        List<WebElement> rows= form.findElements(By.xpath("*"));

        WebElement applyCapsAtJobLevel= rows.get(7).findElement(By.tagName("mat-checkbox"));

        clickBtn.click(applyCapsAtJobLevel);

        WebElement caps= driver.findElements(By.className("caps-group")).get(1);

        List<WebElement> list= caps.findElements(By.className("job-group-form__caps"));


        List<WebElement> job_caps= driver.findElements(By.className("cap"));

        //BUDGET CAP
        fillCaps.handleCaps(job_caps.get(0));

        //CLICK CAPS
        fillCaps.handleCaps(job_caps.get(1));

        //AppliesCap
        fillCaps.handleCaps(job_caps.get(2));

    }

}
