package app.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.List;
import java.util.Properties;

import static app.AutoTest.getTimeStamp;
import static org.junit.Assert.assertNull;

public class TestEbay {
  private static WebDriver driver = null;
  private static final String WD_DRIVER="wd.Class.forName";
  static String getWdDriver(){
    Properties props = new Properties();
    try {
      InputStream is = TestEbay.class.getClassLoader().getResourceAsStream("application.properties");
      props.load(is);
    } catch (Exception e) {
      return e.getMessage();
    }
    return props.getProperty(WD_DRIVER);
  }

  @Before()
  public void testConnection() {
    try {
      System.setProperty("webdriver.chrome.driver", getWdDriver());
      ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      WebDriver driver = new ChromeDriver(options);
      driver.get("https://www.ebay.com/");
    } catch (Exception e){
      assertNull(e);
    } finally{
      if (driver !=null){driver.quit();}}
  }

  @Test
  public void testWhetherWebManagerisFaster() throws IOException {
    long startTime = System.currentTimeMillis();
    testWithWebManager();
    long endTime = System.currentTimeMillis();
    long webManagerExecutionTime = endTime - startTime;
    float seconds = (float)(webManagerExecutionTime / 1000) % 60;
    long minutes = (webManagerExecutionTime / (1000 * 60)) % 60;
    System.out.printf("Execution time with Web Manager: %dms |\t %d minutes %.2f seconds\n", webManagerExecutionTime, minutes, seconds);

    startTime = System.currentTimeMillis();
    testWithPhysicalDriver();
    endTime = System.currentTimeMillis();
    long physicalDriverExecutionTime = endTime - startTime;
    seconds = (float)(physicalDriverExecutionTime / 1000) % 60;
    minutes = (physicalDriverExecutionTime / (1000 * 60)) % 60;
    System.out.printf("Execution time with ChromeDriver: %dms |\t %d minutes %.2f seconds\n", physicalDriverExecutionTime, minutes, seconds);

    System.out.println("That's a difference of " + (physicalDriverExecutionTime-webManagerExecutionTime) + "ms");

    assert webManagerExecutionTime<physicalDriverExecutionTime;
  }
  public void testWithWebManager() throws IOException{
    FileWriter writer=null;
    try{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
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
      writer.write(getTimeStamp()+"\n");
      writer.write(description + " - " + price + "\n");
    }} catch (Exception e){e.printStackTrace();}
    finally {
      if (writer != null) {writer.close();}
      if (driver !=null){driver.quit();}
    }
  }

  public void testWithPhysicalDriver() throws IOException{
    FileWriter writer=null;
    try{
      System.setProperty("webdriver.chrome.driver", getWdDriver());
      ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      WebDriver driver = new ChromeDriver(options);
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
        writer.write(getTimeStamp()+"\n");
        writer.write(description + " - " + price + "\n");
      }} catch (Exception e){e.printStackTrace();}
    finally {
      if (writer !=null){writer.close();}
      if (driver !=null){driver.quit();}
    }
  }
}
