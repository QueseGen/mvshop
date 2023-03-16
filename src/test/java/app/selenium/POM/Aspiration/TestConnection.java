package app.selenium.POM.Aspiration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestConnection {
  public static WebDriver getChromeDriver(){

    ChromeOptions options = new ChromeOptions();
    options.addArguments(CapabilityType.BROWSER_NAME, "chrome");
    options.addArguments( "--headless");
    options.addArguments("--start-maximized");
    options.addArguments( "--window-size=2560,1440");
    options.addArguments( "--ignore-certificate-errors");
    options.addArguments("--disable-extensions","--disable-dev-shm-usage","--disable-infobars");
    options.addArguments("--log-level=3");
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("webdriver.remote.session.capability-match", "newSession");
    options.addArguments("webdriver.remote.session.technology-preview");
    options.addArguments("--no-sandbox");

    return new ChromeDriver(options);
  }
  @BeforeAll
  public static void TestConnection2Aspiration(){
    assertDoesNotThrow(()->{
      WebDriver driver = getChromeDriver();
      driver.get("https://www.aspiration.com/");
      driver.quit();});
  }

}
