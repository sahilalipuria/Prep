package designPattern.factoryPattern;

/**
 * @author salipuri
 *
 *
Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.

In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.


 *
 */

public class FactoryPattern {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment paymentViaMerchant1 = paymentFactory.getMerchant("Merchant1");
        paymentViaMerchant1.pay();
        Payment paymentViaMerchant2 = paymentFactory.getMerchant("Merchant2");
        paymentViaMerchant2.pay();
    }
}
