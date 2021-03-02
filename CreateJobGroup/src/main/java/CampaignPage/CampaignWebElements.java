package CampaignPage;

import Actions.*;
import HomePage.HomePageWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CampaignWebElements {

    @FindBy(how = How.CLASS_NAME,using = "first-last-rule")
    WebElement activity;

    @FindBy(how = How.CLASS_NAME,using = "remove-btn")
    WebElement clearActivity;

    @FindBy(how = How.CLASS_NAME,using = "search-icon")
    WebElement search_icon;

    WebElement searchField;

    @FindBy(how = How.CLASS_NAME,using = "entity__datatable")
    WebElement data_table;

}
