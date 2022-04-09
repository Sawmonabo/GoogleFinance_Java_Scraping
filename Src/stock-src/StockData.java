// String url = "https://www.google.com/finance/quote/" + this.ticker + ":NASDAQ?hl=en";
// Document doc = Jsoup.connect(url).timeout(5000).get();

// If you're on a Unix system then you can compile/run in terminal with:
// javac -cp jsoup-1.14.3.jar:. StockData.java

// java -cp jsoup-1.14.3.jar:. StockData

package stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;


public class StockData
{
  private String ticker;
  private String lastPrice;
  private Document stockHTML;

  public StockData(String ticker) throws IOException
  {
    this.ticker = ticker;
    this.lastPrice = "0";
    String url = "https://www.google.com/finance/quote/" + this.ticker + ":NASDAQ?hl=en";
    this.stockHTML = Jsoup.connect(url).timeout(5000).get();
  }

  public void getPrice()
  {

    Elements e = stockHTML.select(".YMlKec.fxKbKc");
    String[] prices = e.text().split(" ");
    System.out.println("Last stock price $" + prices[0]);
  }

  public void getName()
  {

    Elements e = stockHTML.select("div.zzDege");
    String name = e.text();
    System.out.println("Company Name: " + name);
  }

  public void getData()
  {

    Elements e = stockHTML.select("div.mfs7Fc");
    ArrayList<String> tickerInformation = new ArrayList<String>();
    e.forEach(element -> tickerInformation.add(element.text()));
    int tickerInformation_Length = tickerInformation.size();


    Elements e2 = stockHTML.select("div.P6K39c");
    ArrayList<String> tickerInformation_value = new ArrayList<String>();
    e2.forEach(element -> tickerInformation_value.add(element.text()));


    Elements e3 = stockHTML.select("td.J9Jhg");
    ArrayList<String> tickerCompanyData = new ArrayList<String>();
    e3.forEach(element -> tickerCompanyData.add(element.text()));
    int tickerCompanyData_length = tickerCompanyData.size();


    Elements e4 = stockHTML.select("td.QXDnM");
    ArrayList<String> tickerCompanyData_value = new ArrayList<String>();
    e4.forEach(element -> tickerCompanyData_value.add(element.text()));


    String[] arr = new String[tickerInformation_Length];
    for(int i = 0; i < tickerInformation_Length; i++)
    {
      arr[i] = (tickerInformation.get(i) + ": " + tickerInformation_value.get(i));
      System.out.println(arr[i]);
    }

    String[] arr2 = new String[tickerCompanyData_length];
    for(int i = 0; i < tickerCompanyData_length; i++)
    {
      arr2[i] = ("2021 " + tickerCompanyData.get(i) + ": " + tickerCompanyData_value.get(i));
      System.out.println(arr2[i]);

    }
  }

}
