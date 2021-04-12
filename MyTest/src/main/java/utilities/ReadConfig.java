package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("C:\\Users\\NKusingh\\eclipse-workspace\\MyTest\\src\\main\\java\\config\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String readFromPropertyFile(String key)
	{
		String value=pro.getProperty(key);
		return value;
	}
	
	
	
}
