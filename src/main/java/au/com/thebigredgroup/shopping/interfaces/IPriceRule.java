package au.com.thebigredgroup.shopping.interfaces;

import java.util.List;

import au.com.thebigredgroup.shopping.model.Product;

public interface IPriceRule {

    void invoke(List<Product> products, Product product);
}
