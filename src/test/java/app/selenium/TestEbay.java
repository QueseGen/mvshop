package app.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static app.AutoTest.getTimeStamp;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEbay {
  private static final WebDriver driver = null;
  private static final File file = new File("src/test/resources/ebay-products.txt");

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

  static WebDriver getChromeDriver(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    options.addArguments(CapabilityType.BROWSER_NAME, "chrome");
    options.addArguments("webdriver.remote.session.capability-match", "newSession");
    options.addArguments("webdriver.remote.session.technology-preview", "newSession");

    return new ChromeDriver(options);
  }

 // @BeforeAll
  public static void testConnectionwithChromeDrive() {
    try {
      System.setProperty("webdriver.chrome.driver", getWdDriver());
      WebDriver driver = getChromeDriver();
      driver.get("https://www.ebay.com/");
    } catch (Exception e){
      //Assertions.//Assertions.assertNull(e);
      System.out.println("ChromeDriver is hidden in Repo. | " + e.getMessage());
    } }

  public static void testConnectionwithWebManager() {
    try {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = getChromeDriver();
      driver.get("https://www.ebay.com/");
    } catch (Exception e){
      ////Assertions.//Assertions.//Assertions.assertNull(e);
      System.out.println("pom.xml is hidden in Repo. | " + e.getMessage());}
    }
  @RepeatedTest(10)
  public void testWhetherWebManagerisFaster() throws IOException {
    long startTime = System.currentTimeMillis();
    testWithWebManager();
    long endTime = System.currentTimeMillis();
    long webManagerExecutionTime = endTime - startTime;
    float seconds = (float)(webManagerExecutionTime / 1000) % 60;
    long minutes = (webManagerExecutionTime / (1000 * 60)) % 60;
    System.out.printf("Execution time with Web Manager: %dms |\t %d minutes %.2f seconds\n", webManagerExecutionTime, minutes, seconds);

    startTime = System.currentTimeMillis();
    testWithChromeDriver();
    endTime = System.currentTimeMillis();
    long physicalDriverExecutionTime = endTime - startTime;
    seconds = (float)(physicalDriverExecutionTime / 1000) % 60;
    minutes = (physicalDriverExecutionTime / (1000 * 60)) % 60;
    System.out.printf("Execution time with ChromeDriver: %dms |\t %d minutes %.2f seconds\n", physicalDriverExecutionTime, minutes, seconds);

    System.out.println("That's a difference of " + (physicalDriverExecutionTime-webManagerExecutionTime) + "ms");
   assertTrue(physicalDriverExecutionTime > webManagerExecutionTime, "Bonigarcia's WebdriverManager at "+ webManagerExecutionTime +"ms can connect and crawl data from Ebay.com faster than Google's ChromeDriver.exe(ver 110) at"+ physicalDriverExecutionTime +"ms.");
  }
  public void testWithWebManager() throws IOException{
    FileWriter writer=null;
    try{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = getChromeDriver();
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("iphone");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

    List<WebElement> products = driver.findElements(By.cssSelector(".s-item"));

     writer = new FileWriter(file);
     writer.write("---------------------WDM Test: "+getTimeStamp()+"\n");

    for (WebElement product : products) {
      String description = product.findElement(By.cssSelector(".s-item__title")).getText();
      String price = product.findElement(By.cssSelector(".s-item__price")).getText();
      writer.write(description + " - " + price + "\n");
    }} catch (Exception e){e.printStackTrace();}
    finally {
      if (writer != null) {writer.close();}
      if (driver !=null){driver.quit();}
    }
  }

  public void testWithChromeDriver() throws IOException{
    FileWriter writer=null;
    try{

      System.setProperty("webdriver.chrome.driver", getWdDriver());

      WebDriver driver = getChromeDriver();
      driver.get("https://www.ebay.com/");

      WebElement searchBox = driver.findElement(By.id("gh-ac"));
      searchBox.sendKeys("iphone");

      WebElement searchButton = driver.findElement(By.id("gh-btn"));
      searchButton.click();

      List<WebElement> products = driver.findElements(By.cssSelector(".s-item"));

      writer = new FileWriter(file);
      writer.write("---------------------CD Test: "+getTimeStamp()+"\n");
      for (WebElement product : products) {
        String description = product.findElement(By.cssSelector(".s-item__title")).getText();
        String price = product.findElement(By.cssSelector(".s-item__price")).getText();
        writer.write(description + " - " + price + "\n");
      }} catch (Exception e){e.printStackTrace();}
    finally {
      if (writer !=null){writer.close();}
      if (driver !=null){driver.quit();}
    }
  }
}
