package designPattern.factoryPattern;

public class PaymentFactory {

    public Payment getMerchant(String merchant){
        if(merchant=="Merchant1"){
            return new Merchant1();
        } else if (merchant=="Merchant2") {
            return new Merchant2();
        }

        return null;
    }
}
