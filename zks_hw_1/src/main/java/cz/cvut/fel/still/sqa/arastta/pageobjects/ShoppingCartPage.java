package cz.cvut.fel.still.sqa.arastta.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://demo.arastta.org/en/checkout/cart")
public class ShoppingCartPage extends PageObject {
    public static Target EMPTY_SHOPPING_CART_P = Target
            .the("Empty shopping cart label")
            .located(By.xpath("//div[@id=\"content\"]/p[text()=\"Your shopping cart is empty!\"]"));
    public static Target LIST_OF_PRODUCTS_IN_CART = Target
            .the("List of products in cart")
            .located(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"));

}
