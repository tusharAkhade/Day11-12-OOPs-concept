package StockController;
import StockModel.Stock;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Managing the Stock account like create a account. buy, sell, total value of stocks.
 */
public class StockAccount {
    Scanner scanner = new Scanner(System.in);

    // creating a stock account
    public void createStockAccount(HashMap<String, HashMap<String, Long>> accountList) {
        System.out.println("Enter a account name: ");
        String accountHolderName = scanner.next();
        if (accountList.containsKey(accountHolderName)) {
            System.out.println("Account exists.");
        } else {
            HashMap<String, Long> accountHolderInfo = new HashMap<String, Long>();
            accountList.put(accountHolderName, new HashMap<String, Long>());
            System.out.println("Account created.");
        }
    }

    // total value of account
    public HashMap<String, HashMap<String, Long>> valueOf(HashMap<String, HashMap<String, Long>> accountList, HashMap<String, Stock> stockList) {
        System.out.println("Enter a account name: ");
        String accountHolderName = scanner.next();
        if (accountList.containsKey(accountHolderName)) {
            HashMap<String, Long> account = new HashMap<>();
            account = accountList.get(accountHolderName);
            double accountValue = 0;
            double stockPrice = 0;
            for (Map.Entry<String, Long> entry : account.entrySet()) {
                stockPrice = stockList.get(entry.getKey()).getSharePrice();
                accountValue = accountValue + entry.getValue() * stockPrice;
            }
            System.out.println("Total value of account is : " + accountValue);
            return accountList;
        } else {
            System.out.println("Account does not exist.");
        }
        return null;
    }

    // buying a stock
    public HashMap<String, HashMap<String, Long>> buyStocks(HashMap<String, HashMap<String, Long>> accountList, HashMap<String, Stock> stockList) {
        System.out.println("Enter your account name : ");
        String accountHolderName = scanner.next();
        if (accountList.containsKey(accountHolderName)) {
            System.out.println("Enter the stock name : ");
            String stockName = scanner.next();
            if (stockList.containsKey(stockName)) {
                long availableStocks = stockList.get(stockName).getNumOfShares();
                System.out.println("How much stocks you want to buy : ");
                long numOfStocksBuying = scanner.nextLong();
                if (availableStocks >= numOfStocksBuying) {
                    Long temp = accountList.get(accountHolderName).get(stockName);
                    if (temp == null) {
                        accountList.get(accountHolderName).put(stockName, 0L);
                        temp = 0L;
                    }
                    availableStocks = availableStocks - numOfStocksBuying;
                    stockList.get(stockName).setNumOfShares(availableStocks);
                    temp = temp + numOfStocksBuying;
                    accountList.get(accountHolderName).put(stockName, temp);
                    System.out.println("You purchased " + temp + " stocks.");
                    return accountList;
                } else {
                    System.out.println("You have " + availableStocks + " stocks only.");
                }
            } else {
                System.out.println("Stock/company name not found.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
        return null;
    }

    public void sellStocks(HashMap<String, HashMap<String, Long>> accountList, HashMap<String, Stock> stockList) {
        System.out.println("Enter your account name : ");
        String accountHolderName = scanner.next();
        if (accountList.containsKey(accountHolderName)) {
            System.out.println("Enter the stock name : ");
            String stockName = scanner.next();
            if (accountList.get(accountHolderName).containsKey(stockName)) {
                long availableStocks = accountList.get(accountHolderName).get(stockName);
                System.out.println("How many stocks you want to sell : ");
                long sellStocks = scanner.nextLong();
                if (sellStocks <= availableStocks) {
                    availableStocks = availableStocks - sellStocks;
                    accountList.get(accountHolderName).put(stockName, availableStocks);
                    long temp = stockList.get(stockName).getNumOfShares();
                    temp = temp + sellStocks;
                    stockList.get(stockName).setNumOfShares(temp);
                    System.out.println("You sold " + sellStocks + " stocks.");
                } else {
                    System.out.println("Only " + availableStocks + " stocks available in the account.");
                }
            } else {
                System.out.println("Stock not found.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }
}
