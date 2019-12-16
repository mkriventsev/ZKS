package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Maksym Kriventsev
 */

@DisplayName("Pass the method parameters provided by the @CsvFileSource annotation")
class OrderTests {

    @DisplayName("Order test")//state,addressInState,message
    @ParameterizedTest(name = "fullName - {0},state - {1},addressInState - {2},phoneNumber - {3},age - {4},price - {5},containsAlcoholOrTobacco - {6},discount - {7},paymentMethod - {8},message - {9}")
    @CsvFileSource(resources = "/order-test-output.csv", numLinesToSkip = 1)
    void exceptionTesting(String fullName, State state, String addressInState, String phoneNumber, Integer age, //customer
                          Float price, Boolean containsAlcoholOrTobacco,                                        //cart
                          Discount discount, PaymentMethod paymentMethod, String message) {

        if ((discount == null) || (paymentMethod == null) || (price < 50) ||
                (containsAlcoholOrTobacco && age < 18) ||
                (price < 100 && discount == Discount.HUNDRED_CROWNS_DISCOUNT) ||
                (state != State.CZECH_REPUBLIC && paymentMethod == PaymentMethod.CASH) ||
                (price < 200 && discount == Discount.TWENTY_PERCENT_DISCOUNT)) {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class, () -> {
                        Order order = new Order(new Customer(fullName, state, addressInState, phoneNumber, age), new Cart(price, containsAlcoholOrTobacco), discount, paymentMethod);
                    }
            );
            assertEquals(message, exception.getMessage());
            System.out.println(exception.getMessage());
        } else {
            Order order = new Order(new Customer(fullName, state, addressInState, phoneNumber, age), new Cart(price, containsAlcoholOrTobacco), discount, paymentMethod);
            assertTrue(message.equals("valid inputs"));
            System.out.println(message);
        }
    }
}
