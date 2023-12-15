package au.com.thebigredgroup.shopping;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.com.thebigredgroup.shopping.model.Price;
import au.com.thebigredgroup.shopping.service.CheckoutRegister;

public class CheckoutRegisterTests {

    @Test
    public void testAppleTVDiscount() {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("hdmiadapter");
        
        Price total = checkoutRegister.total();
        assertEquals(549.0, total.getAmount(),0.1);
    }

    @Test
    public void testDoubleAppleTVDiscount() {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("hdmiadapter");
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("appletv");
        checkoutRegister.read("hdmiadapter");
        
        Price total = checkoutRegister.total();
        assertEquals(1098.0, total.getAmount(),0.1);
    }

    @Test
    public void testIpadDiscount() {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("appletv");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        checkoutRegister.read("appletv");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        checkoutRegister.read("ipad");
        
        Price total = checkoutRegister.total();
        assertEquals(2918.95, total.getAmount(),0.1);
    }
    
    @Test
    public void testHDMIDiscount() {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("macbookpro");
        checkoutRegister.read("hdmiadapter");
        checkoutRegister.read("ipad");
        
        Price total = checkoutRegister.total();
        assertEquals(2149.98, total.getAmount(),0.1);
    }

    @Test
    public void testDoubleHDMIDiscount() {
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.read("macbookpro");
        checkoutRegister.read("hdmiadapter");
        checkoutRegister.read("ipad");
        checkoutRegister.read("macbookpro");
        checkoutRegister.read("hdmiadapter");
        checkoutRegister.read("ipad");
        
        Price total = checkoutRegister.total();
        assertEquals(4299.96, total.getAmount(),0.1);
    }

}
