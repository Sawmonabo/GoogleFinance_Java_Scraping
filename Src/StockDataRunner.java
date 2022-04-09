// String url = "https://www.google.com/finance/quote/" + this.ticker + ":NASDAQ?hl=en";
// Document doc = Jsoup.connect(url).timeout(5000).get();

// If you're on a Unix system then you can compile/run in terminal with:
// javac -cp jsoup-1.14.3.jar:. StockDataRunner.java

// java -cp jsoup-1.14.3.jar:. StockDataRunner
import stock.StockData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;



public class StockDataRunner
{

    public static void main(String[] args) throws IOException
    {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter Stock Ticker:");
      String ticker = scan.nextLine();

      StockData stock1 = new StockData(ticker);
      stock1.getName();
      stock1.getPrice();
      stock1.getData();

    }
}
