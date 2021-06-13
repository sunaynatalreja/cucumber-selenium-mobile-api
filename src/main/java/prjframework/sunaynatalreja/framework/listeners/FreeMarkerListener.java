/**
 * 
 */
package prjframework.sunaynatalreja.framework.listeners;

import java.util.ArrayList;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.datahelpers.ReportData;
import prj.sunaynatalreja.freemarkerreport.FreeMarkerReportUtil;




/**
 * @author Sunayna Talreja
 * Freemarker listner to create test run report
 */
public class FreeMarkerListener implements ITestListener {

	private String testInstanceName;
	List<ReportData> reportData=new ArrayList<>();
	List<String> passed=new ArrayList<>();
	List<String> skipped=new ArrayList<>();



	@Override
	public void onTestStart(ITestResult result) {
		testInstanceName=result.getName();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ReportData data=new ReportData();
		data.setTestName(testInstanceName);
		data.setStatus("Pass");
		data.setTestData(Cache.getInstance().getVal(testInstanceName).toString());
		reportData.add(data);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ReportData data=new ReportData();
		data.setTestName(testInstanceName);
		data.setStatus("Fail");
		data.setTestData(Cache.getInstance().getVal(testInstanceName).toString());
		reportData.add(data);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ReportData data=new ReportData();
		data.setTestName(testInstanceName);
		data.setStatus("Skipped");
		reportData.add(data);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			FreeMarkerReportUtil.HTMLReport(reportData, "report.ftl","test-output/freemarkerreport.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
