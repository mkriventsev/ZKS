package cz.cvut.fel.still.sqa.arastta.tasks;

import cz.cvut.fel.still.sqa.arastta.pageobjects.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Maksym Kriventsev
 */

public class StartWith implements Task {
    //ShopHomePage shopHomePage;
    ShoppingCartPage shoppingCartPage;

    public static StartWith anEmptyShoppingCart() {
        return instrumented(StartWith.class);
    }

    @Override
    @Step("{0} starts with an empty shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(shoppingCartPage)
        );
    }
}