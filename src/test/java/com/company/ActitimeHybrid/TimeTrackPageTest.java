package com.company.ActitimeHybrid;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TaskPage;
import com.actitime.qa.pages.TimeTrackPage;

public class TimeTrackPageTest extends TestBase {
	TimeTrackPage timetrackpage;
	LoginPage loginpage; 
	TaskPage taskpage;
	@BeforeMethod
	public void setUp() {
		initializtion(); 
		loginpage = new LoginPage();
		timetrackpage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority =1 )//,enabled=false
	public void timeTrackPageLogoutLinkPresent()
	{
		boolean title=timetrackpage.verifylogoutLinkPresent();
		System.out.println("title of the TimeTrackPAge "+title);
		//Assert.assertEquals(title, "actiTIME -  Enter Time-Track");
		Assert.assertTrue(title);
	}
	@Test(priority=2,enabled=false)// 
	public void createNewTask() {
		timetrackpage.clickNewTask();
	}
	@Test(priority =3,enabled =false)// 
	public void taskCreated() {
		boolean flag=timetrackpage.verifyThatTaskCreated();
		Assert.assertTrue(flag);
	}
	@Test(priority =4,enabled =false)
	public void checkTaskLinkisWorking() {
			taskpage =timetrackpage.tasksPageLink();	
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
