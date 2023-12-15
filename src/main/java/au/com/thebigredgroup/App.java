package au.com.thebigredgroup;

import au.com.thebigredgroup.shopping.service.CheckoutRegister;

public class App {
    public static void main(String[] args) {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("hdmiadapter");

        System.out.println("SKUs Read: appletv, appletv, appletv, hdmiadapter");
        System.out.printf("Total: %s%n", checkoutRegister.total().getAmount());

        checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        checkoutRegister.read("appletv");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");

        System.out.println("SKUs Read: appletv, ipad, ipad, appletv, ipad, ipad, ipad");
        System.out.printf("Total: %s%n", checkoutRegister.total().getAmount());

        checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("macbookpro");
        checkoutRegister.read("hdmiadapter");
        checkoutRegister.read("ipad");

        System.out.println("SKUs Read: macbookpro, hdmiadapter, ipad");
        System.out.printf("Total: %s%n", checkoutRegister.total().getAmount());
    }
}
