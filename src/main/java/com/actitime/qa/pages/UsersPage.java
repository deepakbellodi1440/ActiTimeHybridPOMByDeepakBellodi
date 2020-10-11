package com.actitime.qa.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class UsersPage  extends TestBase{
	
	List<WebElement> oEles = null;
	public UsersPage() {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//table[@id=\"pageBody\"]/tbody/tr[1]/td[1]/div/span")
	WebElement UserTxt;
	
	public boolean verifyTextinUserPage() {
		return UserTxt.isDisplayed();
	}
	
	@FindBy(xpath="//div[@id=\"createUserDiv\"]/div/div[2]")
	WebElement AddUserBTN;
	
	
	@FindBy(xpath="//input[@id=\"userDataLightBox_firstNameField\"]")
	WebElement FirstNameTxtArea;
	
	@FindBy(xpath="//input[@id=\"userDataLightBox_lastNameField\"]")
	WebElement LastNameTxtArea;
	
	@FindBy(xpath="//input[@id=\"userDataLightBox_emailField\"]")
	WebElement emailTxtArea;
	
	@FindBy(xpath="//input[@id=\"userDataLightBox_usernameField\"]")
	WebElement UserNameTxtArea;
	
	@FindBy(xpath="//input[@id=\"userDataLightBox_passwordField\"]")
	WebElement PasswordTxtArea;
	
	@FindBy(xpath="//input[@id=\"userDataLightBox_passwordCopyField\"]")
	WebElement RePasswordTxtArea;
	
	@FindBy(xpath="//*[@id=\"userDataLightBox_hireDatePlaceholder\"]")
	WebElement ClickOnDateOption;
	
	@FindBy(xpath="//button[@id=\"ext-gen325\"]")
	WebElement ClickOnSelectDateOption;	
	
	@FindBy(xpath="//div[@id=\"userDataLightBox_commitBtn\"]")
	WebElement CreateUserBTN;	
	
	public void addUser(String FirstName,String LastName,String Email,String UserName ,String password,String RePassword ) {
		//Thread .sleep(2000);
		oEles = driver.findElements(By.xpath("//div[@id='gettingStartedShortcutsMenuWrapper']"));
		if(oEles.size()>0)
		{
			System.out.println("found  the shourtcutc menu");
			driver.findElement(By.xpath("//div[@id='gettingStartedShortcutsMenuCloseId']")).click();
		}else {
			System.out.println("Error while detecting the shourtcutc menu");
		}
		AddUserBTN.click();
		FirstNameTxtArea.sendKeys(FirstName);
		LastNameTxtArea.sendKeys(LastName);
		emailTxtArea.sendKeys(Email);
		UserNameTxtArea.sendKeys(UserName);
		PasswordTxtArea.sendKeys(password);
		RePasswordTxtArea.sendKeys(RePassword);
		/*ClickOnDateOption.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(ClickOnSelectDateOption).build().perform();
		//ClickOnSelectDateOption.click();
		 * 
		*/
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CreateUserBTN.click();
		
	}
	
	@FindBy(xpath="//*[@id=\"userListTableContainer\"]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")
	WebElement ClickOnUserText;
	
	@FindBy(xpath="//button[@id=\"userDataLightBox_deleteBtn\"]")
	WebElement ClickOnDeleteBTN;
	
	public void deleteUser() {
		ClickOnUserText.click();
		ClickOnDeleteBTN.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	
	
	/*public void addUser() {
		Actions actions = new Actions(driver);
		action.
	}*/
}
