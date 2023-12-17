package au.com.thebigredgroup.shopping.model;

public class Price {
    private String priceRule;
    private double amount;

    public Price(double amount, String priceRule) {
        this.amount = amount;
        this.priceRule = priceRule;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPriceRule() {
        return priceRule;
    }

    public void setPriceRule(String priceRule) {
        this.priceRule = priceRule;
    }

    
}
