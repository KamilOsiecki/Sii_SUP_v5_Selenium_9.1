package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sf-menu>li:nth-of-type(1)>a")
    private WebElement womenCategory;

    @FindBy(css = ".submenu-container>li:nth-of-type(1)>ul>li:nth-child(2)>a")
    private WebElement blousesSubCategory;

    public TopMenuPage moveMouseToWomenCategory(){
        mouseHover(womenCategory);
        return this;
    }
    public TopMenuPage clickOnBlouses(){
        click(blousesSubCategory);
        return this;
    }
}
