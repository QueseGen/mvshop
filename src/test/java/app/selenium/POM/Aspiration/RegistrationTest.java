package app.selenium.POM.Aspiration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static app.selenium.POM.Aspiration.TestConnection.getChromeDriver;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RegistrationTest {
    private final String PageUrl = "https://my.aspiration.com/auth/login/";

    //Phase1 Verify Registration Elements
    By RegLink = By.cssSelector("a[href][ng-click='$root.signup()']");
    By EmailBox = By.cssSelector("input[type='email']");
    By SubmitButton = By.cssSelector("button[type='submit']");

    //Phase2 Verify Confirmation Elements
    By MessageText = By.cssSelector("h4[class='modal-title ng-binding']");
    By MessageButton = By.cssSelector("button[class='btn-sapling btn--solid btn--block btn-sapling btn--solid']");
    
    @Test
    public void TestifPhase1ElementsPresent() {
        List<By> Elements = List.of(new By[]{RegLink, EmailBox, SubmitButton});
        assertDoesNotThrow(() -> {
            WebDriver driver = getChromeDriver();
            driver.get(PageUrl);
            for (By element : Elements) { WebElement Cleared = driver.findElement(element);}});
    }

    @Test
    public void TestifPhase2ElementsPresent() {
        List<By> Elements = List.of(new By[]{MessageText, MessageButton});
        assertDoesNotThrow(() -> {
            WebDriver driver = getChromeDriver();
            driver.get(PageUrl);
            for (By element : Elements) {WebElement Cleared = driver.findElement(element);}});
    }
}