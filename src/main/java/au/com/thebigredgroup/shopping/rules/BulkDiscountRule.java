package au.com.thebigredgroup.shopping.rules;

import java.util.List;

import au.com.thebigredgroup.shopping.interfaces.IPriceRule;
import au.com.thebigredgroup.shopping.model.Product;

public class BulkDiscountRule extends AbstractRule implements IPriceRule  {

    @Override
    public void invoke(List<Product> products, Product product) {
        List<Product> filterProducts = filterProducts(products, product.getSku());
        if (filterProducts.size() > 4) {
            filterProducts.forEach((item) -> item.getPrice().setAmount(499.99));
        }
    }
    
}
