package au.com.thebigredgroup.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import au.com.thebigredgroup.shopping.interfaces.ICheckoutRegister;
import au.com.thebigredgroup.shopping.model.Price;
import au.com.thebigredgroup.shopping.model.Product;

public class CheckoutRegister implements ICheckoutRegister {
    private List<Product> products = new ArrayList<>();

    @Override
    public void read(String sku) {
        Product product = ProductStore.getInstance().getProduct(sku).clone();
        if (product != null) {
            products.add(product);

            PriceRuleEngine.getInstance().invoke(products, product);
        }
    }

    @Override
    public Price total() {
        return new Price(products.stream()
            .mapToDouble(product -> product.getPrice().getAmount())
            .sum(), null);
    }

    @Override
    public String productSkus() {
        return products.stream()
            .map(product -> product.getSku())
           .collect(Collectors.joining(","));
    }
    
}
