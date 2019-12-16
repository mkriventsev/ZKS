package model;

import model.Address;
import model.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Maksym Kriventsev
 */

@DisplayName("Pass the method parameters provided by the @CsvFileSource annotation")
class CustomerTests {

    @DisplayName("Customer test")//state,addressInState,message
    @ParameterizedTest(name = "age - {0},phoneNumber = {1},state {2},addressInState {3},fullName {4}\"")
    @CsvFileSource(resources = "/customer-test-output.csv", numLinesToSkip = 1)
    void exceptionTesting(Integer age, String phoneNumber, State state, String addressInState, String fullName, String message) {

        if (fullName == null || fullName.length() < 2 || fullName.length() >= 32 || fullName.equals("") ||
                phoneNumber == null || !phoneNumber.matches("[+]?[0123456789 ]+") ||
                age == null || age < 15 || age > 120) {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class, () -> {
                        Customer customer = new Customer(fullName, new Address(state, addressInState), phoneNumber, age);
                    }
            );
            assertEquals(message, exception.getMessage());
            System.out.println(exception.getMessage());
        } else {
            Customer customer = new Customer(fullName, new Address(state, addressInState), phoneNumber, age);
            assertEquals(customer.getAge(), age);
            assertTrue(message.equals("valid inputs"));
            System.out.println(message);
        }
    }
}

