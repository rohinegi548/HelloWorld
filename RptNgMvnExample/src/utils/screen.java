package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screen {
	
	public static String destfile="screenshots\\"+System.currentTimeMillis()+".png";
	
	public static String getscreen(WebDriver driver){
		
		try{
			
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File(destfile));
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return "..\\"+destfile;
	}

}
