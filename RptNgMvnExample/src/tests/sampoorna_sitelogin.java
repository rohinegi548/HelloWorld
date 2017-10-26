package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.getdriver;
import utils.getpropval;
import utils.screen;
import utils.waitfor;

public class sampoorna_sitelogin {
  
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters("browser")
	public void setup(String browser){
		
		try{
			
		driver=getdriver.getwebdriver(browser);
		Reporter.log("Opening browser: "+driver.toString());
		driver.get(getpropval.getproperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement log_or_reg=driver.findElement(By.xpath(getpropval.getproperty("login_link")));
		log_or_reg.click();
		waitfor.timewait(5);
		
		}catch(Exception e){
			
			Reporter.log(e.toString());
			
		}
		
		
	}
	
	@Test(dataProvider="testdata",groups={"Positive"})
	public void gmail_valid_login(String usr, String password) throws TimeoutException, Exception{
		
//		try{
			
			driver.get(getpropval.getproperty("url3"));
			waitfor.timewait(5);
			WebElement user=driver.findElement(By.xpath(getpropval.getproperty("gmailtxt")));
			user.clear();user.sendKeys(usr);
			waitfor.timewait(2);
			WebElement next=driver.findElement(By.xpath(getpropval.getproperty("gmailnext")));
			next.click();
			waitfor.timewait(4);
			WebElement pass=driver.findElement(By.xpath(getpropval.getproperty("gmailpass")));
			pass.clear();pass.sendKeys(password);
			waitfor.timewait(2);
			WebElement btnlogin=driver.findElement(By.xpath(getpropval.getproperty("gmailsign")));
			btnlogin.click();
			waitfor.timewait(10);
			Assert.assertTrue(driver.getPageSource().contains(getpropval.getproperty("EMAIL")));
			Reporter.log("Test Passed! for username: "+usr+" and password: "+password );
					
			/*}catch(Exception e){
				
				Reporter.log(e.toString());
				
			}*/
		
	}
	
	@Test(dataProvider="testdata",groups={"Positive"})
	public void valid_user_valid_pass(String usr, String password){
		
		try{
			
		driver.get(getpropval.getproperty("url2"));
		waitfor.timewait(5);
		WebElement user=driver.findElement(By.id(getpropval.getproperty("username")));
		user.clear();user.sendKeys(usr);
		waitfor.timewait(2);
		WebElement pass=driver.findElement(By.id(getpropval.getproperty("password")));
		pass.clear();pass.sendKeys(password);
		waitfor.timewait(2);
		WebElement btnlogin=driver.findElement(By.xpath(getpropval.getproperty("loginbtn")));
		btnlogin.click();
		waitfor.timewait(8);
		Assert.assertTrue(driver.getPageSource().contains(getpropval.getproperty("userid")));
		Reporter.log("Test Passed! for username: "+usr+" and password: "+password );
				
		}catch(Exception e){
			
			Reporter.log(e.toString());
			
		}
		
		
	}
	
	@Test(dataProvider="testdata",groups={"Negative"})
	public void invalid_user_valid_pass(String usr, String password){
		
		try{
			
			driver.get(getpropval.getproperty("url2"));
			waitfor.timewait(5);
			WebElement user=driver.findElement(By.id(getpropval.getproperty("username")));
			user.clear();user.sendKeys(usr);
			waitfor.timewait(2);
			WebElement pass=driver.findElement(By.id(getpropval.getproperty("password")));
			pass.clear();pass.sendKeys(password);
			waitfor.timewait(2);
			WebElement btnlogin=driver.findElement(By.xpath(getpropval.getproperty("loginbtn")));
			btnlogin.click();
			waitfor.timewait(8);
			Assert.assertTrue(driver.getPageSource().contains(getpropval.getproperty("userid")));
			Reporter.log("Test Failed! for username: "+usr+" and password: "+password );
					
			}catch(Exception e){
				
				Reporter.log(e.toString());
				
			}
		
	}
	
	@Test(dataProvider="testdata",groups={"Negative"})
	public void valid_user_invalid_pass(String usr, String password){
		
		try{
			
			driver.get(getpropval.getproperty("url2"));
			waitfor.timewait(5);
			WebElement user=driver.findElement(By.id(getpropval.getproperty("username")));
			user.clear();user.sendKeys(usr);
			waitfor.timewait(2);
			WebElement pass=driver.findElement(By.id(getpropval.getproperty("password")));
			pass.clear();pass.sendKeys(password);
			waitfor.timewait(2);
			WebElement btnlogin=driver.findElement(By.xpath(getpropval.getproperty("loginbtn")));
			btnlogin.click();
			waitfor.timewait(8);
			Assert.assertTrue(driver.getPageSource().contains(getpropval.getproperty("userid")));
			Reporter.log("Test Failed! for username: "+usr+" and password: "+password );
					
			}catch(Exception e){
				
				Reporter.log(e.toString());
				
			}
		
	}
	
	@Test(dataProvider="testdata",groups={"Negative"})
	public void invalid_user_invalid_pass(String usr, String password){
		
		try{
			
			driver.get(getpropval.getproperty("url2"));
			waitfor.timewait(5);
			WebElement user=driver.findElement(By.id(getpropval.getproperty("username")));
			user.clear();user.sendKeys(usr);
			waitfor.timewait(2);
			WebElement pass=driver.findElement(By.id(getpropval.getproperty("password")));
			pass.clear();pass.sendKeys(password);
			waitfor.timewait(2);
			WebElement btnlogin=driver.findElement(By.xpath(getpropval.getproperty("loginbtn")));
			btnlogin.click();
			waitfor.timewait(8);
			Assert.assertTrue(driver.getPageSource().contains(getpropval.getproperty("userid")));
			Reporter.log("Test Failed! for username: "+usr+" and password: "+password );
					
			}catch(Exception e){
				
				Reporter.log(e.toString());
				
			}
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) throws InterruptedException{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			
			/*String capture_path=screen.getscreen(driver);
			Reporter.setEscapeHtml(true);
			Reporter.log("<br>  <img src='"+capture_path+"' height='100' width='100' /><br>");
			Reporter.log("<a href=" +capture_path+ ">click to open screenshot</a>");*/
			
			if (!result.isSuccess())
				catchExceptions(result);
				// Quit environment.
				Thread.sleep(1000);
				driver.quit();
			
		}
		
	}
	
	/*@AfterClass
	public void end(){
		
		driver.quit();
		
	}*/
	
	@AfterSuite
	public void onsuitend(){
		
		driver.get("http://localhost:8080/job/RptNgMvnExample/ws/RptNgMvnExample/reports/html/index.html");
		driver.quit();
		
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] gettestdata(Method mth){
		
		Object[][] result = null;
		
		if(mth.getName().equals("valid_user_valid_pass")){
			
			result=new Object[][]{
				
				{getpropval.getproperty("validuser"),getpropval.getproperty("validpass")}
			};
			
		}
		else if(mth.getName().equals("invalid_user_valid_pass")){
			
			result=new Object[][]{
				
				{getpropval.getproperty("invaliduser"),getpropval.getproperty("validpass")}
			};
			
		}
		else if(mth.getName().equals("valid_user_invalid_pass")){
			
			result=new Object[][]{
				
				{getpropval.getproperty("validuser"),getpropval.getproperty("invalidpass")}
			};
			
		}
		else if(mth.getName().equals("invalid_user_invalid_pass")){
			
			result=new Object[][]{
				
				{getpropval.getproperty("invaliduser"),getpropval.getproperty("invalidpass")}
			};
			
		}
		else if(mth.getName().equals("gmail_valid_login")){
			
			result=new Object[][]{
				
				{getpropval.getproperty("gmailuser"),getpropval.getproperty("gmailpassword")}
			};
			
		}
		return result;
	}
	
	
	
	public void catchExceptions(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		if (!result.isSuccess()) {
		try {
		String failureImageFileName = "sample1";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(failureImageFileName));
		String userDirector = System.getProperty("user.dir") + "/";
		String s1 = "<table><tr><td><font style=\"text-decoration: underline;\" size=\"3\" face=\"Comic sans MS\" color=\"green\"><b>Screenshot</b></font></td></tr> ";
		Reporter.log(s1);
		Reporter.log("<tr><td><a href=\""+ userDirector + failureImageFileName +"\"><img src=\"file:///" + userDirector+ failureImageFileName + "\" alt=\"\""+ "height='120' width='120'/></td></tr> ");
		Reporter.setCurrentTestResult(null);
		} catch (IOException e1) {
		e1.printStackTrace();
		}
		}
	}
	
}
