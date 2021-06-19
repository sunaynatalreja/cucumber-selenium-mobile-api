/**
 * 
 */
package prjframework.sunaynatalreja.framework.testscripts.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import prj.sunaynatalreja.webdriverutil.driverutil.WebDriverFactory;
import prjframework.sunaynatalreja.framework.listeners.ExtentReportListener;
import prjframework.sunaynatalreja.framework.pages.MobileAutomationScript;


@Listeners(ExtentReportListener.class)

/**
 * @author Sunayna Talreja
 */
public class MobileTestAutomation {

	WebDriver driver;
	MobileAutomationScript mobileAutomationScript;
	WebDriverFactory webDriverFactory;

	@BeforeClass
	public void beforeClass()
	{
		webDriverFactory = new WebDriverFactory();
	}

	@Test(enabled = false)
	public void testMobile(ITestContext context) throws Exception
	{
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);

		driver=webDriverFactory.getDriver(context.getCurrentXmlTest().getParameter("browser"),"http://127.0.0.1:4723/wd/hub","Android Device",currentDirectory+ "\\GridSetup\\ApiDemos-debug.apk");
		mobileAutomationScript=new MobileAutomationScript(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		mobileAutomationScript.clickPreferences();
		mobileAutomationScript.clickPreferenceDependency();
		mobileAutomationScript.clickWifiCheckBox();
		mobileAutomationScript.clickWifiSettings();
		mobileAutomationScript.enterWifiDetails();
	}

	@Test(enabled = false)
	public void testMobileGestures(ITestContext context) throws Exception
	{
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);
		driver=webDriverFactory.getDriver(context.getCurrentXmlTest().getParameter("browser"),"http://127.0.0.1:4723/wd/hub","Android Device",currentDirectory+ "\\GridSetup\\ApiDemos-debug.apk");
		mobileAutomationScript=new MobileAutomationScript(driver);

		mobileAutomationScript.clickViews();
		mobileAutomationScript.clickExpandableList();
		mobileAutomationScript.clickcustomAdapter();
		mobileAutomationScript.longPressPeopleNames();
		//mobileAutomationScript.enterWifiDetails();
	}
	@Test(enabled = false)
	public void testMobileSwipe(ITestContext context) throws Exception
	{
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);

		driver=webDriverFactory.getDriver(context.getCurrentXmlTest().getParameter("browser"),"http://127.0.0.1:4723/wd/hub","Android Device",currentDirectory+ "\\GridSetup\\ApiDemos-debug.apk");
		mobileAutomationScript=new MobileAutomationScript(driver);

		mobileAutomationScript.clickViews();
		mobileAutomationScript.clickDateWidgets();
		mobileAutomationScript.clickInline();
		mobileAutomationScript.clickDateInline();
		mobileAutomationScript.clickNewTime();
	}

	@Test(enabled = true)
	public void testMobileScroll(ITestContext context) throws Exception
	{
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);

		driver=webDriverFactory.getDriver(context.getCurrentXmlTest().getParameter("browser"),"http://127.0.0.1:4723/wd/hub","Android Device",currentDirectory+ "\\GridSetup\\ApiDemos-debug.apk");
		mobileAutomationScript=new MobileAutomationScript(driver);
		mobileAutomationScript.clickViews();
		mobileAutomationScript.scrollToList();

	}

}
