package au.com.thebigredgroup.shopping.interfaces;

import au.com.thebigredgroup.shopping.model.Product;

public interface IProductStore {

    Product getProduct(String productSku);

}
