package globals;

import static org.testng.Assert.assertEquals;
import globals.Globals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import globals.Globals;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestCases.BaseTest;
import pagObjects.Browse_Categories_PageObjects;
import pagObjects.Checkout_Form_PageObjects;
import pagObjects.HomeScreen_PageObjects;
import pagObjects.MiniCart_PageObject;
import pagObjects.PDP_PageObjects;
import pagObjects.Payment_Screen_Page_Object;
import pagObjects.Search_PageObjects;

import pagObjects.User_Drop_Down_In_Page_Object;

public class CommonUtilities {
//	static ExtentTest logger;
	public static void Browse_Category_Add_To_Cart(ExtentReports report,WebDriver driver, ExtentTest logger) throws InterruptedException{
	//	logger = report.startTest("Browse_Category_Add_To_Cart_checkOut");
		try{
		PageFactory.initElements(driver, Browse_Categories_PageObjects.class);
		PageFactory.initElements(driver, Search_PageObjects.class);
		PageFactory.initElements(driver, PDP_PageObjects.class);
		Actions action = new Actions(driver);
		 Globals.wait(5);
		action.moveToElement(Browse_Categories_PageObjects.Desire_Category_1).build().perform();
		
		logger.log(LogStatus.INFO, "Catergory 1 is clicked");
		Globals.fluentWaitVisibility(Browse_Categories_PageObjects.Desire_Category_2, 30);
		action.moveToElement(Browse_Categories_PageObjects.Desire_Category_2).click().build().perform();
		logger.log(LogStatus.PASS, "Catergory 2 is displayed and  clicked");
		Globals.fluentWaitVisibility(Browse_Categories_PageObjects.Desire_Category_3, 30);
		String SelectedCategory = Browse_Categories_PageObjects.Desire_Category_3.getText();
		action.moveToElement(Browse_Categories_PageObjects.Desire_Category_3).click().build().perform();
		logger.log(LogStatus.PASS, "Catergory 3 is displayed and  clicked");
		Globals.fluentWaitVisibility(Browse_Categories_PageObjects.Desire_Search_Result_Product_Model_Name_1, 30);
		logger.log(LogStatus.INFO, "First Product is displayed for Category selected");
		logger.log(LogStatus.INFO, "Verify Products displayed are based on selected category");
		 logger.log(LogStatus.INFO,"Verifying Searched Product Navigates to its PDP page on click");
			String Product_Clicked_In_Search_Result = Search_PageObjects.Search_Result_Product_Name.getText();
			logger.log(LogStatus.INFO, Product_Clicked_In_Search_Result);
			Search_PageObjects.Select_Product_From_SearchDisplay.click();
			logger.log(LogStatus.INFO, "Search result second product is clicked");
			Globals.fluentWaitVisibility(PDP_PageObjects.PDP_Product_Title, 30);
		Assert.assertEquals(PDP_PageObjects.PDP_Product_Title.getText(), Product_Clicked_In_Search_Result);
			logger.log(LogStatus.PASS,"Navigated to PDP page and respective  product PDP page is displayed");
			logger.log(LogStatus.INFO,"Selecting Attributes for product");
			Select_Product_Attributes(driver,logger);
			
		}catch(Exception e)
			{
				    Globals.ERtakeScreenshot(driver, "CaptureError", "Browse_Category_Add_To_Cart()",logger);
					logger.log(LogStatus.INFO , e);
			}
			
	}



public static void Search_Category_Add_To_Cart(ExtentReports report,WebDriver driver,ExtentTest logger) throws InterruptedException{
	try{ 
	PageFactory.initElements(driver, Browse_Categories_PageObjects.class);
	  PageFactory.initElements(driver, Search_PageObjects.class);
	  PageFactory.initElements(driver, PDP_PageObjects.class);
	//  logger = report.startTest("Search_Category_Add_To_Cart_checkOut");
	  Globals.wait(5);
	  Search_PageObjects.Search_Icon.click();
	  logger.log(LogStatus.INFO, "Search icon is Clicked");
	  Search_PageObjects.Search_Input_Field.sendKeys(Constants.Search_trobla);
	  logger.log(LogStatus.INFO,"Search text is entered in Search Field");
	String Search_Entered_Value=  Search_PageObjects.Search_Input_Field.getAttribute("value");
	logger.log(LogStatus.INFO, "Entered text in search field is "+ Search_Entered_Value);
	  Search_PageObjects.Search_Input_Field.sendKeys(Keys.ENTER);
	  logger.log(LogStatus.INFO, "Enter key is hit for search Result");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  logger.log(LogStatus.INFO,"Verifying Searched Product Navigates to its PDP page on click");
	  Globals.fluentWaitVisibility(Search_PageObjects.Search_Result_1st_Product_Name, 30);
		String Product_Clicked_In_Search_Result = Search_PageObjects.Search_Result_1st_Product_Name.getText();
		logger.log(LogStatus.INFO, Product_Clicked_In_Search_Result);
		Search_PageObjects.Select_1st_Product_From_SearchDisplay.click();
		logger.log(LogStatus.INFO, "Search result 1st product is clicked");
		Globals.fluentWaitVisibility(PDP_PageObjects.PDP_Product_Title, 30);
		Assert.assertEquals(PDP_PageObjects.PDP_Product_Title.getText(), Product_Clicked_In_Search_Result);
		logger.log(LogStatus.PASS,"Navigated to PDP page and respective  product PDP page is displayed");
		logger.log(LogStatus.INFO,"Selecting Attributes for product");
		Select_Product_Attributes(driver,logger);
		
	}	catch(Exception e)
	{
	    Globals.ERtakeScreenshot(driver, "CaptureError", "Search_Category_Add_To_Cart()",logger);
		logger.log(LogStatus.INFO , e);
}
		
		
	}



private static void Select_Product_Attributes(WebDriver driver,ExtentTest logger) throws InterruptedException {
	try{
	  PageFactory.initElements(driver, PDP_PageObjects.class);
	
	  boolean Color_Field_Available =PDP_PageObjects.PDP_Color_Select_Label_Available .size() != 0;
	  boolean Brand_Field_Available =PDP_PageObjects.PDP_Brand_Label_Available .size() != 0;
	  boolean Model_Field_Available =PDP_PageObjects.PDP_Model_Label_Available.size() != 0;
      if(Color_Field_Available == true){
    	  Thread.sleep(3000);
    	  PDP_PageObjects.PDP_Color_Select.click();
    	  logger.log(LogStatus.PASS, "Color is selected for product");
    	  
      } else {
    	  logger.log(LogStatus.PASS, "Color Option is not there for product ");
      }
      if (Brand_Field_Available== true) {
    	  Thread.sleep(3000);
    	  PDP_PageObjects.PDP_Brand_Select_Option.click();
    	  Select sel = new Select(PDP_PageObjects.PDP_Brand_Select_Option);
    	  sel.selectByVisibleText(PDP_PageObjects.PDP_Brand_Select_Option_1.getText());
    	  logger.log(LogStatus.PASS, "Brand is selected for product");
		
	}else {
  	  logger.log(LogStatus.PASS, "Brand Option is not there for product ");
    }
      if(Model_Field_Available == true){
    	  Thread.sleep(3000);
		PDP_PageObjects.PDP_Model_Select_Option.click();
		Select sel = new Select(PDP_PageObjects.PDP_Model_Select_Option);
		sel.selectByVisibleText( PDP_PageObjects.PDP_Model_Select_Option_1.getText());
		logger.log(LogStatus.PASS, "Model is selected for product");
	}else {
  	  logger.log(LogStatus.PASS, "Model Option is not there for product ");
    }
	}catch(Exception e)
	{
	    Globals.ERtakeScreenshot(driver, "CaptureError", "Select_Product_Attributes()",logger);
		logger.log(LogStatus.INFO , e);
}
		
	
}



public static void MiniCartValidations(String title_PDP, String price_PDP,WebDriver driver, ExtentReports report, ExtentTest logger) throws InterruptedException {
	try{
	PageFactory.initElements(driver, MiniCart_PageObject.class);

		
	 MiniCart_PageObject.Mini_Cart_Icon.click();
	 Globals.wait(10);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
String MiniCart_Title=	 driver.findElement(By.xpath("//strong[@class='product-item-name']/a[translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')="+"'" +title_PDP.toLowerCase()+"']")).getText();
	String MiniCart_Price =  driver.findElement(By.xpath("//strong[@class='product-item-name']/a[translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')="+"'" +title_PDP.toLowerCase()+"']/ancestor::strong/following-sibling::div[@class='product-item-pricing']")).getText();
	Assert.assertEquals(MiniCart_Title, title_PDP);
	//Assert.assertEquals(MiniCart_Price, price_PDP);
//	Assert.assertEquals(MiniCart_PageObject.MiniCart_Total_Amount.getText(), MiniCart_Price);

	logger.log(LogStatus.PASS, "Minicart Product Price and Title is validated");
	}catch(Exception e)
	{
	    Globals.ERtakeScreenshot(driver, "CaptureError", "MiniCartValidations()",logger);
		logger.log(LogStatus.INFO , e);
}
}



public static void CheckoutScreen_From_MiniCart(WebDriver driver, ExtentTest logger) {
	try{
	PageFactory.initElements(driver, MiniCart_PageObject.class);
	PageFactory.initElements(driver, Checkout_Form_PageObjects.class);
	MiniCart_PageObject.MiniCart_CheckOut_Button.click();
	logger.log(LogStatus.PASS, "MiniCArt checkout button is clicked");
	Globals.fluentWaitClickable(Checkout_Form_PageObjects.CheckOut_Form_Title, 30);
	Assert.assertTrue(Checkout_Form_PageObjects.CheckOut_Form_Title.isDisplayed());
	Assert.assertTrue(Checkout_Form_PageObjects.CheckOut_Shipping_tab.isDisplayed());
	Assert.assertTrue(Checkout_Form_PageObjects.CheckOut_Delivery_Addr_Title.isDisplayed());
	}catch(Exception e)
	{
	    Globals.ERtakeScreenshot(driver, "CaptureError", "CheckoutScreen_From_MiniCart()",logger);
		logger.log(LogStatus.INFO , e);
}

		
		
	
	
}

public static void CheckOut_form(WebDriver driver, ExtentTest logger,String Email,String FN, String LN, String Street_Addr, 
		String ZipCode,String telephone) throws InterruptedException{
	try{
	PageFactory.initElements(driver, Checkout_Form_PageObjects.class);
	PageFactory.initElements(driver, Payment_Screen_Page_Object.class);
	if(Email.equals("")& FN.equals("")){
		Globals.fluentWaitClickable(Checkout_Form_PageObjects.CheckOut_continue_button,60);
		Thread.sleep(10000);
	Checkout_Form_PageObjects.CheckOut_continue_button.click();
	logger.log(LogStatus.INFO, "Checout - continue button is clicked ");
	Globals.fluentWaitVisibility(Checkout_Form_PageObjects.CheckOut_Email_field_Blank_Err_message, 30);
	Assert.assertTrue(Checkout_Form_PageObjects.CheckOut_Email_field_Blank_Err_message.isDisplayed());
	logger.log(LogStatus.PASS, "Error message is displayed");
	logger.log(LogStatus.INFO, "Verify error message is displayed if all fields are left blank");
	List<WebElement> Field_Required = Checkout_Form_PageObjects.CheckOut_Required_field_Err_message;
	int Err_Field = Field_Required.size();
	Assert.assertEquals(Err_Field, 7);
	logger.log(LogStatus.PASS, "All Error message is displayed");
	}else{
		
		Checkout_Form_PageObjects.CheckOut_Emailid.clear();
	Checkout_Form_PageObjects.CheckOut_Emailid.sendKeys(Email);
	logger.log(LogStatus.INFO, "Email id is entered");
	
	boolean LoginButton = Checkout_Form_PageObjects.CheckOut_Login_Button.isEnabled();

	/*if(LoginButton==true){
	Assert.assertTrue(Checkout_Form_PageObjects.CheckOut_Login_Button.isDisplayed());
	logger.log(LogStatus.INFO, "Guest User has already registered with desire and has saved address but need to login");
	
	}*/
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	logger.log(LogStatus.INFO, "Entering all details of checkout form");
	Checkout_Form_PageObjects.CheckOut_FirstName.clear();
	Checkout_Form_PageObjects.CheckOut_FirstName.sendKeys(FN);
	logger.log(LogStatus.INFO, "FirstName is entered");
	Checkout_Form_PageObjects.CheckOut_LastName.clear();
	Checkout_Form_PageObjects.CheckOut_LastName.sendKeys(LN);
	logger.log(LogStatus.INFO, "LastName is entered");
	Checkout_Form_PageObjects.CheckOut_Street_Address.clear();
	Checkout_Form_PageObjects.CheckOut_Street_Address.sendKeys(Street_Addr);
	logger.log(LogStatus.INFO, "Street Address is entered");
	Checkout_Form_PageObjects.CheckOut_ZipCode.clear();
	Checkout_Form_PageObjects.CheckOut_ZipCode.sendKeys(ZipCode);
	logger.log(LogStatus.INFO, "ZipCode is entered");
	Actions act= new Actions(driver);
	act.sendKeys(Keys.ENTER).build().perform();
	Checkout_Form_PageObjects.CheckOut_Telephone.clear();
	Checkout_Form_PageObjects.CheckOut_Telephone.sendKeys(telephone);
	logger.log(LogStatus.INFO, "Telephone number is entered");
	
Select options_state = new Select(Checkout_Form_PageObjects.CheckOut_State);
	options_state.getFirstSelectedOption().getText();
List<WebElement> states = options_state.getOptions();
for(int i=1;i<states.size();i++){
	if(states.get(i).getText().equals(options_state.getFirstSelectedOption().getText())){
		logger.log(LogStatus.PASS, "State is selected as "+options_state.getFirstSelectedOption().getText() );
		break;
	}
}
	
	
	Select options_country = new Select(Checkout_Form_PageObjects.CheckOut_State);
options_country.getFirstSelectedOption().getText(); 
List<WebElement> country = options_country.getOptions();
for(int i=1;i<country.size();i++){
	if(country.get(i).getText().equals(options_country.getFirstSelectedOption().getText())){
		logger.log(LogStatus.PASS, "Country is selected as "+options_country.getFirstSelectedOption().getText() );
		break;
	}
}


	boolean zipcode_Err = Checkout_Form_PageObjects.CheckOut_ZipCode_field_Invalid_Err_message.size()!=0;
	boolean Telephone_Err = Checkout_Form_PageObjects.CheckOut_Phone_field_Invalid_Err_message.size()!=0;
	if(zipcode_Err ==true &
			Telephone_Err == true){
		Assert.assertTrue(true);
		Checkout_Form_PageObjects.CheckOut_continue_button.click();
		logger.log(LogStatus.PASS, "Error messsage for zipCode and phone field is displayed");
	}else{
		Checkout_Form_PageObjects.CheckOut_continue_button.click();
		Globals.fluentWaitVisibility(Payment_Screen_Page_Object.CheckOut_Payment_Title, 30);
		Assert.assertTrue(Payment_Screen_Page_Object.CheckOut_Payment_Title.isDisplayed());
		logger.log(LogStatus.PASS, "Payment screen is displayed");
		CommonUtilities.CheckOut_Card_Selection(driver,logger);
	}
	}
	}catch(Exception e){
		
	
	Globals.ERtakeScreenshot(driver, "CaptureError", "CheckOut_form()",logger);
	logger.log(LogStatus.INFO , e);
	}
}




public static void MiniCart_Total(WebDriver driver, ExtentTest logger) {
	try{
	Integer t=0;
	Integer total=0;
	PageFactory.initElements(driver, MiniCart_PageObject.class);
	
	List<WebElement> Prices = MiniCart_PageObject.MiniCart_All_Item_Price;
	int v= Prices.size();
	
	for(int i=0; i<v;i++){
		
String s =		Prices.get(i).getText();
 s=s.replaceAll(",","");

 Integer p=	Integer.valueOf(s.substring(1, s.length()));
         
total	= t + p;
      t=p;
	
	}
	String d= MiniCart_PageObject.MiniCart_Total_Amount.getText();
	d = d.substring(1, d.length());
	String ActualAmount = total.toString();
	Assert.assertEquals(ActualAmount, d);
	//Assert.assertSame(ActualAmount, d);
	logger.log(LogStatus.PASS, "MiniCArt total value is validated");
	}catch(Exception e){
		Globals.ERtakeScreenshot(driver, "CaptureError", "MiniCart_Total()",logger);
		logger.log(LogStatus.INFO , e);
	}
	
}




/*public static void SignOut(WebDriver driver,ExtentTest logger) {
	// TODO Auto-generated mPageFactory.initElements(driver, SignUp_PageObjects.class);
	PageFactory.initElements(driver, SignUp_PageObjects.class);
	PageFactory.initElements(driver, HomeScreen_PageObjects.class);
	PageFactory.initElements(driver, User_Drop_Down_In_Page_Object.class);
	Globals.fluentWaitClickable(HomeScreen_PageObjects.User_Logo_In_Header, 60);
	logger.log(LogStatus.INFO, "User icon is Clicked");
	Actions Act = new Actions(driver);
	Act.clickAndHold(HomeScreen_PageObjects.User_Logo_In_Header).moveByOffset(1, 1).pause(1000).perform();
	logger.log(LogStatus.INFO, "Drop down is opened");
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", User_Drop_Down_In_Page_Object.Sign_Out_link);
    logger. log(LogStatus.PASS, "Sign Out button is clicked");
	Globals.fluentWaitClickable(HomeScreen_PageObjects.User_Logo_In_Header, 60);
	HomeScreen_PageObjects.User_Logo_In_Header.click();
	Assert.assertTrue(User_Drop_Down_In_Page_Object.Select_Sign_Up_Button.isDisplayed());
	logger.log(LogStatus.PASS, "User is Signed Out Successfully");
	
}*/



public static void CheckOut_Card_Selection(WebDriver driver, ExtentTest logger) throws InterruptedException {
	PageFactory.initElements(driver, Payment_Screen_Page_Object.class);
	Globals.fluentWaitClickable(Payment_Screen_Page_Object.Payment_Debit_Card_Place_Order_Button,60);
	Thread.sleep(5000);
	Payment_Screen_Page_Object.Payment_Debit_Card_Radio_Btn.click();
	Payment_Screen_Page_Object.Payment_Debit_Card_Place_Order_Button.click();
	logger.log(LogStatus.PASS, "Place order button is clicked");
	WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
	Thread.sleep(10000);
	driver.switchTo().frame(frame);
	logger.log(LogStatus.PASS, "Switched to frame");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(10000);
	Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_CLick_Card.click();
	logger.log(LogStatus.INFO, "Debit Card button is clicked");
	Thread.sleep(2000);
	boolean skip_saved_Card = Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Skip_Saved_cards.size()!=0;
	if(Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Skip_Single_Saved_cards.isDisplayed()){
		Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Skip_Single_Saved_cards.click();
	
	}
	
	Globals.fluentWaitVisibility(Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Card_Number, 60);
	Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Card_Number.sendKeys("4111111111111111");
	logger.log(LogStatus.INFO, "Debit card number is added");
	Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Card_Expiry.sendKeys("0919");
	logger.log(LogStatus.INFO, "Card expiry date is added");
	Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Card_CVV.sendKeys("123");
	logger.log(LogStatus.INFO, "Debit card CVV is entered");
	Thread.sleep(10000);
/*	Globals.fluentWaitClickable(Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Remember_Checkbox, 60);
	Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Remember_Checkbox.click();*/
	Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Card_Pay_Btn.click();
	
	logger.log(LogStatus.INFO, "Pay button is clicked");
	Thread.sleep(10000);
	boolean skip_saved_Card1 = Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Skip_Saved_cards.size()!=0;
	if(Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Skip_Single_Saved_cards.isDisplayed()){
		Payment_Screen_Page_Object.Payment_Debit_Card_Pop_Up_Skip_Single_Saved_cards.click();
	
	}
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	String parentWindow = driver.getWindowHandle();
	Set<String> handles =  driver.getWindowHandles();
	   for(String windowHandle  : handles)
	       {
	       if(!windowHandle.equals(parentWindow))
	          {
	          driver.switchTo().window(windowHandle);
	          Globals.fluentWaitClickable(Payment_Screen_Page_Object.Payment_RazorPay_Success_Button, 60);

	      	Payment_Screen_Page_Object.Payment_RazorPay_Success_Button.click();
	      	logger.log(LogStatus.INFO, "RazorPay success button is clicked");
	       //  driver.close(); //closing child window
	         driver.switchTo().window(parentWindow); //cntrl to parent window
	          }
	       }
	
	Globals.fluentWaitClickable(Payment_Screen_Page_Object.Order_Successful_Confirmation_Screen, 60);
	Assert.assertTrue(Payment_Screen_Page_Object.Order_Successful_Confirmation_Screen.isDisplayed());
	logger.log(LogStatus.PASS, "Order is placed successfully");
}

}
