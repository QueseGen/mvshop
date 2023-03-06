package app.selenium.POM.Aspiration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static app.selenium.POM.Aspiration.TestConnection.getChromeDriver;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HomeTest {

  private WebDriver driver;
  //Phase1
  String PageUrl="https://aspiration.com/";

  @FindBy(css="a[class='Element-sc-1dc3ws0-0 Link__StyledLink-sc-17puyxl-0 ccfGTi cQEErc atom-link']")
  private List<WebElement> MenuButtons;

  //OR
  By IndividualButton=By.xpath("/html/body/div[1]/div/header/ul[1]/li[2]/a");
  By BusinessButton=By.xpath("/html/body/div[1]/div/header/ul[1]/li[1]/a");
  @Test
  public void TestifPhase1ElementsPresent() {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() -> {
      WebDriver driver = getChromeDriver();
      driver.get(PageUrl);
      for (By element : Elements) { WebElement Cleared = driver.findElement(element);}});
  }

  @Test
  public void AreButtonsClickable()  {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() -> {
      WebDriver driver = getChromeDriver();
      driver.manage().window().maximize();
      for (By element : Elements) {
        driver.get(PageUrl);
        WebElement Cleared = driver.findElement(element);
        Cleared.click();
        //new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.elementToBeClickable(Cleared)).click();
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
      }});
  }

  @Test
  public void AreButtonsClickableWithActions()  {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() -> {
      WebDriver driver = getChromeDriver();
      driver.manage().window().maximize();
      driver.get(PageUrl);
      for (By element : Elements) {
        WebElement Cleared = driver.findElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(Cleared).click().build().perform();
      }});
  }

  @Test
  public void AreLinksOpenable()  {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() -> {
      WebDriver driver = getChromeDriver();
      driver.manage().window().maximize();
      driver.get(PageUrl);
      for (By element : Elements) {
        WebElement Cleared = driver.findElement(element);
        String url =Cleared.getAttribute("href");
        System.out.println(url);
        driver.get(url);
      }});
  }

}