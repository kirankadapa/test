package pagObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_PageObjects {
	
	@FindBy(xpath="//a[@id='search-icon']/img")
	public static WebElement Search_Icon;
	
	@FindBy(xpath="//input[@id='search']")
	public static WebElement Search_Input_Field;
	
	@FindBy(xpath="//div[contains(text(),'Your search returned no results.')]")
	public static WebElement Search_Result_NotFound;
	
	@FindBy(xpath="//ol[@class='products list items product-items']/li[2]")
	public static WebElement Select_Product_From_SearchDisplay;
	
	@FindBy(xpath="//ol[@class='products list items product-items']/li[2]/div/div[@class='product details product-item-details']/strong")
	public static WebElement Search_Result_Product_Name;
	
	@FindBy(xpath="//ol[@class='products list items product-items']/li[1]")
	public static WebElement Select_1st_Product_From_SearchDisplay;
	
	@FindBy(xpath="//ol[@class='products list items product-items']/li[1]/div/div[@class='product details product-item-details']/strong")
	public static WebElement Search_Result_1st_Product_Name;
	
	
	
	
	}
