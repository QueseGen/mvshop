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
  By PerkRows=By.cssSelector("div[class='Flex-sc-1kj10zc-0 BpXfo']");
    By PerkDescription=By.cssSelector("div[class='Flex-sc-1kj10zc-0 laSLjt']");
    By NormalPerk=By.cssSelector("div[class='Flex-sc-1kj10zc-0 ckGXCh']");
    By PlusPerk=By.cssSelector("div[class='Flex-sc-1kj10zc-0 jceVYu']");
  By Image=By.tagName("image");

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
    assertDoesNotThrow(() ->{
      WebDriver driver = getChromeDriver();
      driver.manage().window().maximize();
      for (By element : Elements) {
        driver.get(PageUrl);
        WebElement Cleared = driver.findElement(element);
        Cleared.click();
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

  @Test
  public void HowManyPerksOnPersonalPage(){
    assertDoesNotThrow(() ->{
      WebDriver driver = getChromeDriver();
      driver.get(PageUrl);
      WebElement Cleared = driver.findElement(IndividualButton);
      String url =Cleared.getAttribute("href");
      System.out.println(url);
      driver.get(url);

      List<WebElement> Perks = driver.findElements(PerkRows);
      System.out.println(Perks.size());
      int count=0;
      for (WebElement perk: Perks) {
        System.out.println("\nRow: "+ (count=count+1));
        System.out.println(perk.findElement(PerkDescription).getText());
        if (perk.findElement(NormalPerk).findElement(By.tagName("p"))!=null){System.out.print(perk.findElement(NormalPerk).findElement(By.tagName("p")).getText()+"\t");}
        if (perk.findElement(PlusPerk).findElement(By.tagName("p"))!=null){System.out.print(perk.findElement(PlusPerk).findElement(By.tagName("p")).getText()+"\t");}

        if (perk.findElement(NormalPerk).findElements(Image).size()<=1){System.out.println(perk.findElement(NormalPerk).findElement(Image).getSize());}
        if (perk.findElement(PlusPerk).findElements(Image).size()<=1){System.out.println(perk.findElement(PlusPerk).findElement(Image).getSize());}


      }
    });
  }
  @Test
  public void AfterClickingButtonsCanWeGetData()  {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() ->{
      WebDriver driver = getChromeDriver();
      driver.manage().window().maximize();
      for (By element : Elements) {
        driver.get(PageUrl);
        WebElement Cleared = driver.findElement(element);
        Cleared.click();

      }});
  }
}