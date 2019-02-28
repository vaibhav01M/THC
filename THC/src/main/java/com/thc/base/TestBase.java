package com.thc.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.thc.util.TestUtil;
import com.thc.util.WebEventListener;

public class TestBase {

	public static String ProjectLoction = System.getProperty("user.dir");
	public static WebDriver driver ;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver ;
	public static WebEventListener eventListener ; 
	
	
	
	public TestBase(){  // TestBase Constructor -- reading property file code
		 
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(ProjectLoction+"/src/main/java/com/thc/config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void initialization(){   // Browser launch + url entering
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "F:/Java Basic/THC/lib/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "Firefox":
			System.setProperty("webdriver.firefox.driver", "F:/Java Basic/THC/lib/geckodriver.exe");
			driver = new FirefoxDriver();			
			break;
			
		case "IE":
			
			break;
			
		case "safari":
			
			break;
			
		default:
			System.out.println("Check properties file for valid browser");
			break;
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		FluentWait wait = new FluentWait (driver);
		wait.withTimeout(10, TimeUnit.SECONDS);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.impliciteWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
	}
	 
}
 

 











