package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(css="tr :nth-child(3)")
	   List< WebElement> products;
	
	
	
	public  Boolean verifyOrderDisplay(String productName)

		
	{

	Boolean match=products.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	
	return match;
	
	}
	
	
}
