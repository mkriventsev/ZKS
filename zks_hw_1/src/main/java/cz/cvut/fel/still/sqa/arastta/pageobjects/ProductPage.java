package cz.cvut.fel.still.sqa.arastta.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * @author Maksym Kriventsev
 */
public class ProductPage extends PageObject {
    public static Target ADD_TO_CART_BUTTON = Target
            .the("Add cart button on the product page")
            .locatedBy("#button-cart");
    public static Target PRODUCT_TITLE = Target
            .the("title of product")
            .locatedBy("//h1");
}
//<button type="button" id="button-cart" data-loading-text="Loading..." class="btn btn-primary btn-lg btn-block">Add to Cart</button>
