package app.selenium.POM.Aspiration.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(css = "input[id='signinEmail']")
    WebElement EmailBox;
    @FindBy(css="input[id='signinPassword']")
    WebElement PasswordBox;
    @FindBy(css = "button[id][type='submit']" )
    WebElement LoginButton;
    LoginPage(WebDriver d){
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
        LoginButton.click();
    }
}
