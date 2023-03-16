package app.selenium.POM.Aspiration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

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
  By Imaget=By.tagName("img");
  By Image=By.cssSelector("img[src]");


  @Test
  public void TestifPhase1ElementsPresent() {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() -> {
      WebDriver driver = getChromeDriver();
      driver.get(PageUrl);
      for (By element : Elements) { WebElement Cleared = driver.findElement(element);      }
    driver.close();
    driver.quit();
    });
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
            }
    driver.close();
    driver.quit();
    });
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
            }
    driver.close();
    driver.quit();
    });
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
            }
    driver.close();
    driver.quit();
    });
  }

  @Test
  public void HowManyPerksOnPersonalPage(){
    assertDoesNotThrow(() ->{
      WebDriver driver = getChromeDriver();
      driver.manage().deleteAllCookies();
      driver.get(PageUrl);
      WebElement Cleared = driver.findElement(IndividualButton);
      String url =Cleared.getAttribute("href");
      System.out.println(url);
      driver.get(url);

        List<WebElement> Perks = driver.findElements(PerkRows);
        System.out.println(Perks.size());
        int count=0;
        for (WebElement perk: Perks) {
          List<WebElement> Normal, Plus;
          WebElement Description=perk.findElement(PerkDescription);
          Normal=perk.findElement(NormalPerk).findElements(By.xpath("./*"));
          Plus=perk.findElement(PlusPerk).findElements(By.xpath("./*"));

          System.out.println("\nRow: "+ (count=count+1));
          System.out.println(Description.getText());

          if(Normal.isEmpty()){System.out.print("false\t");
            }else if (Objects.equals(Normal.get(0).getTagName(),"img")){ System.out.print(Normal.get(0).isEnabled()+"\t");
          } else if(Objects.equals(Normal.get(0).getTagName(),"p")){System.out.println(Normal.get(0).getText()+"\t");
          } else{System.out.println("\" \"\t");}

          if(Plus.isEmpty()){System.out.println("false");
              } else if (Objects.equals(Plus.get(0).getTagName(),"img")){ System.out.println(Plus.get(0).isEnabled());
              } else if(Objects.equals(Plus.get(0).getTagName(),"p")){System.out.println(Plus.get(0).getText());
              } else{System.out.println("\" \"");}      }
    driver.close();
    driver.quit();
    });
  }
  @Test
  public void AfterClickingButtonsCanWeGetData()  {
    List<By> Elements = List.of(new By[]{BusinessButton, IndividualButton});
    assertDoesNotThrow(() ->{
      WebDriver driver = getChromeDriver();
      for (By element : Elements) {
        driver.get(PageUrl);
        WebElement Cleared = driver.findElement(element);
        Cleared.click();

            }
    driver.close();
    driver.quit();
    });
  }
}