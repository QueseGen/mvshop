package app.selenium.POM.Aspiration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestConnection {
  static WebDriver getChromeDriver(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    options.addArguments(CapabilityType.BROWSER_NAME, "chrome");
    options.addArguments("webdriver.remote.session.capability-match", "newSession");
    options.addArguments("webdriver.remote.session.technology-preview", "newSession");

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
