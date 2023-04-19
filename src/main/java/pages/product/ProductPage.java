package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product_img_link")
    private WebElement productImage;

    @FindBy(css = ".quick-view")
    private WebElement quickView;

    public ProductPage moveMouseToBlouseProduct() {
        mouseHover(productImage);
        return this;
    }

    public ProductPage goToQuickView() {
        click(quickView);
        return this;
    }
}
