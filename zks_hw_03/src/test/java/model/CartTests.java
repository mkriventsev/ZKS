package model;

import model.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Maksym Kriventsev
 */

@DisplayName("Pass the method parameters provided by the @CsvFileSource annotation")
class CartTests {

    @DisplayName("Cart test")
    @ParameterizedTest(name = "containsAlcoholOrTobacco - \"{0}\" and price - {2}")
    @CsvFileSource(resources = "/cart-test-output.csv", numLinesToSkip = 1)
    void exceptionTesting(Boolean containsAlcoholOrTobacco, String message, Float price) {
        if (containsAlcoholOrTobacco == null || price == null || price < 50) {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class, () -> {
                        Cart cart = new Cart(price, containsAlcoholOrTobacco);
                    }
            );
            assertEquals(message, exception.getMessage());
            System.out.println(exception.getMessage());
        } else {
            Cart cart = new Cart(price, containsAlcoholOrTobacco);
            assertEquals(cart.getPrice(), price);
            assertEquals(cart.getContainsAlcoholOrTobacco(), containsAlcoholOrTobacco);
            System.out.println(message);
        }
    }
}
