package StockModel;

public class Stock {
    String name;
    long numOfShares;
    Double sharePrice;

    public Stock(String name, long numOfShares, Double sharePrice) {
        this.name = name;
        this.numOfShares = numOfShares;
        this.sharePrice = sharePrice;
    }

    public Stock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(long numOfShares) {
        this.numOfShares = numOfShares;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
        this.sharePrice = sharePrice;
    }
}
