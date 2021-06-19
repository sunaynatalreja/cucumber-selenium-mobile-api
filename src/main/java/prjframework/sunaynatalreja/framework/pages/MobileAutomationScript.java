/**
 * 
 */
package prjframework.sunaynatalreja.framework.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import prj.sunaynatalreja.webdriverutil.browserutil.BrowserElementActions;
import prj.sunaynatalreja.webdriverutil.mobileutil.MobileElementActions;

/**
 * @author Sunayna Talreja
*/
public class MobileAutomationScript {
	
	@SuppressWarnings("unused")
	private boolean isPageLoaded;
	WebDriver driver=null;
	
	@AndroidFindBy(uiAutomator   = "text(\"Preference\")")
	private AndroidElement preferences;
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='3. Preference dependencies']")
	private AndroidElement preferenceDependency;
	
	@AndroidFindBy(className  = "android.widget.CheckBox")
	private AndroidElement wifiCheckBox;
	
	
	@AndroidFindBy(className  = "android.widget.EditText")
	private AndroidElement wifiTextBox;
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='WiFi settings']")
	private AndroidElement wifiSettings;
	
	@AndroidFindBy(id="android:id/button1")
	private AndroidElement wifiOkButton;
	
	@AndroidFindBy(uiAutomator ="clickable(\"true\")")
	private List<AndroidElement> clickableCheck;
	
	@AndroidFindBy(uiAutomator ="text(\"Views\")")
	private AndroidElement views;
	
	@AndroidFindBy(uiAutomator ="text(\"Expandable Lists\")")
	private AndroidElement expandableList;
	
	@AndroidFindBy(uiAutomator ="text(\"1. Custom Adapter\")")
	private AndroidElement customAdaptor;
	
	@AndroidFindBy(uiAutomator ="text(\"People Names\")")
	private AndroidElement peopleNames;
	
	@AndroidFindBy(uiAutomator ="text(\"Date Widgets\")")
	private AndroidElement dateWidgets;
	
	@AndroidFindBy(uiAutomator ="text(\"2. Inline\")")
	private AndroidElement inline;
	
	@AndroidFindBy(xpath  = "//*[@content-desc='9']")
	private AndroidElement inlineDate;
	
	@AndroidFindBy(xpath  = "//*[@content-desc='15']")
	private AndroidElement startTime;
	@AndroidFindBy(xpath  = "//*[@content-desc='45']")
	private AndroidElement endTime;
	
	@AndroidFindBy(uiAutomator ="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lists\"));")
	private AndroidElement lists;
	
	public MobileAutomationScript(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	
	
	public void clickPreferences() throws Exception
	{
		
		  BrowserElementActions.getInstance().clickOnElement(driver, preferences,
		  "Preference clicked");		 
		
		
	}
	
	public void clickPreferenceDependency() throws Exception
	{
		
		  
		clickClickable(); 
		
		BrowserElementActions.getInstance().clickOnElement(driver, preferenceDependency,
		  "Preference clicked");		 
		
	}
	
	public void clickWifiCheckBox() throws Exception
	{
		
		BrowserElementActions.getInstance().clickOnElement(driver, wifiCheckBox,
		  "Wifi Checkbox clicked");		 
		//preferences.click();
		
	}
	public void enterWifiDetails() throws Exception
	{
		
		BrowserElementActions.getInstance().typeOnElement(driver,wifiTextBox,"Text", "Wifi text box details entered");		 
		BrowserElementActions.getInstance().clickOnElement(driver, wifiOkButton, "Clicked OK");
		
	}
	
	public void clickWifiSettings() throws Exception
	{
		
		  
		
		BrowserElementActions.getInstance().clickOnElement(driver, wifiSettings,"Wifi text box details entered");		 
	
		
	}

	
	public void clickClickable() throws Exception
	{
		
		 clickableCheck.size();	 
		
	}
	
	public void clickViews() throws Exception
	{
		MobileElementActions.getInstance().mobileTap(driver, views,"Clicked Views");	
	}
	public void clickExpandableList() throws Exception
	{
		MobileElementActions.getInstance().mobileTap(driver, expandableList,"Clicked Views");	
	}
	public void clickcustomAdapter() throws Exception
	{
		MobileElementActions.getInstance().mobileTap(driver, customAdaptor,"Clicked Views");	
	}
	public void longPressPeopleNames() throws Exception
	{
		MobileElementActions.getInstance().longPressMobileElement(driver, peopleNames,"Clicked Views");	
	}
	public void clickDateWidgets() throws Exception
	{
		MobileElementActions.getInstance().mobileTap(driver, dateWidgets,"Clicked Views");	
	}
	public void clickInline() throws Exception
	{
		MobileElementActions.getInstance().mobileTap(driver, inline,"Clicked Views");	
	}
	
	public void clickDateInline() throws Exception
	{
		MobileElementActions.getInstance().mobileTap(driver, inlineDate,"Clicked Views");	
	}
	
	public void clickNewTime() throws Exception
	{
		MobileElementActions.getInstance().mobileSlider(driver, endTime, startTime, "start end time");	
	}
	
	public void scrollToList() throws Exception
	{		
		MobileElementActions.getInstance().mobileTap(driver, lists, "start end time");	
	}
	
}
