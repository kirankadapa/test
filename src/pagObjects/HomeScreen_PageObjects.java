package pagObjects;

import globals.Globals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomeScreen_PageObjects{	

	@FindBy(xpath="//div[@class='header content']")
	public static WebElement Desire_Header;
	
	@FindBy(xpath="//strong[@class='logo']/img")
	public static WebElement Desire_Logo_In_Header;

	@FindBy(xpath="//div[@class='panel header']//a[@href='javascript:void(0)']//img")
	public static WebElement  User_Logo_In_Header;

	@FindBy(xpath="//footer[@class='page-footer']")
	public static WebElement  Desire_Footer;

	@FindBy(xpath="//a[@href='javascript:void(0)'][contains(text(),'HOME')]")
	public static WebElement  Home_Text_In_Footer;

	@FindBy(xpath="//span[contains(text(),' ALL RIGHTS RESERVED')]")
	public static WebElement  Desire_Reserved_Text_In_Footer;

	@FindBys(@FindBy(xpath="//span[contains(text(),'Invalid login or password.')]"))
	public static List<WebElement> LoginPage_Invalid_Error_Message;


}