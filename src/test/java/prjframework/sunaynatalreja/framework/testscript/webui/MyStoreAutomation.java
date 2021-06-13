/**
 * 
 */
package prjframework.sunaynatalreja.framework.testscript.webui;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.config.BaseClass;
import prjframework.sunaynatalreja.framework.listeners.ExtentReportListener;
import prjframework.sunaynatalreja.framework.listeners.FreeMarkerListener;
import prjframework.sunaynatalreja.framework.pages.ProductPage;
import prj.sunaynatalreja.logutil.Log;
import prj.sunaynatalreja.webdriverutil.driverutil.WebDriverFactory;




/**
 * @author Sunayna Talreja
 * This class has test scenario for automation test practice websites
*/
@Listeners(FreeMarkerListener.class)
public class MyStoreAutomation extends BaseClass{
	
	ProductPage productPage;
	String website,browser;
	WebDriver driver;
	
	
	
	
	@Parameters({"url","browser"})
	@BeforeTest
	public void init(String url,String browserName) throws IOException
	{
		website=url;
		browser=browserName;
		driver=WebDriverFactory.get(browser, "http://localhost:4444/wd/hub", "", "");
		productPage=new ProductPage(website, driver).get();
		Cache.getInstance().putVal("propertyfile", "config.properties");
		Log.messageInfo("Navigated to Home Page!");
		
	}
	
	@Parameters("productVal")
	@Test
	public void myStore(String price)
	{
		SoftAssert softAssert =new SoftAssert();
		Cache cache=Cache.getInstance();
		try {
			
			productPage.clickWomenCategories();
			Log.messageInfo("Navigated to Women category");
			
			//productPage.addFilters();
			cache.getInstance().putVal("myStore", "Price: "+price);
			productPage.clickRequiredProduct(price);
			Log.messageInfo("Product with price: "+price+" added to cart");
			
			productPage.proceedToCheckout();
			Log.messageInfo("Proceeded to checkout page");
			
			productPage.signIn();
			Log.messageInfo("Signed In successfully");
			
			productPage.proceedToCheckout();
			Log.messageInfo("Proceeded to checkout page");
			
			productPage.agreeTerms();
			Log.messageInfo("Terms agreed");
			
			productPage.proceedToCheckout();
			Log.messageInfo("Proceeded to checkout page");
			
			productPage.clickBankwire();
			Log.messageInfo("Bankwire payment option selected");
			
			productPage.clickConfirmOrder();
			Log.messageInfo("Confirm order clicked");
			
			String orderdetails=productPage.getOrderDetails();
			softAssert.assertTrue(orderdetails.contains("Your order on My Store is complete"));
			
		}
		catch(Exception e)
		{
			softAssert.assertTrue(false);
			cache.getInstance().putVal("myStore", "Error: "+e.getStackTrace().toString());
			Log.messageError(e.getStackTrace().toString());
			e.printStackTrace();
		}
		softAssert.assertAll();
			
	}
	
	@AfterTest
	public void exit()
	{
		driver.quit();
	}
	
	

}
