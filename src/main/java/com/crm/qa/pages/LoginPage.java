package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")

	WebElement loginBtn;
	
	@FindBy(css = "[color]")
	WebElement signUpBtn;
	
	@FindBy(css = "[alt='free crm logo']")
    WebElement crmLogo;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	
	
	public HomePage login(String un, String pw)  {
		username.sendKeys(un);
		password.sendKeys(pw);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", loginBtn); 
	  //  loginBtn.click();
		return new HomePage();
		
		
	}
		
	
	
	
	
	
}
