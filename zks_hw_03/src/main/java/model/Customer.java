package model;

/**
 * @author Maksym Kriventsev
 */
public class Customer {
    private String fullName;
    private Address address;
    private String phoneNumber;
    private Integer age;

    public Customer(String fullName, Address address, String phoneNumber, Integer age) {

        if (fullName == null)
            throw new IllegalArgumentException("Fullname doesn't have to be null.");
        if (fullName.equals(""))
            throw new IllegalArgumentException("Fullname in state doesn't have to be empty.");
//[2;32)
        if (fullName.length() < 2)
            throw new IllegalArgumentException("Fullname has to be greater than 2 characters inclusive.");

        if (fullName.length() >= 32)
            throw new IllegalArgumentException("Fullname has to be less than 32 characters exclusive.");

        this.fullName = fullName;

        this.address = address;

        if (age == null)
            throw new IllegalArgumentException("Age doesn't have to be null.");
        //[15;120]
        if (age < 15)
            throw new IllegalArgumentException("Customer has to be 15 years older inclusive.");

        if (age > 120)
            throw new IllegalArgumentException("Customer has to be 120 years younger inclusive.");
        this.age = age;

        if (phoneNumber == null)
            throw new IllegalArgumentException("Phone number doesn't have to be null.");
        if (!phoneNumber.matches("[+]?[0123456789 ]+"))
            throw new IllegalArgumentException("Phone number has to match this regex: [+]?[0123456789 ]+.");

        this.phoneNumber = phoneNumber;

    }



    public Customer(String fullName, State state, String addressInState, String phoneNumber, Integer age) {
        this(fullName, new Address(state, addressInState), phoneNumber, age);
    }

    public Integer getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
