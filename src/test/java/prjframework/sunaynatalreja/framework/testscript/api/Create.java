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
import prjframework.sunaynatalreja.apiresponse.create.CreateResponse;
import prjframework.sunaynatalreja.dataprovider.DataProviderClass;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.config.BaseClass;
import prj.sunaynatalreja.logutil.Log;

/**
 * @author Sunayna Talreja
 * Test class for create api test cases
*/


public class Create extends BaseClass{
	
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	
	@Test(dataProvider = "getCreateData" , dataProviderClass = DataProviderClass.class)
	public void create(Map<String,String> data,ITestContext context)
	{
		Log.messageInfo("Running Test Create");
		Log.messageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			CreateResponse response=APIRequests.getCreateResponse(data);
			softAssert.assertTrue(response.id.length()!=0);
			softAssert.assertTrue(response.name.length()!=0);
			softAssert.assertTrue(response.job.length()!=0);
			softAssert.assertTrue(response.createdAt.length()!=0);		
			
			
		} catch (Exception e) {
			softAssert.assertTrue(false);
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.messageInfo("Create Completed");
		  
	}

}
