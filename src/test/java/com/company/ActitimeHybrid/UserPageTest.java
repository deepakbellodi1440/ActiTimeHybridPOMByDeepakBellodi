package com.company.ActitimeHybrid;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TaskPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.utilies.TestUtil;

public class UserPageTest extends TestBase{
	TimeTrackPage timetrackpage;
	LoginPage loginpage; 
	TaskPage taskpage;
	UsersPage userspage;
	TestUtil testutil;
	String SheetName ="Users";
	@BeforeMethod
	public void setUp() {
		initializtion(); 
		loginpage = new LoginPage();
		timetrackpage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		userspage =timetrackpage.usersPageLink();
	}
	@Test(priority =1,enabled =false )//,enabled=false
	public void VerifyTextInUerPage() {
		boolean textPresent =userspage.verifyTextinUserPage();
		Assert.assertTrue(textPresent,"Text not displayed or not present ");
	}
	
	@Test(priority=2,dataProvider="getActitimeTestData",enabled =false)//,enabled=false
	public void CreateUser(String FirstName,String LastName,String Email,String UserName ,String password,String RePassword ) {
		userspage.addUser(FirstName,LastName,Email,UserName,password,password);
		 
	}
	
	@DataProvider
	public Object[][] getActitimeTestData() {
		Object testdata[][] =testutil.getTestData(SheetName);
		return testdata;
	}
	@Test(priority =2,enabled =false)
	public void createUserUsingDataDrivenFrameWork() {
		
	}
	
	@Test(priority=3)
	public void deleteUSer() {	
		userspage.deleteUser();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
