package cz.cvut.fel.still.sqa.arastta.tasks;

import cz.cvut.fel.still.sqa.arastta.pageobjects.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static cz.cvut.fel.still.sqa.arastta.pageobjects.ProductPage.ADD_TO_CART_BUTTON;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.ProductPage.PRODUCT_TITLE;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.SearchForm.SEARCH_BUTTON;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.SearchForm.TEXT_FIELD;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.SearchForm.FIRST_SEARCH_RESULT_ELEMENNT;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.ProductPopUp.CONTINUE_SHOPPING_BUTTON;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.ShoppingCartPage.LIST_OF_PRODUCTS_IN_CART;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.HeaderTopLine.SHOPPING_CART_SUMMARY_BLOCK;
import static cz.cvut.fel.still.sqa.arastta.pageobjects.HeaderTopLine.GO_TO_SHOPPING_CART_BUTTON_IN_DROPDOWN;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Maksym Kriventsev
 */

public class SearchTheItems implements Task {

    public static List<String> itemsInCartPage; //= new ArrayList<String>();
    public static String wishedInputItems = "";
    private static List<String> wishedItems = new ArrayList<String>();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private List<String> searchItems;

    public SearchTheItems(List<String> searchItems) {
        this.searchItems = searchItems;
    }

    public static List<String> getItemsInCartPage(Actor actor) {
        System.out.println(LIST_OF_PRODUCTS_IN_CART.toString());
        List<String> allItemsInCartPage = Text.of(LIST_OF_PRODUCTS_IN_CART)
                .viewedBy(actor)
                .asList();
        return allItemsInCartPage;
    }

    public static SearchTheItems called(List<String> searchItems) {
        return instrumented(SearchTheItems.class, (Object) searchItems);
    }

    @Override
    @Step("{0} starts search items in the shop")
    public <T extends Actor> void performAs(T actor) {
        for (String searchItem : searchItems) {
            actor.attemptsTo(
                    Click.on(SEARCH_BUTTON),
                    Enter.theValue(searchItem).into(TEXT_FIELD),
                    Click.on(FIRST_SEARCH_RESULT_ELEMENNT),
                    Click.on(ADD_TO_CART_BUTTON),
                    Click.on(CONTINUE_SHOPPING_BUTTON)
            );
            this.wishedItems.add(Text.of(PRODUCT_TITLE).viewedBy(actor).asString());
        }
        actor.attemptsTo(
                Click.on(SHOPPING_CART_SUMMARY_BLOCK),
                Click.on(GO_TO_SHOPPING_CART_BUTTON_IN_DROPDOWN)
        //        Open.browserOn(shoppingCartPage)
        );
        wishedInputItems = String.join(", ", this.wishedItems);
        itemsInCartPage = getItemsInCartPage(actor);
        System.out.println("final");
    }

}
