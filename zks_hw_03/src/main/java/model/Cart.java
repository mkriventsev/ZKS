package model;

/**
 * @author Maksym Kriventsev
 */
public class Cart {
    private Float price;
    private Boolean containsAlcoholOrTobacco;

    public Cart(Float price, Boolean containsAlcoholOrTobacco) {
        if (price == null)
            throw new IllegalArgumentException("Price doesn't have to be null.");
        if (containsAlcoholOrTobacco == null)
            throw new IllegalArgumentException("Price doesn't have to be null.");
        if (price < 50)
            throw new IllegalArgumentException("Price has to be greater than 50 Czech crowns inclusive.");
        this.price = price;
        this.containsAlcoholOrTobacco = containsAlcoholOrTobacco;
    }

    public Float getPrice() {
        return price;
    }

    public Boolean getContainsAlcoholOrTobacco() {
        return containsAlcoholOrTobacco;
    }
}
//        containsAlcoholOrTobacco = true && age < 18 => message = "Customer buying alcohol or tobacco products must be at least 18."
//        containsAlcoholOrTobacco = false => message != "Customer buying alcohol or tobacco products must be at least 18."
//        age >= 18 => message != "Customer buying alcohol or tobacco products must be at least 18."
//
//
//        state != "CZECH_REPUBLIC" && paymentMethod = "CASH" => message = "Customer buying from abroad cannot pay cash."
//        state = "CZECH_REPUBLIC"  => message != "Customer buying from abroad cannot pay cash."
//        paymentMethod != "CASH" => message != "Customer buying from abroad cannot pay cash."
//
//        price <100 && discount = "HUNDRED_CROWNS_DISCOUNT" => message = "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."
//        discount !="TWENTY_PERCENT_DISCOUNT"  => message != "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."
//        discount !="TWENTY_PERCENT_DISCOUNT"  => message != "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//        price >=100 => message != "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."
//
//        price <200 && discount = "TWENTY_PERCENT_DISCOUNT" => message = "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//        discount !="HUNDRED_CROWNS_DISCOUNT"  => message != "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//        discount !="HUNDRED_CROWNS_DISCOUNT"  => message != "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."
//        price >=200 => message != "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//
//        discount != "NULL" && paymentMethod != "NULL" && price > 49 && (containsAlcoholOrTobacco = false || (containsAlcoholOrTobacco = true && age > 18)) && (state = "CZECH_REPUBLIC" || (state != "CZECH_REPUBLIC" && paymentMethod != "CASH") )  && ( (price >100 && discount = "HUNDRED_CROWNS_DISCOUNT") || (price >200 && discount = "TWENTY_PERCENT_DISCOUNT") ) => message = "valid inputs"
//
//        discount != "NULL" => message != "Discount doesn't have to be null."
//        paymentMethod != "NULL" => message != "Payment method doesn't have to be null."
//        discount = "NULL" => message = "Discount doesn't have to be null."
//        paymentMethod = "NULL" => message = "Payment method doesn't have to be null."
//
//        price <= 50 => message = "Price has to be greater than 50 Czech crowns inclusive."
//price >49 => !message = "Price has to be greater than 50 Czech crowns inclusive."
//
//
//
//_____________________________+==========================
//        containsAlcoholOrTobacco = true && age < 18 => message = "Customer buying alcohol or tobacco products must be at least 18."
//        containsAlcoholOrTobacco = false || age >= 18 => message != "Customer buying alcohol or tobacco products must be at least 18."
//        //age >= 18 => message != "Customer buying alcohol or tobacco products must be at least 18."
//
//        state != "CZECH_REPUBLIC" && paymentMethod = "CASH" => message = "Customer buying from abroad cannot pay cash."
//        state = "CZECH_REPUBLIC" || paymentMethod != "CASH" => message != "Customer buying from abroad cannot pay cash."
//
//        price <100 && discount = "HUNDRED_CROWNS_DISCOUNT" => message = "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."
//        price >=100 || discount !="HUNDRED_CROWNS_DISCOUNT" => message != "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."
//
//        price <200 && discount = "TWENTY_PERCENT_DISCOUNT" => message = "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//        price >=200 || discount !="TWENTY_PERCENT_DISCOUNT" => message != "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//
//
//        price <= 50 => message = "Price has to be greater than 50 Czech crowns inclusive."
//        price >50 => message != "Price has to be greater than 50 Czech crowns inclusive."
//
//
//        discount != "NULL" => message != "Discount doesn't have to be null."
//        discount = "NULL" => message = "Discount doesn't have to be null."
//        paymentMethod = "NULL" => message = "Payment method doesn't have to be null."
//        paymentMethod != "NULL" => message != "Payment method doesn't have to be null."
//
//
//
//
//        discount != "NULL" && paymentMethod != "NULL" && price > 49 && (containsAlcoholOrTobacco = false || (containsAlcoholOrTobacco = true && age > 18)) && (state = "CZECH_REPUBLIC" || (state != "CZECH_REPUBLIC" && paymentMethod != "CASH") )  && ( (price >100 && discount = "HUNDRED_CROWNS_DISCOUNT") || (price >200 && discount = "TWENTY_PERCENT_DISCOUNT") ) => message = "valid inputs"
//
//
//        discount !="HUNDRED_CROWNS_DISCOUNT"  => message != "If price is less then 200 Czech crown exclusive customer cannot use 20% discount."
//        discount !="HUNDRED_CROWNS_DISCOUNT"  => message != "If price is less then 100 Czech crown exclusive customer cannot use 100 Czech crowns discount."