package EnterJobGroupDetails;

import Actions.*;
import HomePage.HomePageWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateJobGroupActions {

    WebDriver driver;
    CreateJobGroupFormWebElements createJobGroupFormWebElements;
    ClickBtn clickBtn;
    InputText inputText;
    DropDown dropDown;
    Calendar calendar;
    JobFilter jobFilter;
    EnterIoDetails enterIoDetails;
    Caps caps;
    CapsAtJobLevel capsAtJobLevel;
    LimitJobsSentaToPubs limitJobsSentaToPubs;
    MediaPlanner mediaPlanner;

    public CreateJobGroupActions(CreateJobGroupFormWebElements page, WebDriver Driver) throws InterruptedException {

        driver = Driver;

        // Action Instances
        createJobGroupFormWebElements = page;
        clickBtn = new ClickBtn();
        inputText = new InputText();
        dropDown= new DropDown();
        calendar= new Calendar();
        jobFilter= new JobFilter(Driver);
        enterIoDetails=new EnterIoDetails(driver);
        caps= new Caps(driver);
        capsAtJobLevel= new CapsAtJobLevel(driver);
        limitJobsSentaToPubs=new LimitJobsSentaToPubs(driver);
        mediaPlanner= new MediaPlanner(driver);
        //definition of search field

        //ACTION-Methods
        inputText.enterText(createJobGroupFormWebElements.JobGroupName,"abc");

        dropDown.dropDown(createJobGroupFormWebElements.CampaignName,driver,"c1");

        calendar.setDate(driver,"2021","MAR","17",createJobGroupFormWebElements.StartDate);

        calendar.setDate(driver,"2027","DEC","25",createJobGroupFormWebElements.EndDate);

        jobFilter.JobsFilter(createJobGroupFormWebElements.JobsFilter);

        enterIoDetails.enterIoDetails(createJobGroupFormWebElements.IoDetails);

        dropDown.dropDown(createJobGroupFormWebElements.Priority,driver,"5");

        clickBtn.click(createJobGroupFormWebElements.GoToNxtPage);

        //Bids
        inputText.enterText(createJobGroupFormWebElements.cpcBid,"1");
        inputText.enterText(createJobGroupFormWebElements.cpaBid,"2");


        //Trading Goals
        inputText.enterText(createJobGroupFormWebElements.cpcTargeting,"1");
        inputText.enterText(createJobGroupFormWebElements.cpaTargeting,"2");

        //CAPS(Default)
        caps.SetCaps(driver);

        //CAPS(JOB_LEVEL)
        capsAtJobLevel.SetCaps(createJobGroupFormWebElements.applyCapsAtJobLevel);

        //Limit JOBS sent To pubs
        limitJobsSentaToPubs.limitJobs(createJobGroupFormWebElements.limitJobsSentToPublisher);

        //MediaPlanner
        mediaPlanner.mediaPlanner();

        //SUBMIT
        //GET SUBMIT BUTTON FROM A LIST OF BUTTONS(Previous,Cancel,Submit)
        WebElement parent=createJobGroupFormWebElements.submit.findElements(By.xpath("*")).get(1);
        WebElement submit= parent.findElements(By.tagName("button")).get(2);

        clickBtn.click(submit);
    }
}