package stock;

import stock.data.Stock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入股票代码: ");
        String symbol = scanner.nextLine();
        System.out.print("输入股票名称: ");
        String name = scanner.nextLine();
        System.out.print("输入股票昨日收盘价: ");
        double previousPrice = scanner.nextDouble();
        System.out.print("输入股票当前价格: ");
        double currentPrice = scanner.nextDouble();

        Stock stock = new Stock(symbol, name, previousPrice, currentPrice);

        System.out.println("\n股票代码: " + stock.getSymbol());
        System.out.println("股票名称: " + stock.getName());
        System.out.printf("股票昨日收盘价: %.2f\n", stock.getPreviousClosingPrice());
        System.out.printf("股票当前价格: %.2f\n", stock.getCurrentPrice());
        System.out.printf("股票涨跌幅: %.2f%%\n", stock.getChangePercent());

        scanner.close();
    }
}
