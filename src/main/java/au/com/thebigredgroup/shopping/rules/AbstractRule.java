package au.com.thebigredgroup.shopping.rules;

import java.util.List;
import java.util.stream.Collectors;

import au.com.thebigredgroup.shopping.model.Product;

public class AbstractRule {
    protected List<Product> filterProducts(List<Product> products, String skuString) {
        return products.stream()
                .filter(item -> skuString.equals(item.getSku()))
                .collect(Collectors.toList());
    }
}
