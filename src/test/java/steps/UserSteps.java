package steps;

import base.TestBase;
import org.assertj.core.api.Assertions;
import pages.product.ProductQuickViewPage;

public class UserSteps extends TestBase {

    public void  verifyProductImage(){

        for (int i=0; i< at(ProductQuickViewPage.class).productImagesSize(); i++){

            at(ProductQuickViewPage.class)
                    .moveToProductImage(i);

            String smallProductImageLink = at(ProductQuickViewPage.class).getProductImageLink(i);
            String bigProductImageLink = at(ProductQuickViewPage.class).getBigPictureLink();

            Assertions.assertThat(smallProductImageLink).isEqualTo(bigProductImageLink);
        }
    }
}