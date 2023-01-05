package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.CheckOutPage;
import rahulshettyacademy.pageObjects.ConfirmationPage;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.ProductCatalogue;

public class StepDefinationImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CheckOutPage checkOutPage;
	public ConfirmationPage confirmationPage;
	
	
    @Given("I landed on Ecommerce page")
    public void I_landed_on_Ecommerce_page() throws IOException {
	
    	landingPage=launchApplication();
    	
    }
    
	@Given("^logged in  with userName (.+) and password (.+)$")
	public void logged_in_username_and_password(String userName,String password)
	{
		productCatalogue=landingPage.loginApplication(userName, password);
	}
	
	@When("^I add products (.+) to cart$")
	public void I_add_produts_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
	}
	
	
	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		 checkOutPage = cartPage.goToCheckOut();
	}
	
	@Then(" {string} message is displayed on confirmation page")
	public void message_display_confirmation_page(String string)
	{
		String confirmationMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
		
	}
	
	@Then("^\"([^\"]*)\"message is displayed on page.$")
	public void  message_dispaly_on_page(String string)
	{
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
	
}
