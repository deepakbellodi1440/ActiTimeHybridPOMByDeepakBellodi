package com.company.ActitimeHybrid;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TaskPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.utilies.TestUtil;

public class TasksPageTest extends TestBase {
	LoginPage loginpage;
	TimeTrackPage timetrackpage;
	TaskPage taskpage;
	TestUtil testUtil =null; 
	@BeforeMethod
	public void setUp() {
		try {
		initializtion(); 
		loginpage = new LoginPage();
		timetrackpage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		taskpage=timetrackpage.tasksPageLink();
		Thread.sleep(1000);
		//testUtil.checkshortcutwindowPresent();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e );
		}
	}
	
	@Test(priority =1 ,enabled =false)//(To avoid running add theese  words
	public void verifyTextInTaskPage() {
		boolean flag=taskpage.textverify();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =2)
	public void CreateNewTask() {
		taskpage.addNewTask();
	}
	
	@Test(priority =3,enabled =false)
	public void taskCreatedOrNot() {
	boolean created=taskpage.checkTaskCreated();
		Assert.assertTrue(created);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
