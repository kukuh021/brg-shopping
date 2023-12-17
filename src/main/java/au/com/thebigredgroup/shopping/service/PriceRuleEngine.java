package au.com.thebigredgroup.shopping.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.thebigredgroup.shopping.interfaces.IPriceRule;
import au.com.thebigredgroup.shopping.model.Product;
import au.com.thebigredgroup.shopping.rules.BTGORule;
import au.com.thebigredgroup.shopping.rules.BulkDiscountRule;
import au.com.thebigredgroup.shopping.rules.BundleRule;

public class PriceRuleEngine {
    public static PriceRuleEngine INSTANCE;
    private PriceRuleEngine() {}
    public static PriceRuleEngine getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PriceRuleEngine();
        }
        
        return INSTANCE;
    }

    private Map<String,IPriceRule> priceRuleMap;

    private Map<String,IPriceRule> getPriceRuleMap() {
        if (priceRuleMap == null) {
            priceRuleMap = new HashMap<>();
            priceRuleMap.put("btgo", new BTGORule());
            priceRuleMap.put("bundle", new BundleRule());
            priceRuleMap.put("bulkdiscount", new BulkDiscountRule());
        }

        return priceRuleMap;
    };

    public void invoke(List<Product> products, Product product) {
        IPriceRule priceRule = getPriceRuleMap().get(product.getPrice().getPriceRule());
        if (priceRule != null) {
            priceRule.invoke(products,product);
        } 
    }
    
}
