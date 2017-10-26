package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class getdriver {
	
	public static WebDriver driver;
	
	public static WebDriver getwebdriver(String browser){
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("opera"))
		{
			
			System.setProperty("webdriver.opera.driver", "drivers\\operadriver.exe");
			driver=new OperaDriver();
			
		}
		
		driver.manage().window().maximize();
		return driver;
		
	}
	

}
