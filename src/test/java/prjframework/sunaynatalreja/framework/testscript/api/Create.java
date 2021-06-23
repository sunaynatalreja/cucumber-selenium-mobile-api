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
import prjframework.sunaynatalreja.framework.listeners.ExtentReportListener;
import prj.sunaynatalreja.logutil.Log;

/**
 * @author Sunayna Talreja
 * Test class for create api test cases
*/

@Listeners(ExtentReportListener.class)

public class Create extends BaseClass{
	
	@SuppressWarnings("static-access")
	@BeforeClass
	public void init()
	{
		Cache.getInstance().putVal("ExcelFile","TestData.xlsx");
		
	}
	
	@Test(dataProvider = "getCreateData" , dataProviderClass = DataProviderClass.class)
	public void create(Map<String,String> data,ITestContext context)
	{
		Log.setMessageInfo("Running Test Create");
		Log.setMessageInfo("TestData : "+data.toString());
		SoftAssert softAssert = new SoftAssert(); 
		context.setAttribute("Data", data.toString());
		try {
			CreateResponse response=APIRequests.getInstance().getCreateResponse(data);
			softAssert.assertTrue(response.getId().length()!=0);
			softAssert.assertTrue(response.getName().length()!=0);
			softAssert.assertTrue(response.getJob().length()!=0);
			softAssert.assertTrue(response.getCreatedAt().length()!=0);		
			
			
		} catch (Exception e) {
			softAssert.fail();
			context.setAttribute("Data", "Error: "+e.getStackTrace().toString());
			Log.setMessageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
		Log.setMessageInfo("Create Completed");
		  
	}

}
