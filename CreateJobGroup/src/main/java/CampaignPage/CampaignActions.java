package CampaignPage;

import Actions.*;
import HomePage.HomePageWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampaignActions {

    WebDriver driver;
    CampaignWebElements campaignWebElements;
    Hover hover;
    ClickBtn clickBtn;
    InputText inputText;
    SearchDataTable searchDataTable;
    EnterKey enterKey;



    public CampaignActions(CampaignWebElements page,WebDriver Driver,String clientName) throws InterruptedException {

        driver= Driver;
        campaignWebElements =page;
        hover=new Hover();
        clickBtn= new ClickBtn();
        inputText=new InputText();
        enterKey=new EnterKey();
        searchDataTable=new SearchDataTable();
        //definition of search field

        //Actions

        //before searching specific client remove Default
        // 'clients with Activity' Filter
        hover.hovering(driver,campaignWebElements.activity);
        clickBtn.click(campaignWebElements.clearActivity);

        //Click On Search-Icon
        clickBtn.click(campaignWebElements.search_icon);

        //Search Field is Visible After click on Search Icon
        // That's Why we can access after only click on Search Icon

        Thread.sleep(2000);
        campaignWebElements.searchField= driver.findElements(By.tagName("input")).get(2);

        //Enter in Search Field
        inputText.enterText(campaignWebElements.searchField,clientName);

        //Enter Key
        enterKey.Enter(campaignWebElements.searchField);

        Thread.sleep(2000);

        // System.out.println("tables "+driver.findElement(By.className("entity__datatable")).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size());

        //Search entity-data-table (client,campaign or jobGroup)
        searchDataTable.Search(campaignWebElements.data_table,clientName);


    }



}
