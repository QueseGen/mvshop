package app.selenium.POM.Aspiration.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
  private final WebDriver driver;
  @FindBy(xpath="/html/body/div[1]/div/header/ul[1]/li[1]/a")
  private WebElement EnterpriseButton;
  @FindBy(xpath="/html/body/div[1]/div/header/ul[1]/li[2]/a")
  private WebElement PersonalButton; //= MenuButtons.get(0);
  public HomePage(WebDriver d){
    driver=d;
    PageFactory.initElements(d, this);
  }
  public WebElement getEnterpriseButton() {
    return EnterpriseButton;
  }
  public void clickEnterpriseButton() {
    while(!EnterpriseButton.isDisplayed() && !EnterpriseButton.isEnabled()){
      System.out.print("Buffer.....");
    }
    new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(EnterpriseButton)).click();
  }
  public WebElement getPersonalButton() {
    return PersonalButton;
  }
  public void clickPersonalButton() {
    while(!PersonalButton.isDisplayed() && !PersonalButton.isEnabled()){
      System.out.print("Buffer.....");
    }
    new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(PersonalButton)).click();
  }
}
