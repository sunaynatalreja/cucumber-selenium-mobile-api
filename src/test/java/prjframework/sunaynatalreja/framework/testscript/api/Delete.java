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
import prjframework.sunaynatalreja.dataprovider.DataProviderClass;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prj.sunaynatalreja.logutil.Log;
import com.jayway.restassured.response.Response;

/**
 * @author Sunayna Talreja
 * Test class for Delete api test cases
*/

public class Delete {

	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	@Test(dataProvider = "deleteUser" , dataProviderClass = DataProviderClass.class)
	public void registerSuccessTest(Map<String,String> data,ITestContext context)
	{
		Log.messageInfo("Running Delete");
		Log.messageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			Response response=APIRequests.getDeleteResponse(data);
			softAssert.assertTrue(response.statusCode()>=200 && response.statusCode()<=299);
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.messageInfo("Delete Completed");
		  
	}
}
