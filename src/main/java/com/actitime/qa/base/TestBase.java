package com.actitime.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.actitime.qa.utilies.TestUtil;
import com.actitime.qa.utilies.WebEventListener;

public class TestBase {
public  static	WebDriver driver;
  public static Properties prop;
  public static EventFiringWebDriver firingDriver;
  public static WebEventListener eventListner;
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream fileInputStream = new FileInputStream("E:\\Work\\javaworkspace\\com.company.ActitimeHybrid\\src\\main\\java\\com\\actitime\\qa\\config\\config.properties");
			prop.load(fileInputStream);
		
		}catch (FileNotFoundException e) {
			System.out.println(" "+e);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("error"+e);
		}
	}
	
	//initialization of chrome browser 
	public static void initializtion() {
		String browserName=prop.getProperty("browser");
		System.out.println("browsername "+ browserName);
		
		if (browserName.equals("chrome")) {
			//System.setProperties(arg0);
			System.setProperty("webdriver.chrome.driver", "E:\\Work\\javaworkspace\\SeleniumProjects\\COMMON_JARS_FILES\\RealBrowserDriver\\chromedriver.exe");
			driver =new ChromeDriver();
		}else if(browserName.equals("FF")) {
			//System.setProperties(arg0);
			System.setProperty("webdriver.gecko.driver", "E:\\Work\\javaworkspace\\SeleniumProjects\\COMMON_JARS_FILES\\RealBrowserDriver\\geckodriver.exe");
			driver =new ChromeDriver();
		}
		firingDriver =new EventFiringWebDriver(driver);
		eventListner = new WebEventListener();
		firingDriver.register(eventListner);
		driver =firingDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//navigate to the url
		driver.get(prop.getProperty("url"));
	}
	
}
