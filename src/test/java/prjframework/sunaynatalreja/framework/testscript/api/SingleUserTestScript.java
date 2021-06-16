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
import prj.sunaynatalreja.logutil.Log;


/**
 * @author Sunayna Talreja
 * Test class for single user api test cases
*/

public class SingleUserTestScript {
	
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	
	@Test(dataProvider = "getSingleUserData" , dataProviderClass = DataProviderClass.class)
	public void singleUser(Map<String,String> data,ITestContext context)
	{
		Log.messageInfo("Running Single User Data");
		Log.messageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			SingleUser response=APIRequests.getSingleUserResponse(data);
			softAssert.assertTrue(response.support.text.length()!=0);
			softAssert.assertTrue(response.support.url.length()!=0);
			softAssert.assertTrue(response.data.avatar.length()!=0);
			softAssert.assertTrue(response.data.email.length()!=0);
			softAssert.assertTrue(response.data.first_name.length()!=0);
			softAssert.assertTrue(response.data.last_name.length()!=0);
			softAssert.assertTrue(response.data.id.length()!=0);
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.messageInfo("Single User Fetch Completed");
		  
	}

}
