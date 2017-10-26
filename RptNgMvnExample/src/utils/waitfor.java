package utils;

import org.openqa.selenium.TimeoutException;

public class waitfor {
	
	public static void timewait(int time)throws TimeoutException, Exception{
		
		Thread.sleep(time*1000);
		
	}

}
