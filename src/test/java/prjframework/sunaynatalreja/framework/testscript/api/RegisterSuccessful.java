/**
 * 
 */
package prjframework.sunaynatalreja.framework.testscript.api;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import prjframework.sunaynatalreja.apirequests.APIRequests;
import prjframework.sunaynatalreja.apiresponse.registersuccessfulresponse.RegisterSuccessfulResponse;
import prjframework.sunaynatalreja.dataprovider.DataProviderClass;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.listeners.ExtentReportListener;
import prj.sunaynatalreja.logutil.Log;


/**
 * @author Sunayna Talreja
 * Test class for register successful api test cases
 */

@Listeners(ExtentReportListener.class)
public class RegisterSuccessful {

	@SuppressWarnings("static-access")
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");

	}


	@Test(dataProvider = "getDataRegisterSuccess" , dataProviderClass = DataProviderClass.class)
	public void registerSuccessTest(Map<String,String> data,ITestContext context)
	{
		Log.setMessageInfo("Running Test register success");
		Log.setMessageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			RegisterSuccessfulResponse response=APIRequests.getInstance().getRegisterSuccessfulResponse(data);
			softAssert.assertTrue(response.getToken().length()!=0);
			softAssert.assertTrue(response.getId().length()!=0);

		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.setMessageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.setMessageInfo("Register Success Post Completed"); 
	}



}
