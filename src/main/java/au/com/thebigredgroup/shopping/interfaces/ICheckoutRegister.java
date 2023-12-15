package au.com.thebigredgroup.shopping.interfaces;

import au.com.thebigredgroup.shopping.model.Price;

public interface ICheckoutRegister {

    void read(String sku);

    Price total();

}
