package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.IPathConstants;
import com.hrm.genericUtility.WebDriverUtility;

public class LoginPage 
{
	//declaration
	@FindBy(name="hr_email")
	private WebElement hrtbx;
	
	@FindBy(name="hr_password")
	private WebElement pwdtbx;
	
	@FindBy(name="hr_type")
	private WebElement typeDD;
	
	@FindBy(name="login_hr")
	private WebElement lgbtn;
	
	//Initialization
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getHrtbx() {
		return hrtbx;
	}

	public WebElement getPwdtbx() {
		return pwdtbx;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	//Business Library
	public void HrAssistantLogin(WebDriverUtility wLib,WebDriver driver)
	{
		hrtbx.sendKeys(IPathConstants.hrassistantemail);
		pwdtbx.sendKeys(IPathConstants.hrassistantpwd);
		wLib.select(typeDD, 3);
		lgbtn.click();
		wLib.switchToAlertWindowAndAccept(driver);
	}
	
	public void HrHeadLogin(WebDriverUtility wLib,WebDriver driver)
	{
		hrtbx.sendKeys(IPathConstants.hrheademail);
		pwdtbx.sendKeys(IPathConstants.hrheadpwd);
		wLib.select(typeDD, 1);
		lgbtn.click();
		wLib.switchToAlertWindowAndAccept(driver);
	}
	public void HrOfficerLogin(WebDriverUtility wLib,WebDriver driver)
	{
		hrtbx.sendKeys(IPathConstants.hrofficeremail);
		pwdtbx.sendKeys(IPathConstants.hrofficerpwd);
		wLib.select(typeDD, 2);
		lgbtn.click();
		wLib.switchToAlertWindowAndAccept(driver);
	}

}
