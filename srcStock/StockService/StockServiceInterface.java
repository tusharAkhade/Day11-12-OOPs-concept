package StockService;
import StockModel.Stock;
import java.util.HashMap;

/**
 *
 */
public interface StockServiceInterface {
    public abstract HashMap<String, Stock> addStock(Stock stock, HashMap<String, Stock> stockList);
    public abstract HashMap<String, Stock> editStock(HashMap<String, Stock> stockList);
    public abstract void viewStock(HashMap<String, Stock> stockList);
    public abstract HashMap<String, Stock> deketeStock(HashMap<String, Stock> stockList);
}
