package EnterJobGroupDetails;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateJobGroupFormWebElements {

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='name']")
    WebElement JobGroupName;

    //DropDowmn
    @FindBy(how = How.XPATH,using = "//mat-select[@formcontrolname='campaignId']")
    WebElement CampaignName ;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='startDate']")
    WebElement StartDate ;


    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='endDate']")
    WebElement EndDate ;

    @FindBy(how = How.TAG_NAME,using = "jv-jobs-filter")
    WebElement JobsFilter ;

    @FindBy(how = How.XPATH,using = "//div[@formarrayname='ioDetails']")
    WebElement IoDetails ;

    @FindBy(how = How.XPATH,using = "//mat-select[@formcontrolname='priority']")
    WebElement Priority ;

    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Next')]")
    WebElement GoToNxtPage ;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='cpcBid']")
    WebElement cpcBid ;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='cpaBid']")
    WebElement cpaBid ;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='cpcTargeting']")
    WebElement cpcTargeting ;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='cpaTargeting']")
    WebElement cpaTargeting ;

    @FindBy(how = How.CLASS_NAME,using = "campaign-form")
    WebElement applyCapsAtJobLevel ;

    @FindBy(how = How.CLASS_NAME,using = "campaign-form")
    WebElement limitJobsSentToPublisher ;

    @FindBy(how = How.CLASS_NAME,using = "campaign-form")
    WebElement submit ;


}
