package pagObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Payment_Screen_Page_Object {


	// Payment screen
	
	@FindBy(xpath="//div[@class='step-title'][contains(text(),'Payment Method:')]")
	public static WebElement CheckOut_Payment_Title;
	
	@FindBy(xpath="//input[@id='razorpay']")
	public static WebElement Payment_Debit_Card_Radio_Btn;
	
	@FindBy(xpath="//div[@class='payment-method _active']//div[@class='payment-method-content']//div[@class='actions-toolbar']//div[@class='primary']//button[@class='action primary checkout']")
	public static WebElement Payment_Debit_Card_Place_Order_Button;
	
	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']")
	public static WebElement Payment_Debit_Card_Pop_Up_Frame;
	
	@FindBy(xpath="//div[@tab='card']/label")
	public static WebElement Payment_Debit_Card_Pop_Up_CLick_Card;
	
	@FindBys(@FindBy(xpath="//a[contains(text(),'Skip')]"))
	public static List<WebElement> Payment_Debit_Card_Pop_Up_Skip_Saved_cards;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	public static WebElement Payment_Debit_Card_Pop_Up_Skip_Single_Saved_cards;
	
	@FindBy(xpath="//input[@id='card_number']")
	public static WebElement Payment_Debit_Card_Pop_Up_Card_Number;
	
	@FindBy(xpath="//input[@id='card_expiry']")
	public static WebElement Payment_Debit_Card_Pop_Up_Card_Expiry;
	
	@FindBy(xpath="//input[@id='card_cvv']")
	public static WebElement Payment_Debit_Card_Pop_Up_Card_CVV;
	
	@FindBy(xpath="//span[@class='otp-btn']")
	public static WebElement Payment_Debit_Card_Pop_Up_Card_Pay_Btn;
	
	@FindBy(xpath="//button[@class='success']")
	public static WebElement Payment_RazorPay_Success_Button;
	
	@FindBy(xpath="//h1[@class='success-page-heading' and contains(text(),'Thank you for shopping!')]")
	public static WebElement Order_Successful_Confirmation_Screen;
	
	@FindBy(xpath="//span[@class='checkbox']/parent::label/input[@id='save']")
	public static WebElement Payment_Debit_Card_Pop_Up_Remember_Checkbox;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
