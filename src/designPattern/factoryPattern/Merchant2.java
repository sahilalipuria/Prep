package designPattern.factoryPattern;

public class Merchant2 implements Payment{
    @Override
    public void pay() {
        System.out.println("Paying from Merchant2");
    }
}
