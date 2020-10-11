package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class TimeTrackPage extends TestBase{
	TaskPage taskPage;
	
	@FindBy(xpath="//td[contains(text(),'Enter Time-Track')]")
	WebElement textPresent;
	
	@FindBy(xpath="//nobr/span[@class='dashedLink' and contains(text(),'New')]")
	WebElement NewTimeTack;
	
	@FindBy(xpath="//button[@id='ext-gen119']")
	WebElement AddCustomerName;
	
	@FindBy(xpath="//button[@id='ext-gen128']")
	WebElement AddProjectName;
	
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder']")
	WebElement AddTaskName;
	
	@FindBy(xpath="//a[@id='descriptionElement']")
	WebElement AddTaskDescription;
	
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement AddTaskDescriptionDetails;
	
	@FindBy(xpath="//input[@id='scbutton']")
	WebElement AddTaskDescriptionDetailsClickOk;
	
	@FindBy(xpath="//span[@class='buttonTitle']")
	WebElement AddCreateTaskButton;
	
	@FindBy(xpath="//span[@class='task' and text()='actitime']")
	WebElement Taskcreated;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	WebElement TimeTaskTitle;
	
	@FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr[1]/td[3]/a/div")
	@CacheLookup
	WebElement clickOnTasksLink;
	
	@FindBy(xpath="//table[@id=\"topnav\"]/tbody/tr[1]/td[4]/a/div[1]")
	@CacheLookup
	WebElement clickOnReportsLink;
	
	@FindBy(xpath="//table[@id=\"topnav\"]/tbody/tr[1]/td[5]/a/div[1]")
	@CacheLookup
	WebElement clickOnUsersLink; 
	
	public TimeTrackPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifylogoutLinkPresent() {
		return TimeTaskTitle.isDisplayed();
	}
	
	public TaskPage tasksPageLink() {
		try {
			Thread.sleep(1000);
			 clickOnTasksLink.click();
			 return new TaskPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskPage;
		
	}
	
	public ReportsPage reportsPageLink() {
		clickOnReportsLink.click();
		 return new ReportsPage();
	}
	
	public UsersPage usersPageLink() {
		clickOnUsersLink.click();
		 return new UsersPage();
	}
	
	public void clickNewTask() {
		NewTimeTack.click();
		AddTaskName.sendKeys("actitime");
		AddTaskDescription.click();
		AddTaskDescriptionDetails.sendKeys("Actitime is the best CRM Project in the industry");
		AddTaskDescriptionDetailsClickOk.click();
		AddCreateTaskButton.click();
	}
	public boolean verifyThatTaskCreated() {
		return Taskcreated.isDisplayed();
	}
}
