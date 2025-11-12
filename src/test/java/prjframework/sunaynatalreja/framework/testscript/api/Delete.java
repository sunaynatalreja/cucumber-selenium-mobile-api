package prjframework.sunaynatalreja.framework.testscript.api;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import prjframework.sunaynatalreja.apirequests.APIRequests;
import prjframework.sunaynatalreja.dataprovider.DataProviderClass;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.listeners.ExtentReportListener;
import prj.sunaynatalreja.logutil.Log;
import io.restassured.response.Response;

/**
 * @author Sunayna Talreja
 * Test class for Delete api test cases
*/

@Listeners(ExtentReportListener.class)
public class Delete {

	@SuppressWarnings("static-access")
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	@Test(dataProvider = "deleteUser" , dataProviderClass = DataProviderClass.class)
	public void registerSuccessTest(Map<String,String> data,ITestContext context)
	{
		Log.setMessageInfo("Running Delete");
		Log.setMessageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			Response response=APIRequests.getInstance().getDeleteResponse(data);
			softAssert.assertTrue(response.statusCode()>=200 && response.statusCode()<=299);
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.setMessageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.setMessageInfo("Delete Completed");
		  
	}
}
