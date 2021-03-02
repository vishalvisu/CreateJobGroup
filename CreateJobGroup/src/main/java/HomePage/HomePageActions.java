package HomePage;

import Actions.*;
import LoginPage.LoginWebElements;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.Callable;

public class HomePageActions {

    WebDriver driver;
    HomePageWebElements homePageWebElements;
    Hover hover;
    ClickBtn clickBtn;
    InputText inputText;
    SearchDataTable searchDataTable;
    EnterKey enterKey;

    public HomePageActions(HomePageWebElements page,WebDriver Driver,String clientName) throws InterruptedException {
        driver= Driver;
        homePageWebElements=page;

        hover=new Hover();
        clickBtn= new ClickBtn();
        inputText=new InputText();
        enterKey=new EnterKey();
        searchDataTable=new SearchDataTable();
        //definition of search field

        //Actions

        //before searching specific client remove Default
        // 'clients with Activity' Filter
        hover.hovering(driver,homePageWebElements.activity);
       clickBtn.click(homePageWebElements.clearActivity);

       //Click On Search-Icon
       clickBtn.click(homePageWebElements.search_icon);

         //Search Field is Visible After click on Search Icon
        // That's Why we can access after only click on Search Icon

        Thread.sleep(2000);
        homePageWebElements.searchField= driver.findElements(By.tagName("input")).get(2);

        //Enter in Search Field
       inputText.enterText(homePageWebElements.searchField,clientName);

       //Enter Key
        enterKey.Enter(homePageWebElements.searchField);

        Thread.sleep(2000);

      // System.out.println("tables "+driver.findElement(By.className("entity__datatable")).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size());

       //Search entity-data-table (client,campaign or jobGroup)
         searchDataTable.Search(homePageWebElements.data_table,clientName);


    }


}
