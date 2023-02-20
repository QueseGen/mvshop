package app.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TargetSearchTest {

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
    driver.get("https://www.target.com/");

    // Find the search bar and enter "iphone"
    WebElement searchBox = driver.findElement(By.name("searchTerm"));
    searchBox.sendKeys("iphone");

    // Click on the search button
    WebElement searchButton = driver.findElement(By.className("styles__MobileSearchWrapper-sc-1r0wkfu-0 jOTdQX"));
    searchButton.click();

    // Get all the products on page 1 and print their description and price
    List<WebElement> products = driver.findElements(By.xpath("//div[@data-test='productCard']"));
    FileWriter writer = new FileWriter("/src/test/resources/target_products.txt");
    for (WebElement product : products) {
      String name = product.findElement(By.xpath(".//a")).getText();
      String price = product.findElement(By.xpath(".//span[@data-test='product-price']"))
        .getAttribute("aria-label");
      writer.write(name + ": " + price + "\n");
      System.out.println(name + ": " + price);
    }
    writer.close();
    // Close the browser
    driver.quit();
  }
}
