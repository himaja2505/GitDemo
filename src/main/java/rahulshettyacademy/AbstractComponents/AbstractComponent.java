package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(css="[routerlink*='cart']")
	   WebElement cartHeader;
	@FindBy(css="[routerlink*='myorders']")
	   WebElement orderHeader;
	//.btn.btn-custom[routerlink='/dashboard/myorders']
	
	public void  waitForElementToAppear(By findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated( findBy));
	}
	public void  waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf( findBy));
	}
	
	public void  waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		//w.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(1000);
	}
	

	
	public CartPage goToCartPage()
	{
		cartHeader.click();	
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	public OrderPage goToOrderPage()
	{
		orderHeader.click();	
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
}
