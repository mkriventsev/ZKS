package cz.cvut.fel.still.sqa.arastta;

import cz.cvut.fel.still.sqa.arastta.questions.EmptyCartMessageInTheHeader;
import cz.cvut.fel.still.sqa.arastta.questions.EmptyCartMessageOnCartPage;
import cz.cvut.fel.still.sqa.arastta.questions.ShoppingCart;
import cz.cvut.fel.still.sqa.arastta.tasks.SearchTheItems;
import cz.cvut.fel.still.sqa.arastta.tasks.StartWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Maksym Kriventsev
 */
@RunWith(SerenityRunner.class)
public class AddProductsToShoppingCart {
    private Actor max = Actor.named("Maksym");

    @Managed
    private
    WebDriver theBrowser;// = driver;
    private List<String> searchItems = Arrays.asList("AEO", "Polo", "Khaki");

    @Before
    public void maxCanBrowseTheWeb() {
        givenThat(max).can(BrowseTheWeb.with(theBrowser));
    }

//    @Order(1)
//    @Test
//    public void should_have_empty_shopping_cart() {
//        givenThat(max).wasAbleTo(StartWith.anEmptyShoppingCart());
//        then(max).should(seeThat(EmptyCartMessageOnCartPage.isExists()));
////        then(max).should(seeThat(EmptyCartMessageInTheHeader.isShown()));
//    }

    @Order(2)
    @Test
    public void should_be_able_to_buy_three_items() {
        givenThat(max).wasAbleTo(StartWith.anEmptyShoppingCart());
        when(max).attemptsTo(SearchTheItems.called(searchItems));
        then(max).should(seeThat(ShoppingCart.is(), equalTo(SearchTheItems.wishedInputItems)));
    }

    @After
    public void maxCanCleanShoppingCart() {
        givenThat(max).can(BrowseTheWeb.with(theBrowser));
    }

}
