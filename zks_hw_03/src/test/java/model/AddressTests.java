package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Maksym Kriventsev
 */

@DisplayName("Pass the method parameters provided by the @CsvFileSource annotation")
class AddressTests {

    @DisplayName("Address test")//state,addressInState,message
    @ParameterizedTest(name = "country - \"{0}\" and addressInState - {1}")
    @CsvFileSource(resources = "/address-test-output.csv", numLinesToSkip = 1)
    void exceptionTesting(State state, String addressinState, String message) {

        if (state == null || addressinState == null || addressinState.equals("")) {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class, () -> {
                        Address address = new Address(state, addressinState);
                    }
            );
            assertEquals(message, exception.getMessage());
            System.out.println(exception.getMessage());
        } else {
            Address address = new Address(state, addressinState);
            if (state == State.CZECH_REPUBLIC)
                assertFalse(address.isAbroad());
            else
                assertTrue(address.isAbroad());
            assertTrue(message.equals("valid inputs"));
            System.out.println(message);
        }
    }
}
