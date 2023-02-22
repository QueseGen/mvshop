package app.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TargetSearchTest {
  private static final String WEB_DRIVER="driver.Class.forName";
  private static final WebDriver driver = new ChromeDriver();
  private static FileWriter writer=null;
  private static final JavascriptExecutor jsx = (JavascriptExecutor)driver;

  public static void main(String[] args) throws IOException, InterruptedException {

    driver.get("https://www.target.com/");
    driver.manage().window().fullscreen();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("searchTerm")));
    searchBox.sendKeys("iphone");
    TimeUnit.SECONDS.sleep(5);
    searchBox.sendKeys(Keys.ENTER);
    JavascriptExecutor j = (JavascriptExecutor)driver;
    if (j.executeScript("return document.readyState").toString().equals("complete")){
      System.out.println("Page has loaded");
    } //Not valid

    List<WebElement> products=null;
    try {
      writer = new FileWriter("src/test/resources/target_products.txt");
      List<WebElement> Allproducts = new ArrayList<>();
      for (int i = 0; i <5 ; i++) {
        //works sometimes all items don't load
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Allproducts.addAll(driver.findElements(By.cssSelector("div[class='styles__StyledDetailsWrapper-sc-1iglypx-1 bgKEdY']")));
        jsx.executeScript("window.scrollBy(0,1400);");
        TimeUnit.SECONDS.sleep(10);
      }
      Allproducts=Allproducts.stream().distinct().collect(Collectors.toList());
      System.out.println(Allproducts.size());
      for (WebElement product : Allproducts){
       String title= product.findElement(By.cssSelector("div[class='Truncate-sc-10p6c43-0 flAIvs']")).getAttribute("title");
       String price=product.findElement(By.cssSelector("div[class='styles__ProductCardPriceAndPromoStyled-sc-1p9w55v-0 hikmng']")).findElement(By.cssSelector("div[class='styles__PriceStandardLineHeight-sc-m1iu3h-0 jqDsCz']")).findElement(By.cssSelector("div[class='h-padding-r-tiny']")).findElement(By.cssSelector("span[data-test='current-price']")).getText();
       System.out.println(title+"\t"+ price);
       writer.write(title+"\t"+ price);
      }
      }catch (Exception e){
        e.printStackTrace();
    } finally{
      writer.close();
      driver.close();
    }
  }
}
