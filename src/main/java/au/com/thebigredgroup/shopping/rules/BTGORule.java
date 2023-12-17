package au.com.thebigredgroup.shopping.rules;

import java.util.List;

import au.com.thebigredgroup.shopping.interfaces.IPriceRule;
import au.com.thebigredgroup.shopping.model.Product;

public class BTGORule extends AbstractRule implements IPriceRule {

    @Override
    public void invoke(List<Product> products, Product product) {
        if (filterProducts(products, product.getSku()).size() % 3 == 0) {
            product.getPrice().setAmount(0);
        }
    }
    
}
