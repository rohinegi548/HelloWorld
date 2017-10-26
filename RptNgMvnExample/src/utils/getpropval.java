package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class getpropval {
	
	public static FileInputStream file;
	static Properties p=new Properties();
	
	public static String getproperty(String key){
		
		try{
			
			file=new FileInputStream("properties\\testdata.properties");
			
			p.load(file);

		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return p.getProperty(key);
		
	}
	
	/*public static String getproperty(String key){
		
		
		
		return p.getProperty(key);
		
	}
	*/
}
