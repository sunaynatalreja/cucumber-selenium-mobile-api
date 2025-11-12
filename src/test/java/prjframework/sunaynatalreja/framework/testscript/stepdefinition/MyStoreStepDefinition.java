
package prjframework.sunaynatalreja.framework.testscript.stepdefinition;

import java.io.IOException;
import prjframework.sunaynatalreja.framework.testscript.webui.MyStoreAutomation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Sunayna Talreja
 * MyStoreAutomation step definition
 */


public class MyStoreStepDefinition {

	MyStoreAutomation myStore=new MyStoreAutomation();

	@Given("^user is already on Home Page of \"(.*)\" on \"(.*)\"$")
	public void user_already_on_home_page(String url, String browser) throws IOException{
		myStore.init(url,browser);
	}


	@When("^user buys product of a given \"(.*)\"$")
	public void user_buys_product_of_a_given(String price)
	{

		myStore.myStore(price);
	}

	@Then("^Close the browser$")
	public void close_the_browser()
	{
		myStore.exit();

	}


}
