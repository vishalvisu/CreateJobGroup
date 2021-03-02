package Actions;

// entity-data-table (client,campaign or jobGroup)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchDataTable {


    public  void Search(WebElement dataTable,String name)
    {

        System.out.println(dataTable.getTagName());
        List<WebElement> trElements = dataTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));


        int row = 0;

        for (WebElement e : trElements) {

          /*  if (row < 2) {
                row++;
                continue;
            }
            if (list.size() < 5)
                continue;*/

            List<WebElement> list = e.findElements(By.tagName("td"));

            String clientNameString = list.get(2).getText();

            System.out.println(clientNameString);

            if (clientNameString.compareToIgnoreCase(name) == 0) {

                e.findElement(By.linkText(clientNameString)).click();

                return;
            }
        }
        return ;

    }

}
