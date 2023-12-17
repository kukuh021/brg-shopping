package au.com.thebigredgroup.shopping.rules;

import java.util.List;

import au.com.thebigredgroup.shopping.interfaces.IPriceRule;
import au.com.thebigredgroup.shopping.model.Product;
import au.com.thebigredgroup.shopping.service.ProductStore;

public class BundleRule extends AbstractRule implements IPriceRule  {

    @Override
    public void invoke(List<Product> products, Product product) {
        Product hdmiProduct = ProductStore.getInstance().getProduct("hdmiadapter").clone();
        hdmiProduct.getPrice().setAmount(0);
        products.add(hdmiProduct);
    }
    
}
