package pagObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Checkout_Form_PageObjects {

	@FindBy(xpath="//div[@class='checkout-head']/span")
	public static WebElement CheckOut_Form_Title;

	@FindBy(xpath="//ul[@class='opc-progress-bar']/li/span[contains(text(),'Shipping')]")
	public static WebElement CheckOut_Shipping_tab;

	@FindBy(xpath="//div[@class='step-title'][contains(text(),'Delivery Address')]")
	public static WebElement CheckOut_Delivery_Addr_Title;

	// If user is  guest user shows for login and checkout form

	@FindBy(xpath="//input[@id='customer-email']")
	public static WebElement CheckOut_User_EmailId_Tologin;

	@FindBy(xpath="//input[@id='customer-password']")
	public static WebElement CheckOut_User_PWD;

	@FindBy(xpath="//button/span[contains(text(),'Login')]")
	public static WebElement CheckOut_Login_Button;

	// if user is already logged in and has saved address

	@FindBy(xpath="//div[@class='shipping-address-items']/div")
	public static WebElement CheckOut_User_has_saved_Address;

	@FindBy(xpath="//button[@data-role='opc-continue']")
	public static WebElement CheckOut_continue_button;

	//CheckOut form for 1st user
	@FindBy(id="customer-email")
	public static WebElement CheckOut_Emailid;

	@FindBy(xpath="//span[contains(text(),'First Name')]/parent::label/following-sibling::div/input")
	public static WebElement CheckOut_FirstName;

	@FindBy(xpath="//span[contains(text(),'Last Name')]/parent::label/following-sibling::div/input")
	public static WebElement CheckOut_LastName;

	@FindBy(xpath="//label/following-sibling::div/input[@name='street[0]']")
	public static WebElement CheckOut_Street_Address;

	@FindBy(xpath="//span[contains(text(),'Zip')]/parent::label/following-sibling::div/input")
	public static WebElement CheckOut_ZipCode;

	@FindBy(xpath="//span[contains(text(),'City')]/parent::label/following-sibling::div/input")
	public static WebElement CheckOut_City;

	@FindBy(xpath="//label/following-sibling::div/input[@name='telephone']")
	public static WebElement CheckOut_Telephone;

	@FindBy(xpath="//select[@name='region_id']")
	public static WebElement CheckOut_State;

	@FindBy(xpath="//select[@name='country_id']")
	public static WebElement CheckOut_Country;

	// Error messages
	@FindBys(@FindBy(xpath="//div/span[contains(text(),'This is a required field.')]"))
	public static List<WebElement> CheckOut_Required_field_Err_message;

	@FindBy(xpath="//div[@id='customer-email-error' and contains(text(),'This is a required field.')]")
	public static WebElement CheckOut_Email_field_Blank_Err_message;
	
	@FindBy(xpath="//div[@id='customer-email-error' and contains(text(),'Please enter a valid email addre')]")
	public static WebElement CheckOut_Email_field_Invalid_Err_message;
	
	@FindBy(xpath="//div[@id='customer-password-error' and contains(text(),'This is a required field.')]")
	public static WebElement CheckOut_Password_field_Blank_Err_message;
	
	@FindBys(@FindBy(xpath="//div[@class='message warning']/span"))
	public static List<WebElement> CheckOut_ZipCode_field_Invalid_Err_message;
	
	@FindBys(@FindBy(xpath="//div[@class='field-error']/span"))
	public static List<WebElement> CheckOut_Phone_field_Invalid_Err_message;
	
	@FindBy(xpath="//ul[@class='opc-progress-bar']/following-sibling::div/descendant::div[@data-ui-id='checkout-cart-validationmessages-message-error']")
	public static WebElement CheckOut_LongIn_Invalid_Credentials;
	
	
	
	
	
}
