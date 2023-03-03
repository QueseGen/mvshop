package app.selenium.POM.aspiration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static app.selenium.POM.aspiration.TestConnection.getChromeDriver;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LoginPage {

    WebDriver driver;
    //Phase1
    String PageUrl="https://my.aspiration.com/auth/login/";

    By EmailBox=By.cssSelector("input[id='signinEmail']");
    By PasswordBox=By.cssSelector("input[id='signinPassword']");
    By LoginButton=By.cssSelector("button[id][type='submit']");

    @Test
    public void TestifPhase1ElementsPresent() {
        List<By> Elements = List.of(new By[]{EmailBox,PasswordBox, LoginButton});
        assertDoesNotThrow(() -> {
            WebDriver driver = getChromeDriver();
            driver.get(PageUrl);
            for (By element : Elements) { WebElement Cleared = driver.findElement(element);}});
    }
}
