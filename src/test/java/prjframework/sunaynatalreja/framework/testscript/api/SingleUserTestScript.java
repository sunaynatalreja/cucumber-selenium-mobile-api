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
import prjframework.sunaynatalreja.apiresponse.singleUser.SingleUser;
import prjframework.sunaynatalreja.dataprovider.DataProviderClass;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.listeners.ExtentReportListener;
import prj.sunaynatalreja.logutil.Log;


/**
 * @author Sunayna Talreja
 * Test class for single user api test cases
*/
@Listeners(ExtentReportListener.class)
public class SingleUserTestScript {
	
	@SuppressWarnings("static-access")
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	
	@Test(dataProvider = "getSingleUserData" , dataProviderClass = DataProviderClass.class)
	public void singleUser(Map<String,String> data,ITestContext context)
	{
		Log.setMessageInfo("Running Single User Data");
		Log.setMessageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			SingleUser response=APIRequests.getInstance().getSingleUserResponse(data);
			softAssert.assertTrue(response.getSupport().getText().length()!=0);
			softAssert.assertTrue(response.getSupport().getUrl().length()!=0);
			softAssert.assertTrue(response.getData().getAvatar().length()!=0);
			softAssert.assertTrue(response.getData().getEmail().length()!=0);
			softAssert.assertTrue(response.getData().getFirst_name().length()!=0);
			softAssert.assertTrue(response.getData().getLast_name().length()!=0);
			softAssert.assertTrue(response.getData().getId().length()!=0);
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.setMessageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.setMessageInfo("Single User Fetch Completed");
		  
	}

}
