package JobGroupPageWebElements;

import Actions.*;
import HomePage.HomePageWebElements;
import org.openqa.selenium.WebDriver;

public class JobGroupActions {

    WebDriver driver;
    JobGroupWebElements jobGroupWebElements;
    ClickBtn clickBtn;


    public JobGroupActions(JobGroupWebElements page,WebDriver Driver) throws InterruptedException {
        driver = Driver;
        jobGroupWebElements = page;

        clickBtn = new ClickBtn();


        //ACTIONS
        clickBtn.click(jobGroupWebElements.createJobGroup);



       }


}
