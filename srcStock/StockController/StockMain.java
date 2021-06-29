package StockController;
import StockModel.Stock;
import StockService.StockService;
import StockService.StockServiceInterface;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Stock account management:
 * We are performing CRED operations on Stock like add, edit, read and delete Stock in stock list
 * and also we maintain the Stock account which includes buying, selling and total value of Stocks.
 * @author Tushar Akhade
 * @since 20 Jun 2021
 */
public class StockMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockServiceInterface stockServiceInterface = new StockService();
        StockAccount stockAccount = new StockAccount();
        HashMap<String, Stock> stockList = new HashMap<>();
        HashMap<String, HashMap<String, Long>> accountList = new HashMap<>();
        boolean flag = true;
        while (flag) {
            System.out.println("1 to Add stock in stock list\n2 to View share market list\n3 to Edit share market price\n4 to remove company from share market\n5 to create account\n6 to get total value of account\n7 to buy stock\n8 to sell stock\n9 to Exit");
            System.out.print("Enter a choice : ");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("Adding a stock:");
                    Stock stock = new Stock();
                    stockServiceInterface.addStock(stock, stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "2":
                    System.out.println("Reading the stock:");
                    stockServiceInterface.viewStock(stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "3":
                    System.out.println("Editing the stock:");
                    stockServiceInterface.editStock(stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "4":
                    System.out.println("Deleting the stock:");
                    stockServiceInterface.deketeStock(stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "5":
                    System.out.println("Creating a account :");
                    stockAccount.createStockAccount(accountList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "6":
                    System.out.println("Calculating total value of stocks");
                    stockAccount.valueOf(accountList, stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "7":
                    System.out.println("Buying a stocks:");
                    stockAccount.buyStocks(accountList, stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                case "8":
                    System.out.println("Selling a stocks:");
                    stockAccount.sellStocks(accountList, stockList);
                    System.out.println("------------------------**********************--------------------------");
                    break;
                default:
                    flag = false;
                    System.out.println("Invalid choice.");
            }
        }
    }
}
