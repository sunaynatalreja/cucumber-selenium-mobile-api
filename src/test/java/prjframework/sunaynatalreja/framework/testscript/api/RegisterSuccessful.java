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
import prj.sunaynatalreja.logutil.Log;


/**
 * @author Sunayna Talreja
 * Test class for register successful api test cases
 */

public class RegisterSuccessful {

	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");

	}


	@Test(dataProvider = "getDataRegisterSuccess" , dataProviderClass = DataProviderClass.class)
	public void registerSuccessTest(Map<String,String> data,ITestContext context)
	{
		Log.messageInfo("Running Test register success");
		Log.messageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			RegisterSuccessfulResponse response=APIRequests.getRegisterSuccessfulResponse(data);
			softAssert.assertTrue(response.token.length()!=0);
			softAssert.assertTrue(response.id.length()!=0);

		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.messageInfo("Register Success Post Completed"); 
	}



}
