package designPattern.factoryPattern;

public class Merchant1 implements Payment{
    @Override
    public void pay() {
        System.out.println("Paying from Merchant1");
    }
}
