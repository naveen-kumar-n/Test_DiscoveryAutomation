package com.TestDiscovery;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationTest {

	// TODO Auto-generated method stub

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		//	favirateVideo();
		closeApplication();
	}
	/***************************************
	 * Method:	launch the Browser
	 * *************************************
	 */
	static void launchBrowser()
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Selenium\\Drivers\\chromedriver.exe");
		oBrowser=new ChromeDriver();

		oBrowser.manage().window().maximize();
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/***************************************
	 * Method:	Navigate to Discovery.com Site
	 * *************************************
	 */
	static void navigate()
	{
		try
		{
			oBrowser.get("https:\\www.discovery.com");
			//Thread.sleep(5000);
			WebDriverWait Wait = new WebDriverWait(oBrowser,5000);
			Wait.until(ExpectedConditions.visibilityOf(oBrowser.findElement(By.className("o-Header__m-SiteLogo"))));
			
			oBrowser.findElement(By.xpath("//span[contains(text(), 'More')]")).click();
		//	oBrowser.findElement(By.linkText("More")).click();  
			oBrowser.findElement(By.linkText("My Videos")).click();
			Thread.sleep(5000);
			System.out.println(oBrowser.getCurrentUrl());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/***************************************
	 * Method:	Select the Video from Browser
	 * *************************************
	 */
	static void favirateVideo() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) oBrowser;
			js.executeScript("window.scrollTo(1,500)");
			//Window.scrollTo(1,500);
			oBrowser.findElement(By.className("a-Button__a-ButtonText")).click();
			oBrowser.findElement(By.className("o-Header__a-NavLink")).click();  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/***************************************
	 * Method:	TearDown the Browser
	 * *************************************
	 */
	static void closeApplication()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
