/**
 * 
 */
package prjframework.sunaynatalreja.framework.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import prjframework.sunaynatalreja.framework.utils.ReadProperty;
import prj.sunaynatalreja.webdriverutil.browserutil.BrowserElementActions;

/**
 * @author Sunayna Talreja
 */
public class ProductPage extends LoadableComponent<ProductPage> {

	private boolean isPageLoaded;
	WebDriver driver=null;
	String url=null;

	@FindBy(xpath = "//*[@title='Women' and @class='sf-with-ul']")
	private WebElement womenCategories;

	@FindBy(xpath = "//div[@class='layered_filter']/ul")
	private List<WebElement> filters;
	
	@FindBy(xpath = "//div[@itemprop='offers']")
	private List<WebElement> products;

	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	private WebElement proceedToCheckout;

	@FindBy(xpath = "(//*[contains(text(),'Proceed to checkout')])[2]")
	private WebElement proceedToCheckoutPage;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement SubmitLogin;
	
	@FindBy(id = "uniform-cgv")
	private WebElement terms;
	
	@FindBy(xpath = "//*[@class='bankwire']")
	private WebElement bankwire;
	
	@FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
	private WebElement confirmOrder;
	
	@FindBy(xpath = "//*[@class='box']")
	private WebElement orderDetails;
	
	public ProductPage(String url, WebDriver driver)
	{
		this.driver=driver;
		this.url=url;
		PageFactory.initElements(driver, this);

	}

	protected void load() {
		isPageLoaded = true;
		driver.get(url);
		BrowserElementActions.waitForPageLoad(driver);
	}

	@Override
	protected void isLoaded() {
		if (!isPageLoaded) {
			Assert.fail();
		}
		if (isPageLoaded && !(BrowserElementActions.waitForElement(driver, womenCategories))) {
			System.out.println("Home Page did not open up. Site might be down.");
		}
		System.out.println("The current URL is: " + driver.getCurrentUrl());
	}




	public void clickWomenCategories() throws Exception
	{
		BrowserElementActions.clickOnElement(driver, womenCategories, "Women Category Navigation");
	}

	public void addFilters() throws Exception
	{
		BrowserElementActions.waitForElement(driver, filters.get(0));
		int filterClicked=0;
		while(filterClicked<3)
		{
			int rndNum=randomNumber();
			WebElement wb=filters.get(rndNum).findElement(By.tagName("li"));
			
			BrowserElementActions.clickOnElement(driver, wb, "Women Category Navigation");
			++filterClicked;
		}
		BrowserElementActions.clickOnElement(driver, womenCategories, "Women Category Navigation");
	}

	public static int randomNumber()
	{
		Random rnd=new Random();
		return rnd.nextInt(9);

	}

	public void clickRequiredProduct(String price) throws Exception
	{
		Boolean found=false;
		int count=0;
		while(!found && count<products.size())
		{
			WebElement wb=products.get(count).findElement(By.tagName("span"));
			String text=wb.getText();
			
			if(wb.getText().contains(price))
			{
				BrowserElementActions.mouseHoverAction(wb, driver, "Moved to required Product");
				//WebElement addToCartElement=products.get(count).
				WebElement addToCart=products.get(count).findElement(By.xpath(".//following-sibling::div/a"));
				BrowserElementActions.clickOnElement(driver, addToCart, "Add to Cart clicked");
				found=true;
				BrowserElementActions.clickOnElement(driver, proceedToCheckout, "Proceed To Checkout Button");
				BrowserElementActions.waitForElement(driver, proceedToCheckoutPage);
			}
			++count;
				

		}
		
	}
	
	public void proceedToCheckout() throws Exception
	{
		BrowserElementActions.clickOnElement(driver, proceedToCheckoutPage, "Proceed To Checkout Button");
	}
	
	public void signIn() throws Exception
	{
		BrowserElementActions.typeOnElement(driver, email, ReadProperty.getProperty("email"), "Email");
		BrowserElementActions.typeOnElement(driver, password, ReadProperty.getProperty("password"), "Password");
		BrowserElementActions.clickOnElement(driver, SubmitLogin, "Proceed To Checkout Button");
	}

	/**
	 * @throws Exception 
	 * 
	 */
	public void agreeTerms() throws Exception {
		BrowserElementActions.clickOnElement(driver, terms, "Proceed To Checkout Button");
				
	}
	
	public void clickBankwire() throws Exception {
		BrowserElementActions.clickOnElement(driver, bankwire, "Bankwire Payment option");
		BrowserElementActions.waitForPageLoad(driver);		
	}
	
	public void clickConfirmOrder() throws Exception {
		BrowserElementActions.clickOnElement(driver, confirmOrder, "Bankwire Payment option");
		BrowserElementActions.waitForPageLoad(driver);		
	}
	
	public String getOrderDetails() throws Exception {
		return orderDetails.getText(); 
	}

	
}

