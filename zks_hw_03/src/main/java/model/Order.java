package model;

/**
 * @author Maksym Kriventsev
 */
public class Order {
    private Discount discount;
    private Customer customer;
    private Cart cart;
    private PaymentMethod paymentMethod;

    public Order(Customer customer, Cart cart, Discount discount, PaymentMethod paymentMethod) {
        if (cart == null)
            throw new IllegalArgumentException("Cart doesn't have to be null.");
        if (customer == null)
            throw new IllegalArgumentException("Customer doesn't have to be null.");
        if (discount == null)
            throw new IllegalArgumentException("Discount doesn't have to be null.");
        if (paymentMethod == null)
            throw new IllegalArgumentException("Payment method doesn't have to be null.");

        if (cart.getContainsAlcoholOrTobacco() && customer.getAge() < 18)
            throw new IllegalArgumentException("Customer buying alcohol or tobacco products must be at least 18.");
        if (customer.getAddress().isAbroad() && paymentMethod == PaymentMethod.CASH)
            throw new IllegalArgumentException("Customer buying from abroad cannot pay cash.");
        if (cart.getPrice() < 100 && discount == Discount.HUNDRED_CROWNS_DISCOUNT)
            throw new IllegalArgumentException("If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount.");
        if (cart.getPrice() < 200 && discount == Discount.TWENTY_PERCENT_DISCOUNT)
            throw new IllegalArgumentException("If price is less then 200 Czech crown exclusive customer cannot use 20% discount.");



        this.discount = discount;
        this.customer = customer;
        this.cart = cart;
        this.paymentMethod = paymentMethod;
    }

    public Order(String fullName, State state, String addressInState, String phoneNumber, Integer age, //customer
                 Float price, Boolean containsAlcoholOrTobacco,                                        //cart
                 Discount discount, PaymentMethod paymentMethod) {
        this(new Customer(fullName, state, addressInState, phoneNumber, age), new Cart(price, containsAlcoholOrTobacco), discount, paymentMethod);
    }
}