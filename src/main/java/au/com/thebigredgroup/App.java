package au.com.thebigredgroup;

import au.com.thebigredgroup.shopping.service.CheckoutRegister;

public class App {
    public static void main(String[] args) {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("hdmiadapter");

        System.out.printf("SKUs Read: %s%n", checkoutRegister.productSkus());
        System.out.printf("Total: %s%n", checkoutRegister.total().getAmount());

        checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        checkoutRegister.read("appletv");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");

        System.out.printf("SKUs Read: %s%n", checkoutRegister.productSkus());
        System.out.printf("Total: %s%n", checkoutRegister.total().getAmount());

        checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("macbookpro");
        checkoutRegister.read("ipad");

        System.out.printf("SKUs Read: %s%n", checkoutRegister.productSkus());
        System.out.printf("Total: %s%n", checkoutRegister.total().getAmount());
    }
}
