package tests.menu;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.menu.TopMenuPage;
import pages.product.ProductPage;
import pages.product.ProductQuickViewPage;
import steps.UserSteps;

public class TopMenuTest extends TestBase {

    @Test
    @DisplayName("TopMenuTest")
    @Tag("TopMenu")
    public void shouldVerifyTopMenuPage(){

        at(TopMenuPage.class)
                .moveMouseToWomenCategory()
                .clickOnBlouses();

        at(ProductPage.class)
                .moveMouseToBlouseProduct()
                .goToQuickView();

        at(ProductQuickViewPage.class)
                .switchToQuickViewPage();

        userSteps.verifyProductImage();
    }
}