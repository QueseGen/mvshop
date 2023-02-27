package app.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestEbay {
  private static WebDriver driver = null;

  @Before()
  public void testConnection() {
    try {
      driver = new ChromeDriver();
      driver.get("https://www.ebay.com/");
    } catch (Exception e){
      assertNull(e);
    }

  }

  @Test
  public void testAdd() {
    int result = 2;
    System.out.println("Add three are = " + result);
    assertEquals(3, result);

  }
  public static void main(String[] args) throws IOException {
    FileWriter writer=null;
    try{
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("iphone");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

    List<WebElement> products = driver.findElements(By.cssSelector(".s-item"));

     File file = new File("src/test/resources/ebay-products.txt");
     writer = new FileWriter(file);

    for (WebElement product : products) {
      String description = product.findElement(By.cssSelector(".s-item__title")).getText();
      String price = product.findElement(By.cssSelector(".s-item__price")).getText();
      writer.write(description + " - " + price + "\n");
    }} catch (Exception e){e.printStackTrace();}
    finally {
        writer.close();
        driver.quit();
    }
  }
}
