package app.selenium.POM.Aspiration;

  import app.selenium.POM.Aspiration.models.LoginPage;
  import org.junit.jupiter.api.Assertions;
  import org.junit.jupiter.api.Test;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;

  import java.io.FileInputStream;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.Properties;
  import java.util.concurrent.TimeUnit;

  import static app.selenium.POM.Aspiration.TestConnection.getChromeDriver;
  import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LoginTest {

  private WebDriver driver;
  //Phase1
  String PageUrl="https://my.aspiration.com/";

  By EmailBox=By.cssSelector("input[id='signinEmail']");
  By PasswordBox=By.cssSelector("input[id='signinPassword']");
  By LoginButton=By.cssSelector("button[id][type='submit']");

  static private List<String> getCredentials(){
    List<String> cred = new ArrayList<>();

    try {
      Properties properties = new Properties();
      properties.load(new FileInputStream("src/test/resources/application.properties"));
      cred.add(properties.getProperty("an.user"));
      cred.add(properties.getProperty("an.pwd"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cred;
  }
  @Test
  public void TestifPhase1ElementsPresent() {
    List<By> Elements = List.of(new By[]{EmailBox,PasswordBox, LoginButton});
    assertDoesNotThrow(() -> {
      driver = getChromeDriver();
      driver.get(PageUrl);
      for (By element : Elements) { WebElement Cleared = driver.findElement(element);}});
  }
  @Test
  public void CanLoginNout() throws InterruptedException {
    WebDriver driver = getChromeDriver();
    driver.get(PageUrl);
    LoginPage Login = new LoginPage(driver);
    List<String> credentials=getCredentials();

    Login.setEmailBox(credentials.get(0));
    Login.setPasswordBox(credentials.get(1));

    Login.clickLoginButton();
    TimeUnit.SECONDS.sleep(16);
    Assertions.assertTrue(driver.findElement(By.cssSelector("h3[class='ng-binding']")).isDisplayed());
    if(driver.findElement(By.cssSelector("h3[class='ng-binding']")).isDisplayed()){
      //build Dashboard POM and logout
      driver.quit();
    }
  }
}
