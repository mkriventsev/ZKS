package cz.cvut.fel.still.sqa.arastta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static cz.cvut.fel.still.sqa.arastta.pageobjects.HeaderTopLine.EMPTY_SHOPPING_CART_MESSAGE;

/**
 * @author Maksym Kriventsev
 */
public class EmptyCartMessageInTheHeader implements Question<String> {

    @Override
    @Step("Notification about empty shopping cart in the header presented")
    public String answeredBy(Actor actor) {
        return Text.of(EMPTY_SHOPPING_CART_MESSAGE)
                .viewedBy(actor).asString();
    }

    public static Question<String> isShown() {
        return new EmptyCartMessageInTheHeader();
    }
}
