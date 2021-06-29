package StockService;
import StockModel.Stock;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockService implements StockServiceInterface {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public HashMap<String, Stock> addStock(Stock stock, HashMap<String, Stock> stockList) {
        System.out.println("Enter stock/company name : ");
        String stockName = scanner.next();
        System.out.println("Enter stock price : ");
        double stockPrice = scanner.nextDouble();
        System.out.println("Enter number of stocks : ");
        long numOfStocks = scanner.nextLong();
        stock.setName(stockName);
        stock.setSharePrice(stockPrice);
        stock.setNumOfShares(numOfStocks);
        stockList.put(stockName, stock);
        System.out.println("Stock added");
        return stockList;
    }

    @Override
    public HashMap<String, Stock> editStock(HashMap<String, Stock> stockList) {
        System.out.println("Enter a stock/company name : ");
        String companyName = scanner.next();
        if (stockList.containsKey(companyName)) {
            Stock stock1 = stockList.get(companyName);
            System.out.println("Enter stock price : ");
            double stockPrice1 = scanner.nextDouble();
            System.out.println("Enter number of stocks : ");
            long numOfStocks1 = scanner.nextLong();

            stock1.setSharePrice(stockPrice1);
            stock1.setNumOfShares(numOfStocks1);
            System.out.println("Stock edited");
        } else {
            System.out.println("Stock/company name not found.");
        }
        return stockList;
    }

    @Override
    public void viewStock(HashMap<String, Stock> stockList) {
        for(Map.Entry<String, Stock> s : stockList.entrySet()) {        // iterate the stock list
            System.out.println(s.getValue().getName() + " " + s.getValue().getSharePrice() + " " + s.getValue().getNumOfShares());
        }
    }

    @Override
    public HashMap<String, Stock> deketeStock(HashMap<String, Stock> stockList) {
        System.out.println("Enter a stock/company name : ");
        String companyName2 = scanner.next();
        if (stockList.containsKey(companyName2)) {
            stockList.remove(companyName2);
            System.out.println("Stock deleted.");
        } else {
            System.out.println("Stock/company name not found.");
        }
        return stockList;
    }
}
