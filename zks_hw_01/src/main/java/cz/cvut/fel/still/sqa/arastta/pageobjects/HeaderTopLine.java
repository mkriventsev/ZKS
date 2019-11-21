package cz.cvut.fel.still.sqa.arastta.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Maksym Kriventsev
 */
public class HeaderTopLine extends PageObject {

    public static Target SHOPPING_CART_SUMMARY_BLOCK = Target
            .the("Shopping cart summary block open dropdown button")
            .locatedBy("//*[@id=\"cart-total\"]");

    public static Target SHOPPING_CART_OPEN_DROPDOWN = Target
            .the("Button to open shopping cart dropdown")
            .locatedBy("//*[@id=\"cart\"]/button");

    public static Target SHOPPING_CART_DROPDOWN = Target
            .the("dropdown with list of products in shopping cart")
            .locatedBy("//*[@id=\"cart\"]/ul");

    public static Target GO_TO_SHOPPING_CART_BUTTON_IN_DROPDOWN = Target
            .the("go to shopping cart page button")
            .locatedBy("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]");

    public static Target EMPTY_SHOPPING_CART_MESSAGE = Target
            .the("Shopping cart block at the header")
            .locatedBy("//div[@id=\"cart\"]//p[text()=\"Your shopping cart is empty!\"]");
}
