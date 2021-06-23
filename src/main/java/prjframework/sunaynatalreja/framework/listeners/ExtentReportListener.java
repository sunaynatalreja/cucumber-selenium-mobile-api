package prjframework.sunaynatalreja.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import prj.sunaynatalreja.extentreportutil.ExtentReportUtil;
import prjframework.sunaynatalreja.framework.cache.Cache;


/**
 * @author Sunayna Talreja
 * Extent report listner to create test run report
*/

public class ExtentReportListener implements ITestListener {

String testInstanceName;

@Override
public void onTestStart(ITestResult iTestResult) {
    testInstanceName=iTestResult.getName();
    ExtentReportUtil.getInstance().createReportExtentTest(testInstanceName);

}

@SuppressWarnings("static-access")
@Override
public void onTestSuccess(ITestResult iTestResult) {
        iTestResult.setAttribute("TestData",iTestResult.getTestContext().getAttribute("TestData"));
        String testData=Cache.getInstance().getVal(testInstanceName);
        ExtentReportUtil.getInstance().setReportExtentTestDetails("PASS",testData,testInstanceName);


      }

@SuppressWarnings("static-access")
@Override
public void onTestFailure(ITestResult iTestResult) {
    iTestResult.setAttribute("TestData",iTestResult.getTestContext().getAttribute("TestData"));
    String testData=Cache.getInstance().getVal(testInstanceName);
    ExtentReportUtil.getInstance().setReportExtentTestDetails("FAIL",testData,testInstanceName);
}

@SuppressWarnings("static-access")
@Override
public void onTestSkipped(ITestResult iTestResult) {
    iTestResult.setAttribute("TestData",iTestResult.getTestContext().getAttribute("TestData"));
    String testData=Cache.getInstance().getVal(testInstanceName);
    ExtentReportUtil.getInstance().setReportExtentTestDetails("SKIP",testData,testInstanceName);
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

}

@Override
public void onStart(ITestContext iTestContext) {
    
	String path=System.getProperty("user.dir") +"/test-output/ExtentReport.html";
	ExtentReportUtil.getInstance().createReport(path,"Automation Report", "Framework Automation");

}

@Override
public void onFinish(ITestContext iTestContext)
{
    ExtentReportUtil.getInstance().endReportExtent();
}
}