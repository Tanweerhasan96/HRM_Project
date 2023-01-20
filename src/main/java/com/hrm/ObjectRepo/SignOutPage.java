package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.WebDriverUtility;

public class SignOutPage 
{
  @FindBy(xpath="(//a[@class='nav-link'])[2]")
  private WebElement welcomeBtn;
  @FindBy(xpath="(//a[@class='dropdown-item'])[2]")
  private WebElement logoutBtn;
  
  public SignOutPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getWelcomeBtn() {
	return welcomeBtn;
}

public WebElement getLogoutBtn() {
	return logoutBtn;
}
  public void logout(WebDriverUtility wLib,WebDriver driver)
  {
	  welcomeBtn.click();
	  logoutBtn.click();
	  wLib.switchToAlertWindowAndAccept(driver);
	  
  }
  
}
