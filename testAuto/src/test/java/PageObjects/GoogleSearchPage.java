package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {
    //ToDo:store all google page objects/web elements
    @FindBy(name="q")
    private static WebElement searchBar;

    @FindBy(name="btnK")
    private static WebElement searchButton;

    public static void searchFor(String keyword) {
        searchBar.clear();
        searchBar.sendKeys(keyword);
        searchButton.click();

    }



}
