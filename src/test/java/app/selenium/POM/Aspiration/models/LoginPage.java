package app.selenium.POM.Aspiration.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    @FindBy(css = "input[id='signinEmail']")
    private WebElement EmailBox;
    @FindBy(css="input[id='signinPassword']")
    private WebElement PasswordBox;
    @FindBy(css = "button[id][type='submit']" )
    private WebElement LoginButton;
    public LoginPage(WebDriver d){
        driver=d;
        PageFactory.initElements(d, this);
    }
    public WebElement getEmailBox() {
        return EmailBox;
    }
    public void setEmailBox(String emailBox) {
        EmailBox.sendKeys(emailBox);
    }
    public WebElement getPasswordBox() {
        return PasswordBox;
    }
    public void setPasswordBox(String passwordBox) {
        PasswordBox.sendKeys(passwordBox);
    }
    public WebElement getLoginButton() {
        return LoginButton;
    }
    public void clickLoginButton(){
        while(!LoginButton.isDisplayed() && !LoginButton.isEnabled()){
            System.out.print("Buffer.....");
        }
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(LoginButton)).click();

    }
}
