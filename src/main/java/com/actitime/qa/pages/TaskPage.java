package com.actitime.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.utilies.TestUtil;

public class TaskPage  extends TestBase{
	TestUtil testUtil;
	List<WebElement> oEles = null;
	
	//intiation of pageFactory
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	//To verify the text present
	@FindBy(xpath="//div[@class='title ellipsis' and contains(text(),'Customers & Projects')]")
	WebElement VerifyText;
	
	//add tasks
	@FindBy(xpath="//*[@id=\"taskListBlock\"]/div[1]/div[1]/div[3]/div/div[2 and text()='Add New Task']")
	WebElement clickOnTaskButton;
	
//	oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[1]/div[1]/div[3]/div")).click();
	@FindBy(xpath="//div[@class='item createNewTask ellipsis' and text()='Create new tasks']")
	WebElement clickOnSelectNewTask;
	
	@FindBy(xpath="//*[@id=\"createTasksPopup_createTasksTableContainer\"]/table/tbody/tr[1]/td[1]/input")
	WebElement enterTaskName;

	@FindBy(xpath="//td[@id=\"descriptionCell0\"]")
	WebElement enterDescriptionOfTask;
	
	@FindBy(xpath="//textarea[@id='editDescriptionPopupText']")
	WebElement editDescriptionPopupEditingState;
	
	
	@FindBy(xpath="//input[@id='scbutton']")
	WebElement enterDescriptionButtonSave;
	
	@FindBy(xpath="//*[@id=\"ext-gen649\"]/tbody/tr[2]/td/table/tbody/tr[5]/td[3]/a/em/span")
	WebElement selectdate;
	
	
	@FindBy(xpath="//*[@id=\"ext-gen174\"]")
	WebElement enterbillable;
	
	@FindBy(xpath="//*[@id=\"createTasksPopup_createTasksTableContainer\"]/table/tbody/tr[1]/td[5]/div/input")
	WebElement clickoncheckBox;
	
	@FindBy(xpath="//div[@id='createTasksPopup_commitBtn']")
	WebElement clickCreateTask;
	
	
	//For check task created or not
	@FindBy(xpath="//div[@class='title ellipsis' and text()='actitime123']")
	WebElement checkTaskcreted;
	
	public boolean textverify() {
		return VerifyText.isDisplayed();
	}
	 public void addNewTask()  {
		 try {
			 
			Thread.sleep(2000);
			//testUtil.checkshortcutwindowPresent();
			oEles = driver.findElements(By.xpath("//div[@id='gettingStartedShortcutsMenuWrapper']"));
			if(oEles.size()>0)
			{
				System.out.println("found  the shourtcutc menu");
				driver.findElement(By.xpath("//div[@id='gettingStartedShortcutsMenuCloseId']")).click();
			}else {
				System.out.println("Error while detecting the shourtcutc menu");
			}
			 clickOnTaskButton.click();
			 clickOnSelectNewTask.click();
			 enterTaskName.sendKeys("actitime123");
			 enterDescriptionOfTask.click();
			 editDescriptionPopupEditingState.sendKeys("Actitime is Best for bigineers");
			 enterDescriptionButtonSave.click();
			 selectdate.click();
			 enterbillable.click();
			 clickoncheckBox.click();
			 clickCreateTask.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		 
	 }
	 
	public boolean checkTaskCreated() {
			return	checkTaskcreted.isDisplayed();
	}
}
