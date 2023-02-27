package app.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static app.AutoTest.getTimeStamp;

public class TestTarget {

  private static FileWriter writer=null;

  @Before()
  public void testBefore() {

    System.out.println("Before method!");

  }

  @Test
  public void testSearchPreLoad() {
    ChromeOptions options = new ChromeOptions();
    WebDriverManager.chromedriver().setup();
    options.addArguments("headless");
    WebDriver driver = new ChromeDriver(options);
    JavascriptExecutor jsx = (JavascriptExecutor)driver;
    driver.manage().window().fullscreen();
    driver.navigate().to("https://www.target.com/");

    driver.findElement(By.name("searchTerm")).click();
    Assert.assertTrue(driver.findElement(By.name("searchTerm")).isSelected());
  }

  public static void main(String[] args) throws IOException, InterruptedException {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    JavascriptExecutor jsx = (JavascriptExecutor)driver;
    driver.manage().window().fullscreen();
    driver.get("https://www.target.com/");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("searchTerm")));
    searchBox.sendKeys("iphone");
    TimeUnit.SECONDS.sleep(5);
    searchBox.sendKeys(Keys.ENTER);
    JavascriptExecutor j = (JavascriptExecutor)driver;
    if (j.executeScript("return document.readyState").toString().equals("complete")){
      System.out.println("Page has loaded");
    }

    try {
      writer = new FileWriter("src/test/resources/target_products.txt");
      List<WebElement> Allproducts = new ArrayList<>();
      for (int i = 0; i <6 ; i++) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Allproducts.addAll(driver.findElements(By.cssSelector("div[class='styles__StyledDetailsWrapper-sc-1iglypx-1 bgKEdY']")));
        jsx.executeScript("window.scrollBy(0,1400);");
        TimeUnit.SECONDS.sleep(6);
      }
      Allproducts=Allproducts.stream().distinct().collect(Collectors.toList());
      System.out.println(Allproducts.size());
      for (WebElement product : Allproducts){
       String title= product.findElement(By.cssSelector("div[class='Truncate-sc-10p6c43-0 flAIvs']")).getAttribute("title");
       String price=product.findElement(By.cssSelector("div[class='styles__ProductCardPriceAndPromoStyled-sc-1p9w55v-0 hikmng']")).findElement(By.cssSelector("div[class='styles__PriceStandardLineHeight-sc-m1iu3h-0 jqDsCz']")).findElement(By.cssSelector("div[class='h-padding-r-tiny']")).findElement(By.cssSelector("span[data-test='current-price']")).getText();
       System.out.println(title+"\t"+ price);
       writer.write(getTimeStamp()+"\n");
       writer.write(title+"\t"+ price+"\n");
      }
      }catch (Exception e){
        e.printStackTrace();
    } finally{
      writer.close();
      driver.close();
    }
  }
}
