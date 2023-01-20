package com.hrm.ObjectRepo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.WebDriverUtility;

public class HrAssistant_DeleteEmployee 
{
	@FindBy(xpath="(//td[@class='sorting_1'])[1]")
	private WebElement plusRadioBtn;
	
	@FindBy(xpath="(//i[@class='fa fa-trash'])[2]")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//button[.='Delete']")
	private WebElement deleteClickAss;

	public WebElement getPlusRadioBtn() {
		return plusRadioBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	public WebElement getDeleteClickAss() {
		return deleteClickAss;
	}
	
	public HrAssistant_DeleteEmployee(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void deleteEmployeeAss(WebDriver driver,WebDriverUtility wb)
	{
		String expected="Delete Successfully!!!";
		plusRadioBtn.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		deleteBtn.click();
		deleteClickAss.click();
		String actual = wb.getTextAlert(driver);
		if(expected.equalsIgnoreCase(actual)) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Not Deleted");
		}
		wb.switchToAlertWindowAndAccept(driver);
	
		
		
	}

	

	
}
