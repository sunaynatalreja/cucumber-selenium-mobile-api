package prjframework.sunaynatalreja.framework.config;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

import prj.sunaynatalreja.logutil.Log;

/**
 * @author Sunayna Talreja
 * Base Class
*/
public class BaseClass  {
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		Log.setMessageInfo(method.getName());
		
	}
	
	

}
