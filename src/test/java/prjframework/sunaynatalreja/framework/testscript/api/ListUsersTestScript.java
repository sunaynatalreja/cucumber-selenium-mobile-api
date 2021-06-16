/**
 * 
 */
package prjframework.sunaynatalreja.framework.testscript.api;

import java.util.List;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import prjframework.sunaynatalreja.apirequests.APIRequests;
import prjframework.sunaynatalreja.apiresponse.listusers.ListUsers;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prj.sunaynatalreja.logutil.Log;


/**
 * @author Sunayna Talreja
 * Test class for ListUsers api test cases
*/

public class ListUsersTestScript {
	
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	@Test
	public void listUsers(ITestContext context)
	{
		Log.messageInfo("Running List Users Data");
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", "");
		try {
			List<ListUsers> response=APIRequests.getListUsersResponse();
			softAssert.assertTrue(response.size()>0);
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.messageInfo("List User fetched successfully");  
	}


}
