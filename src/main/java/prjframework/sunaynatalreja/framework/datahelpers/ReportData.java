/**
 * 
 */
package prjframework.sunaynatalreja.framework.datahelpers;

/**
 * @author Sunayna Talreja
 * Class to record test case run data
*/
public class ReportData {
	private String testName;
	private String status;
	private String testData;
	
	public String getTestData() {
		return testData;
	}
	public void setTestData(String testData) {
		this.testData = testData;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
