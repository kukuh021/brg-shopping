package au.com.thebigredgroup.shopping.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import au.com.thebigredgroup.shopping.interfaces.IProductStore;
import au.com.thebigredgroup.shopping.model.Price;
import au.com.thebigredgroup.shopping.model.Product;

public class ProductStore implements IProductStore {
    public static ProductStore INSTANCE;
    private ProductStore() {}
    public static ProductStore getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ProductStore();
        }
        
        return INSTANCE;
    }

    private List<Product> products;

    public List<Product> getProducts() {
        if (this.products == null) {
            try {
                URL resource = getClass().getClassLoader().getResource("product_master.txt");
                this.products = Files.lines(Paths.get(resource.toURI()))
                    .map(item -> item.split(","))
                    .map(val -> new Product(val[0], val[1]
                        , new Price(Double.parseDouble(val[2]))))
                    .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return this.products;
    }

    @Override
    public Product getProduct(String productSku) {
        return getProducts().stream()
            .filter(product -> productSku.equals(product.getSku()))
            .findAny()
            .orElse(null);
    }
    
}
