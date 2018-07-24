package pagObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Browse_Categories_PageObjects {
	@FindBy(xpath="//li[@class='level0 nav-1 first level-top parent']/a/span[contains(text(),'Phone Cases')]")
	public static WebElement Desire_Category_1;

	@FindBy(xpath="//ul[@class='level0 submenu']/descendant::span[contains(text(),'Samsung')]")
	public static WebElement Desire_Category_2;

	@FindBy(xpath="//li[@class='level2 nav-1-2-1 first']")
	public static WebElement Desire_Category_3;

	@FindBy(xpath="//ol[@class='products list items product-items']/li[1]/descendant::span[@class='product_model']")
	public static WebElement Desire_Search_Result_Product_Model_Name_1;

	@FindBys(@FindBy(xpath="//ol[@class='products list items product-items']/li/descendant::span[@class='product_model']"))
	public static List<WebElement> Desire_Search_Result_Product_Model_Name;


}
