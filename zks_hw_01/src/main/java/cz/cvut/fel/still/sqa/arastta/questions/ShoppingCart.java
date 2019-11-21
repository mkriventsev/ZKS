package cz.cvut.fel.still.sqa.arastta.questions;

import cz.cvut.fel.still.sqa.arastta.tasks.SearchTheItems;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

/**
 * @author Maksym Kriventsev
 */
public class ShoppingCart implements Question<String> {

    @Override
    @Step("Shoping cart should contain the same list of items, as wished")
    public String answeredBy(Actor actor) {
//        try {
//            Text.of(SHOPPING_CART_SUMMARY_BLOCK).wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String cartInfo = Text.of(SHOPPING_CART_SUMMARY_BLOCK).viewedBy(actor).asString();
//        String pattern = "^\\d+";
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(cartInfo);
//        String itemsInCart = m.group(0);
//        System.out.println(itemsInCart);

        return String.join(", ", SearchTheItems.itemsInCartPage);

    }

    public static Question<String> is() {
        return new ShoppingCart();
    }

}
