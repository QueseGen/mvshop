package app.selenium.POM.Aspiration.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    String url =EnterpriseButton.getAttribute("href");
    driver.get(url);
    }
  public WebElement getPersonalButton() {
    return PersonalButton;
  }
  public void clickPersonalButton() {
    //String url =PersonalButton.getAttribute("href");
   //driver.get(url);
    PersonalButton.click();
  }
}
