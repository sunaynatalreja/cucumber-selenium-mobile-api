/**
 * 
 */
package prjframework.sunaynatalreja.framework.listeners;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import prj.sunaynatalreja.extentreportutil.ExtentReportUtil;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.utils.ReadProperty;


/**
 * @author Sunayna Talreja
*/

public class ExtentReportListener implements ITestListener {

String testInstanceName;

public void onTestStart(ITestResult iTestResult) {
    testInstanceName=iTestResult.getName();
    ExtentReportUtil.reportExtentTestStart(testInstanceName);

}

public void onTestSuccess(ITestResult iTestResult) {
        iTestResult.setAttribute("TestData",iTestResult.getTestContext().getAttribute("TestData"));
        String testData=Cache.getInstance().getVal(testInstanceName);
        ExtentReportUtil.setReportExtentTestDetails("PASS",testData,testInstanceName);


      }

public void onTestFailure(ITestResult iTestResult) {
    iTestResult.setAttribute("TestData",iTestResult.getTestContext().getAttribute("TestData"));
    String testData=Cache.getInstance().getVal(testInstanceName);
    ExtentReportUtil.setReportExtentTestDetails("FAIL",testData,testInstanceName);
}

public void onTestSkipped(ITestResult iTestResult) {
    iTestResult.setAttribute("TestData",iTestResult.getTestContext().getAttribute("TestData"));
    String testData=Cache.getInstance().getVal(testInstanceName);
    ExtentReportUtil.setReportExtentTestDetails("SKIP",testData,testInstanceName);
}

public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

}

public void onStart(ITestContext iTestContext) {
    
	String path=System.getProperty("user.dir") +"/test-output/ExtentReport.html";
	ExtentReportUtil.createReport(path,"Automation Report", "Framework Automation");

}

public void onFinish(ITestContext iTestContext)
{
    ExtentReportUtil.reportExtentEnd();
}
}