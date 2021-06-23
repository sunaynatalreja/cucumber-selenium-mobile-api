
package prjframework.sunaynatalreja.framework.testscript.webui;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import prjframework.sunaynatalreja.framework.cache.Cache;
import prjframework.sunaynatalreja.framework.config.BaseClass;
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
	
	
	
	
	@SuppressWarnings("static-access")
	@Parameters({"url","browser"})
	@BeforeTest
	public void init(String url,String browserName) throws IOException
	{
		website=url;
		browser=browserName;
		WebDriverFactory factory=new WebDriverFactory();
		driver=factory.getDriver(browser, "http://localhost:4444/wd/hub", "", "");
		productPage=new ProductPage(website, driver).get();
		Cache.getInstance().putVal("propertyfile", "config.properties");
		Log.setMessageInfo("Navigated to Home Page!");
		
	}
	
	@SuppressWarnings("static-access")
	@Parameters("productVal")
	@Test
	public void myStore(String price)
	{
		SoftAssert softAssert =new SoftAssert();
		Cache cache=Cache.getInstance();
		try {
			
			productPage.clickWomenCategories();
			Log.setMessageInfo("Navigated to Women category");
			
			//productPage.addFilters();
			cache.getInstance().putVal("myStore", "Price: "+price);
			productPage.clickRequiredProduct(price);
			Log.setMessageInfo("Product with price: "+price+" added to cart");
			
			productPage.proceedToCheckout();
			Log.setMessageInfo("Proceeded to checkout page");
			
			productPage.signIn();
			Log.setMessageInfo("Signed In successfully");
			
			productPage.proceedToCheckout();
			Log.setMessageInfo("Proceeded to checkout page");
			
			productPage.agreeTerms();
			Log.setMessageInfo("Terms agreed");
			
			productPage.proceedToCheckout();
			Log.setMessageInfo("Proceeded to checkout page");
			
			productPage.clickBankwire();
			Log.setMessageInfo("Bankwire payment option selected");
			
			productPage.clickConfirmOrder();
			Log.setMessageInfo("Confirm order clicked");
			
			String orderdetails=productPage.getOrderDetails();
			softAssert.assertTrue(orderdetails.contains("Your order on My Store is complete"));
			
		}
		catch(Exception e)
		{
			softAssert.fail();
			cache.getInstance().putVal("myStore", "Error: "+e.getStackTrace().toString());
			Log.setMessageError(e.getStackTrace().toString());
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
