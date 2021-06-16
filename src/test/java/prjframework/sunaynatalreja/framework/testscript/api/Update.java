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
import prjframework.sunaynatalreja.apiresponse.update.UpdateUser;
import prjframework.sunaynatalreja.dataprovider.DataProviderClass;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prj.sunaynatalreja.logutil.Log;



/**
 * @author Sunayna Talreja
 * Test class for update user api test cases
*/

public class Update {
	
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	
	@Test(dataProvider = "updateUser" , dataProviderClass = DataProviderClass.class)
	public void update(Map<String,String> data,ITestContext context)
	{
		Log.messageInfo("Running Update");
		Log.messageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			UpdateUser response=APIRequests.getUpdateResponse(data);
			softAssert.assertTrue(response.job.length()>0);
			softAssert.assertTrue(response.name.length()>0);
			softAssert.assertTrue(response.updatedAt.length()>0);
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		 Log.messageInfo("Update Completed"); 
	}

}
