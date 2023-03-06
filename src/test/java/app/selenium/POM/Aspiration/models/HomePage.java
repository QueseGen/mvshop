package app.selenium.POM.Aspiration.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
  private final WebDriver driver;
  @FindBy(css="a[class='Element-sc-1dc3ws0-0 Link__StyledLink-sc-17puyxl-0 ccfGTi cQEErc atom-link']")
  private List<WebElement> MenuButtons;
  private WebElement EnterpriseButton;
  private WebElement PersonalButton; //= MenuButtons.get(0);

  public HomePage(WebDriver d){
    driver=d;
    PageFactory.initElements(d, this);
  }
  public List<WebElement> getMenuButtons() {
    return MenuButtons;
  }

  public WebElement getEnterpriseButton() {
    EnterpriseButton= getMenuButtons().get(0);
    return EnterpriseButton;
  }

  public void clickEnterpriseButton() {
    while(!EnterpriseButton.isDisplayed() && !EnterpriseButton.isEnabled()){
      System.out.print("Buffer.....");
    }
    new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(EnterpriseButton)).click();
  }

  public WebElement getPersonalButton() {
    PersonalButton= getMenuButtons().get(1);
    return PersonalButton;
  }

  public void clickPersonalButton() {
    while(!PersonalButton.isDisplayed() && !PersonalButton.isEnabled()){
      System.out.print("Buffer.....");
    }
    new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(PersonalButton)).click();
  }
}
