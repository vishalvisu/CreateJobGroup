package HomePage;

import Actions.ClickBtn;
import org.openqa.selenium.WebDriver;

public class HomePageActions {

    ClickBtn clickBtn;
    HomePageElements homePageElements;
    public HomePageActions(HomePageElements homePage, WebDriver driver)
    {
        clickBtn=new ClickBtn();
        homePageElements=homePage;

        //Actions
        clickBtn.click(homePage.createClient);
    }
}
