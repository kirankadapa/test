package pagObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MiniCart_PageObject {
	
	@FindBy(xpath="//span[@id='counter-number']")
	public static WebElement Mini_Cart_Icon ;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	public static WebElement MiniCart_CheckOut_Button;
	
	@FindBy(xpath="//div[@class='amount price-container']//span[@class='price-wrapper']//span[@class='price']")
	public static WebElement MiniCart_Total_Amount;
	
	@FindBys(@FindBy(xpath="//span[@class='minicart-price']"))
	public static List<WebElement> MiniCart_All_Item_Price;

	


}
