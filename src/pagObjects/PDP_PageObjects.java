package pagObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class PDP_PageObjects {
	
	@FindBy(xpath="//div[@class='page-title-wrapper product']/h1/span[@class='base']")
	public static WebElement PDP_Product_Title;
	
	@FindBy(xpath="//button[@id='product-addtocart-button']")
	public static WebElement PDP_Add_To_Cart;
	
	@FindBy(xpath="//span[@class='swatch-attribute-label']")
	public static WebElement PDP_Color_Select_Label;
	
	@FindBys(@FindBy(xpath="//span[@class='swatch-attribute-label']"))
	public static List<WebElement> PDP_Color_Select_Label_Available;
	
	@FindBy(xpath="//div[2][@class='swatch-option image']")
	public static WebElement PDP_Color_Select;
	
	@FindBy(xpath="//span[@class='swatch-attribute-label'][contains(text(),'Brand')]")
	public static WebElement PDP_Brand_Label;
	
	@FindBys(@FindBy(xpath="//span[@class='swatch-attribute-label'][contains(text(),'Brand')]"))
	public static List<WebElement> PDP_Brand_Label_Available;
	
	@FindBy(xpath="//select[@class='swatch-select accessories_brand']")
	public static WebElement PDP_Brand_Select_Option;
	
	@FindBy(xpath="//select[@class='swatch-select accessories_brand']/option[2]")
	public static WebElement PDP_Brand_Select_Option_1;
	
	
	
	@FindBy(xpath="//span[@class='swatch-attribute-label'][contains(text(),'Model')]")
	public static WebElement PDP_Model_Label;
	
	@FindBys(@FindBy(xpath="//span[@class='swatch-attribute-label'][contains(text(),'Model')]"))
	public static List<WebElement> PDP_Model_Label_Available;
	
	@FindBy(xpath="//select[@class='swatch-select accessories_model']")
	public static WebElement PDP_Model_Select_Option;
	
	@FindBy(xpath="//select[@class='swatch-select accessories_model']/option[2]")
	public static WebElement PDP_Model_Select_Option_1;
	
	@FindBy(xpath="//button[@id='product-addtocart-button']/span[contains(text(),'View Cart')]")
	public static WebElement PDP_AddToCart_ChangeTO_ViewCart;
	
	
	@FindBy(xpath="//div[@class='price-box price-final_price']/descendant::span[@data-price-type='finalPrice']")
	public static WebElement PDP_Product_Price;
	
	
	
	
	
	

}
