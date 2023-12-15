package au.com.thebigredgroup.shopping.model;

public class Product {

    private final String sku;
    private final String name;
    private final Price price;

    public Product(String sku, String name, Price price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
    public Product clone() {
        return new Product(this.sku, this.name, new Price(this.price.getAmount()));
    }
}
