package cz.cvut.fel.still.sqa.arastta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import static cz.cvut.fel.still.sqa.arastta.pageobjects.ShoppingCartPage.EMPTY_SHOPPING_CART_P;

/**
 * @author Maksym Kriventsev
 */
public class EmptyCartMessageOnCartPage implements Question<String> {
    @Override
    @Step("Text about empty shopping cart.")
    public String answeredBy(Actor actor) {
        return Text.of(EMPTY_SHOPPING_CART_P)
                .viewedBy(actor).asString();
    }

    public static Question<String> isExists() {
        return new EmptyCartMessageOnCartPage();
    }
}
