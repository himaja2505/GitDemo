package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(css=".cartSection h3")
	   List< WebElement> cartproducts;
	@FindBy(css=".totalRow button")
	   WebElement checkOut;
	
	
	public  Boolean verifyProductDisplay(String productName)
	{
		
	

	Boolean match=cartproducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	
	return match;
	
	}
	
	public CheckOutPage goToCheckOut()
	{
		checkOut.click();	
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
}
