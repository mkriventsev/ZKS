package cz.cvut.fel.still.sqa.arastta.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * @author Maksym Kriventsev
 */
public class ProductPopUp extends PageObject {
    public static Target CONTINUE_SHOPPING_BUTTON = Target
            .the("continue button to close the confirmation pop up")
            .locatedBy("//div[@class=\"buttons\"]//a[@class=\"button-continue\"]");
}
//<button type="button" id="button-cart" data-loading-text="Loading..." class="btn btn-primary btn-lg btn-block">Add to Cart</button>
