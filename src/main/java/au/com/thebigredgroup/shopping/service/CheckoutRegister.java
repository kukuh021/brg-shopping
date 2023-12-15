package au.com.thebigredgroup.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import au.com.thebigredgroup.shopping.interfaces.ICheckoutRegister;
import au.com.thebigredgroup.shopping.model.Price;
import au.com.thebigredgroup.shopping.model.Product;

public class CheckoutRegister implements ICheckoutRegister {
    private List<Product> products = new ArrayList<>();
    private List<Product> filterProducts(String skuString) {
        return this.products.stream()
                .filter(item -> skuString.equals(item.getSku()))
                .collect(Collectors.toList());
    }

    @Override
    public void read(String sku) {
        Product product = ProductStore.getInstance().getProduct(sku).clone();
        if (product != null) {
            products.add(product);
            List<Product> filterProducts = filterProducts(sku);

            // rules for apple product
            if (product.getSku().equals("appletv")
                && filterProducts.size() % 3 == 0) {
                product.getPrice().setAmount(0);
            } 
            // rules for ipad product
            else if (product.getSku().equals("ipad")
                && filterProducts.size() > 4) {
                filterProducts.forEach((item) -> item.getPrice().setAmount(499.99));
            }
            // rules for hdmiadapter product
            else if (product.getSku().equals("hdmiadapter")) {
                List<Product> macbookProProducts = filterProducts("macbookpro");
                if (macbookProProducts.size() == filterProducts.size()) {
                    filterProducts.forEach((item) -> item.getPrice().setAmount(0));
                }
            }
            
        }
    }

    @Override
    public Price total() {
        return new Price(products.stream()
            .mapToDouble(product -> product.getPrice().getAmount())
            .sum());
    }
    
}
