package app.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class EbaySearchTest {

  private static Properties properties = null;
  private static String WEB_DRIVER="driver.Class.forName";
  private static WebDriver driver = null;

  public static void main(String[] args) throws IOException {

    // Create the Spring application context
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.scan("app.assignment");
    context.refresh();

    // Set up the WebDriver

    driver = new ChromeDriver();

    // Navigate to the eBay home page
    driver.get("https://www.ebay.com/");

    // Find the search bar and enter "iphone"
    WebElement searchBox = driver.findElement(By.id("gh-ac"));
    searchBox.sendKeys("iphone");

    // Click the search button
    WebElement searchButton = driver.findElement(By.id("gh-btn"));
    searchButton.click();

    // Get all the products on the first page
    List<WebElement> products = driver.findElements(By.cssSelector(".s-item"));

    // Create a file to save the results
    File file = new File("src/test/resources/ebay-products.txt");
    FileWriter writer = new FileWriter(file);

    // Loop through the products and output the description and price
    for (WebElement product : products) {
      String description = product.findElement(By.cssSelector(".s-item__title")).getText();
      String price = product.findElement(By.cssSelector(".s-item__price")).getText();
      writer.write(description + " - " + price + "\n");
    }

    // Close the file and the driver
    writer.close();
    driver.quit();
  }
}
