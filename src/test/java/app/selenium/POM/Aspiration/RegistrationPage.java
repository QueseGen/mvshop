package app.selenium.POM.Aspiration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    @FindBy(css = "a[href][ng-click='$root.signup()']")
    WebElement RegLink;
    @FindBy(css = "input[type='email']")
    WebElement EmailBox;
    @FindBy(css ="button[type='submit']")
    WebElement SubmitButton;
    @FindBy(css ="h4[class='modal-title ng-binding']")
    WebElement MessageText;
    @FindBy(css = "button[class='btn-sapling btn--solid btn--block btn-sapling btn--solid']")
    WebElement MessageButton;
    RegistrationPage(WebDriver d){
        driver=d;
        PageFactory.initElements(d, this);
    }
    public WebElement getRegLink() {
        return RegLink;
    }
    public void clickRegLink() {
        RegLink.click();
    }
    public WebElement getEmailBox() {
        return EmailBox;
    }
    public void setEmailBox(String emailBox) {
        EmailBox.sendKeys(emailBox);
    }
    public WebElement getSubmitButton() {
        return SubmitButton;
    }
    public void clickSubmitButton() {
        SubmitButton.click();
    }
    public WebElement getMessageText() {
        return MessageText;
    }
    public void setMessageText(String messageText) {
        MessageText.sendKeys(messageText);
    }
    public WebElement getMessageButton() {
        return MessageButton;
    }
    public void clickMessageButton() {
        MessageButton.click();
    }
}