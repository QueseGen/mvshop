package app.selenium.POM.Aspiration.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

  private final WebDriver driver;
  @FindBy(css = "a[href][ng-click='$root.signup()']")
    private WebElement RegLink;
    @FindBy(css = "input[type='email']")
    private WebElement EmailBox;
    @FindBy(css ="button[type='submit']")
    private WebElement SubmitButton;
    @FindBy(css ="h4[class='modal-title ng-binding']")
    private WebElement MessageText;
    @FindBy(css = "button[class='btn-sapling btn--solid btn--block btn-sapling btn--solid']")
    private WebElement MessageButton;
    public RegistrationPage(WebDriver d){
      driver=d;
      PageFactory.initElements(driver, this);
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