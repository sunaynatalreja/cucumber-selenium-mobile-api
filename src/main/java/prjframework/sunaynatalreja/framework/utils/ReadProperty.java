/**
 * 
 */
package prjframework.sunaynatalreja.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Sunayna Talreja
*/
public class ReadProperty {
	
static Properties prop=new Properties();
	
/*
 * Reads property from config.properties file
 * 
 */
	public static String getProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("src\\main\\resources\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

}
