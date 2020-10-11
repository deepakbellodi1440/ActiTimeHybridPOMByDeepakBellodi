package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class LoginPage extends TestBase{
	
		//Declare pageFactrory or Object Repositary
		@FindBy(id="username")
		WebElement username;
		
		@FindBy(name="pwd")
		WebElement password;
		
		@FindBy(id="loginButton")
		WebElement loginBtn;
		
		@FindBy(id="logoContainer")
		WebElement actitimeLogo;
		//methods
		public LoginPage() {
			PageFactory.initElements(driver, this);//this refer to curent class
		}
		
		public String validateLogonPageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateimage() {
			return actitimeLogo.isDisplayed();
		}
		public TimeTrackPage login(String un,String pwd) {
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			return new TimeTrackPage();
		}
}
