package com.company.ActitimeHybrid;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	TimeTrackPage timeTrackpage;
	public LoginPageTest() {
		super();// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() {
		initializtion(); 
		loginpage = new LoginPage();
	}
	
	@Test(priority =2,enabled=false)
	public void LoginPageTitleTest() {
		String title= loginpage.validateLogonPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	@Test(priority =1  )
	public void LoginPageLogoTest() {
		
		boolean flag=loginpage.validateimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3,enabled=false)
	public void checkLoginTest() {
	timeTrackpage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
