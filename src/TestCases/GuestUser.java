package TestCases;


import org.testng.annotations.Test;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import globals.CommonUtilities;
import globals.Constants;

import globals.Globals;
import pagObjects.Browse_Categories_PageObjects;
import pagObjects.HomeScreen_PageObjects;
import pagObjects.PDP_PageObjects;
import pagObjects.Search_PageObjects;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class GuestUser extends BaseTest {



	@Test
	public void Verify_Home_Screen_Header_Footer() throws Exception {
		try{
			logger = report.startTest("Verify_Home_Screen_Header_Footer");



			PageFactory.initElements(driver, HomeScreen_PageObjects.class);

			fluentWaitVisibility(HomeScreen_PageObjects.Desire_Header, 30);
			Assert.assertTrue(true);
			logger.log(LogStatus.INFO,"Desire Website is opened Successfully !");
			logger.log(LogStatus.INFO,"Verifying header Elements");
			Assert.assertTrue(HomeScreen_PageObjects.Desire_Logo_In_Header.isDisplayed());
			
			logger.log(LogStatus.INFO,"Desire header logger.logo is found Successfully");
			Assert.assertTrue(HomeScreen_PageObjects.User_Logo_In_Header.isDisplayed());
			
			logger.log(LogStatus.INFO,"User logger.logo is found");

			logger.log(LogStatus.PASS,"Desire Website is opened Successfully ! And Header is Verified Sucessfully!");

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			logger.log(LogStatus.INFO,"Scrolled Down to the Footer to find element");
			fluentWaitVisibility(HomeScreen_PageObjects.Desire_Footer, 30);
			logger.log(LogStatus.INFO,"Verifying the element in Footer");
			Assert.assertTrue(HomeScreen_PageObjects.Home_Text_In_Footer.isDisplayed());
			
			logger.log(LogStatus.INFO,"Desire Footer BreadCrumb (Home) is found Successfully");
			Assert.assertTrue(HomeScreen_PageObjects.Desire_Reserved_Text_In_Footer.isDisplayed());
		
			logger.log(LogStatus.INFO,"(DESIRE DESIRE 2018 . ALL RIGHTS RESERVED)  is found in footer Successfully");
			logger.log(LogStatus.PASS,"Desrie footer is Verified Sucessfully!");
		}catch(Exception e)
		{
			Globals.ERtakeScreenshot(driver, "CaptureError", "Verify_Home_Screen_Header_Footer()",logger);
			logger.log(LogStatus.INFO , e);
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnMethods="Verify_Home_Screen_Header_Footer")
	public void Browse_Categories() throws InterruptedException{
		try{
			logger = report.startTest("Browse Categoriies");
			PageFactory.initElements(driver, Browse_Categories_PageObjects.class);
			Actions action = new Actions(driver);

			action.moveToElement(Browse_Categories_PageObjects.Desire_Category_1).build().perform();

			logger.log(LogStatus.INFO, "Catergory 1 is clicked");
			fluentWaitVisibility(Browse_Categories_PageObjects.Desire_Category_2, 30);
			action.moveToElement(Browse_Categories_PageObjects.Desire_Category_2).click().build().perform();
			logger.log(LogStatus.PASS, "Catergory 2 is displayed and  clicked");
			fluentWaitVisibility(Browse_Categories_PageObjects.Desire_Category_3, 30);
			String SelectedCategory = Browse_Categories_PageObjects.Desire_Category_3.getText();
			action.moveToElement(Browse_Categories_PageObjects.Desire_Category_3).click().build().perform();
			logger.log(LogStatus.PASS, "Catergory 3 is displayed and  clicked");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Globals.wait(5);
			boolean t =	driver.findElements(By.xpath("//h1[@class='herb-off']")).size() != 0;
			if(t==true){
				//	driver.findElement(By.xpath("//div[@class='cc-off-container']/img[@class='herb-close-bttn']")).isEnabled();
				//driver.findElement(By.xpath("//div[@class='cc-off-container']/img[@class='herb-close-bttn']")).click();
				//form/div[@class='do_it_later']
				driver.findElement(By.xpath("//div[@class='do_it_later']")).click();
			}

			fluentWaitVisibility(Browse_Categories_PageObjects.Desire_Search_Result_Product_Model_Name_1, 30);
			logger.log(LogStatus.INFO, "First Product is displayed for Category selected");
			logger.log(LogStatus.INFO, "Verify Products displayed are based on selected category");
			Globals.wait(5);
			List<WebElement> List_Of_Products_Displayed = Browse_Categories_PageObjects.Desire_Search_Result_Product_Model_Name;
			logger.log(LogStatus.INFO, "No of Products displayed for selected category is = "+List_Of_Products_Displayed.size());		
			Iterator<WebElement> iter = List_Of_Products_Displayed.iterator();

			while(iter.hasNext()) {
				WebElement we = iter.next();
				logger.log(LogStatus.INFO, "Category selected is "+SelectedCategory);
				logger.log(LogStatus.INFO, "Product to be verified Text is "+we.getText().toUpperCase());
				if ((we.getText().toUpperCase()).contains(SelectedCategory)) {
					Assert.assertTrue(true);
					logger.log(LogStatus.PASS, "Same model product is displayed");
				}else{
					Assert.assertFalse(false);
					logger.log(LogStatus.FAIL, "Same model product is not displayed");
				}
			}
		}catch(Exception e)
		{
			Globals.ERtakeScreenshot(driver, "CaptureError", "Browse_Categories()",logger);
			logger.log(LogStatus.INFO , e);
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(dependsOnMethods="Browse_Categories")
	public void Search_Result_Display() throws InterruptedException{
		try{
 		PageFactory.initElements(driver, Browse_Categories_PageObjects.class);
		PageFactory.initElements(driver, Search_PageObjects.class);
		PageFactory.initElements(driver, PDP_PageObjects.class);
		logger = report.startTest("Search_Result_Display_And_Navigate_to_PDP");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Globals.wait(5);
	boolean t =	driver.findElements(By.xpath("//h1[@class='herb-off']")).size() != 0;
	if(t==true){
	//	driver.findElement(By.xpath("//div[@class='cc-off-container']/img")).click();
		driver.findElement(By.xpath("//div[@class='do_it_later']")).click();
	}
	
		fluentWaitClickable(Search_PageObjects.Search_Icon, 30);
		Search_PageObjects.Search_Icon.click();
		logger.log(LogStatus.INFO, "Search icon is Clicked");
		Search_PageObjects.Search_Input_Field.sendKeys(Constants.Search_Motorola);
		logger.log(LogStatus.INFO,"Search text is entered in Search Field");
		String Search_Entered_Value=  Search_PageObjects.Search_Input_Field.getAttribute("value");
		logger.log(LogStatus.INFO, "Entered text in search field is "+ Search_Entered_Value);
		Search_PageObjects.Search_Input_Field.sendKeys(Keys.ENTER);
		logger.log(LogStatus.INFO, "Enter key is hit for search Result");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Globals.wait(5);
		List<WebElement> List_Of_Products_Displayed = Browse_Categories_PageObjects.Desire_Search_Result_Product_Model_Name;
		logger.log(LogStatus.INFO, "No of Products displayed for Search item is = "+List_Of_Products_Displayed.size());		
		Iterator<WebElement> iter = List_Of_Products_Displayed.iterator();

		while(iter.hasNext()) {
			WebElement we = iter.next();
			logger.log(LogStatus.INFO, "Searched Value is "+Search_Entered_Value.toUpperCase());
			logger.log(LogStatus.INFO, "Product to be verified Text is "+we.getText().toUpperCase());
			if ((we.getText().toUpperCase()).contains(Search_Entered_Value.toUpperCase())) {
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Same model product is displayed");
			}else{
				Assert.assertFalse(false);
				logger.log(LogStatus.FAIL, "Same model product is not displayed");
			}
		}

		logger.log(LogStatus.INFO,"Verifying Searched Product Navigates to its PDP page on click");
		String Product_Clicked_In_Search_Result = Search_PageObjects.Search_Result_Product_Name.getText();
		Search_PageObjects.Select_Product_From_SearchDisplay.click();
		logger.log(LogStatus.INFO, "Search result second product is clicked");
		fluentWaitClickable(PDP_PageObjects.PDP_Product_Title, 30);
		Assert.assertEquals(PDP_PageObjects.PDP_Product_Title.getText(), Product_Clicked_In_Search_Result);
		logger.log(LogStatus.PASS,"Navigated to PDP page and respective  product PDP page is displayed");
		}catch(Exception e)
        {
    	    Globals.ERtakeScreenshot(driver, "CaptureError", "Search_Result_Display()",logger);
    		logger.log(LogStatus.INFO , e);
    		Assert.assertTrue(false);
    }
	}
	
	@Test(dependsOnMethods="Guest_User_BrowseCategory_MiniCart_Validations")
	public void Guest_User_SearchResult_MiniCart_VAlidations() throws InterruptedException{
		try{
		String Title_PDP;
		String Price_PDP;
	
		logger = report.startTest("Guest_User_SearchResult_MiniCart_VAlidations");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonUtilities.Search_Category_Add_To_Cart(report,driver,logger);
		PageFactory.initElements(driver, PDP_PageObjects.class);
		Title_PDP = PDP_PageObjects.PDP_Product_Title.getText();
		logger.log(LogStatus.INFO, "PDP Title is "+ Title_PDP);
		Price_PDP = PDP_PageObjects.PDP_Product_Price.getText();
		logger.log(LogStatus.INFO, "PDP Price is "+ Price_PDP);
		PDP_PageObjects.PDP_Add_To_Cart.click();
		logger.log(LogStatus.INFO,"Product is added to cart from searched product");
		logger.log(LogStatus.INFO,"Verifying Add_To_Cart button changes to View_Cart");
		PDP_PageObjects.PDP_AddToCart_ChangeTO_ViewCart.isDisplayed();
		logger.log(LogStatus.PASS,"Button is changed to (View Cart)");
		CommonUtilities.MiniCartValidations(Title_PDP,Price_PDP,driver, report,logger);
		logger.log(LogStatus.PASS,"PDP and mini cart validation is done");
	    
		
	
	
	
		}catch(Exception e)
        {
    	    Globals.ERtakeScreenshot(driver, "CaptureError", "Guest_User_CheckOut_SearchResult()",logger);
    		logger.log(LogStatus.INFO , e);
    		Assert.assertTrue(false);
    }
	}
	
	@Test(dependsOnMethods="Search_Result_Display")
	public void Guest_User_BrowseCategory_MiniCart_Validations() throws InterruptedException{
		try{
		String Title_PDP;
		String Price_PDP;
		PageFactory.initElements(driver, PDP_PageObjects.class);
		
		logger = report.startTest("Guest_User_BrowseCategory_MiniCart_Validations");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonUtilities.Browse_Category_Add_To_Cart(report,driver,logger);
		Title_PDP = PDP_PageObjects.PDP_Product_Title.getText();
		logger.log(LogStatus.INFO, "PDP Title is "+ Title_PDP);
	
	
		Price_PDP = PDP_PageObjects.PDP_Product_Price.getText();
		logger.log(LogStatus.INFO, "PDP Price is "+ Price_PDP);
		PDP_PageObjects.PDP_Add_To_Cart.click();
		logger.log(LogStatus.INFO,"Product is added to cart from Browser Category");
		logger.log(LogStatus.INFO,"Verifying Add_To_Cart button changes to View_Cart");
		PDP_PageObjects.PDP_AddToCart_ChangeTO_ViewCart.isDisplayed();
		logger.log(LogStatus.PASS,"Button is changed to (View Cart)");
		CommonUtilities.MiniCartValidations(Title_PDP,Price_PDP,driver, report, logger);
		
		}catch(Exception e)
        {
    	    Globals.ERtakeScreenshot(driver, "CaptureError", "Guest_User_CheckOut_BrowseCategory()",logger);
    		logger.log(LogStatus.INFO , e);
    		Assert.assertTrue(false);
    }
	}
	
	@Test(dependsOnMethods={"Guest_User_SearchResult_MiniCart_VAlidations"},dataProvider = "CheckOut_Form")
	public void Guest_User_CheckOut_Frm_MiniCart(String Email,String FN, String LN, String Street_Addr, String ZipCode,
			String telephone) throws InterruptedException{
		
		logger = report.startTest("Guest_User_CheckOut_Frm_MiniCart");
		try {
			if(Email.equals("")& FN.equals("")){
			CommonUtilities.MiniCart_Total(driver,logger);
			CommonUtilities.CheckoutScreen_From_MiniCart(driver,logger);
			CommonUtilities.CheckOut_form(driver,logger, Email, FN, LN, Street_Addr, ZipCode, telephone);
			}else{
				CommonUtilities.CheckOut_form(driver,logger, Email, FN, LN, Street_Addr, ZipCode, telephone);
				
			}
		} catch (Exception e) {
			 Globals.ERtakeScreenshot(driver, "CaptureError", "Guest_User_CheckOut_Frm_MiniCart()",logger);
	    		logger.log(LogStatus.INFO , e);
	    		Assert.assertTrue(false);
		}


}
}
