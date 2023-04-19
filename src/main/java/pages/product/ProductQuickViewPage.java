package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ProductQuickViewPage extends BasePage {
    public ProductQuickViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".fancybox-iframe")
    private WebElement productIframe;
    @FindBy(css = "#thumbs_list>ul>li")
    private List<WebElement> productImages;

    @FindBy(css = "#thumbs_list>ul>li>a")
    private List<WebElement> productImagesLink;

    @FindBy(css = "#bigpic")
    private WebElement bigPictureLink;

    public int productImagesSize() {
        return productImages.size();
    }

    public String getProductImageLink(int i) {
        return productImagesLink.get(i).getAttribute("href").substring(0, 38);
    }

    public String getBigPictureLink() {
        return bigPictureLink.getAttribute("src").substring(0, 38);
    }

    public ProductQuickViewPage switchToQuickViewPage() {
        driver.switchTo().frame(productIframe);
        return this;
    }

    public ProductQuickViewPage moveToProductImage(int i) {
        mouseHover(productImages.get(i));
        return this;
    }
}