package pagObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Drop_Down_In_Page_Object {
	
	@FindBy(xpath="//div[@class='panel header']//ul[@class='header links']//li//a[@href='#social-login-popup'][contains(text(),'Sign Up')]")
	public static WebElement Select_Sign_Up_Button;
	
	@FindBy(xpath="//div[@class='panel header']//ul[@class='header links']//li//a[@href='#social-login-popup'][contains(text(),'Log In')]")
	public static WebElement Select_Login_Button;
	
	 @FindBy(xpath="//a[@href='javascript:void(0)']/following-sibling::script/following-sibling::ul[@class='header links']/li[@class='authorization-link']/a")
		public static WebElement Sign_Out_link;
	    
 @FindBy(xpath="//a[@href='javascript:void(0)']/following-sibling::script/following-sibling::ul[@class='header links']//li/div[@class='customer-menu']/ul/li/a[contains(text(),'My Account')]")
	    public static WebElement User_My_Account_link;
 
 @FindBy(xpath="//a[@href='javascript:void(0)']/following-sibling::script/following-sibling::ul[@class='header links']/li[@class='customer-welcome']/span/span[@id='cust-name']")
	public static WebElement  User_Name_After_Login_SignUp;
		

}
