/**
 *
 */
package testautomation.pages;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.CharMatcher;
import com.relevantcodes.extentreports.LogStatus;
import testautomation.extentReports.ExtentTestManager;

import testautomation.utilities.ElementFunctionality;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Mulalo
 *
 */
public class Assessment_ObjectPage {

	private static final String[] String = null;
	public WebDriver BrowserDriver;
	public ElementFunctionality verifyElement;
	public String Device;

	public Assessment_ObjectPage(WebDriver browserDriver, String Device)
	{
		BrowserDriver = browserDriver;
		this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
		PageFactory.initElements(BrowserDriver, this);
	}
         
     
	
	/**********************************************************Login Page****************************************************************/
	
	//Username textfield
	@FindBy(xpath="//*[@id='user-name']")
	private WebElement username;
	

	//password textfield
	@FindBy(xpath="//*[@id='password']")
	private WebElement password;
		

	//login Button
	@FindBy(xpath="//*[@id='login-button']")
	private WebElement loginButton;
	
	
	public void ValidatePageElements(){
		
		verifyElement.verifyBrowserElement(username, "username");
		verifyElement.verifyBrowserElement(password, "password");
		verifyElement.verifyBrowserElement(loginButton, "login Button");
		
	}
	
	
	public void enterUsername(String Value)
	{
		if(verifyElement.verifyBrowserElementValue(username, "username") == 0)
		{
			verifyElement.sendKeys(username, "username", Value);
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	public void enterPassword(String Value)
	{
		if(verifyElement.verifyBrowserElementValue(password, "password") == 0)
		{
			verifyElement.sendKeys(password, "password", Value);
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	public void clickloginButton()
	{
		if(verifyElement.verifyBrowserElementValue(loginButton, "loginButton") == 0)
		{
			verifyElement.clickElement(loginButton, "loginButton");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	/**********************************************************Order Page****************************************************************/
	//sort dropdown
	@FindBy(xpath="//*[@id='header_container']/div[2]/div[2]/span/select")
	private WebElement sortDD;
	
	
	//Low Price Add button
	@FindBy(xpath="//*[@id='inventory_container']/div/div/div/div[1]/div[2]//div[2]//button")
	private WebElement lowPrice_Addbutton;
	
	
	//High Price Add button
	@FindBy(xpath="//*[@id='inventory_container']/div/div/div/div[last()]/div[2]//div[2]//button")
	private WebElement highPrice_Addbutton;
			
	
	//shopping cart Icon
	@FindBy(xpath="//*[@id='shopping_cart_container']/a")
	private WebElement shoppingCartIcon;
	
	
	public void sortProducts(String Value)
	{
		if(verifyElement.verifyBrowserElementValue(sortDD, "sortDD") == 0)
		{
			verifyElement.selectorOptionPicker(sortDD, "sortDD", Value);
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	
	public void clickLowPrice_Addbutton()
	{
		if(verifyElement.verifyBrowserElementValue(lowPrice_Addbutton, "lowPrice_Addbutton") == 0)
		{
			verifyElement.clickElement(lowPrice_Addbutton, "lowPrice_Addbutton");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	public void clickHighPrice_Addbutton()
	{
		if(verifyElement.verifyBrowserElementValue(highPrice_Addbutton, "highPrice_Addbutton") == 0)
		{
			verifyElement.clickElement(highPrice_Addbutton, "highPrice_Addbutton");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	public void clickShoppingCartIcon()
	{
		if(verifyElement.verifyBrowserElementValue(shoppingCartIcon, "shoppingCartIcon") == 0)
		{
			verifyElement.clickElement(shoppingCartIcon, "shoppingCartIcon");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	
	
	
	
	/**********************************************************Checkout cart Page****************************************************************/
	
	//low Price Amount Checkout Screen
	@FindBy(xpath="//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div")
	private WebElement lowPrice_Amount_Checkout;
	
	//high Price Amount Checkout Screen
	@FindBy(xpath="//*[@id='cart_contents_container']/div/div[1]/div[4]/div[2]/div[2]/div")
	private WebElement highPrice_Amount_Checkout;
	
	//Low Price Name
	@FindBy(xpath="//*[@id='item_2_title_link']/div")
	private WebElement lowPrice_Name_Checkout;
	
	//High Price Name
	@FindBy(xpath="//*[@id='item_5_title_link']/div")
	private WebElement highPrice_Name_Checkout;
    
    
	//Checkout Button
	@FindBy(xpath="//*[@id='checkout']")
	private WebElement checkoutButton;
	
	public void clickCheckoutButton()
	{
		if(verifyElement.verifyBrowserElementValue(checkoutButton, "checkoutButton") == 0)
		{
			verifyElement.clickElement(checkoutButton, "checkoutButton");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	
	public void validating_FirstItemPrices_Checkout_Screen(double value) {
		
		String a = lowPrice_Amount_Checkout.getText().replace("$", "");
		double b = Double.parseDouble(a);		
	
		double Epsilon =  0.0003;
		
		if(Math.abs(value - b) < Epsilon ) {
			System.out.println("Pass");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Validating First Item Amount Passed");
		}else {
			System.out.println("Fail");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Validating First Item Amount Failed");
		}		
		
	}
	
	public void validating_SecondItemPrices_Checkout_Screen(double value) {
		
		String a = highPrice_Amount_Checkout.getText().replace("$", "");
		double b = Double.parseDouble(a);		
	
		double Epsilon =  0.0003;
		
		if(Math.abs(value - b) < Epsilon ) {
			System.out.println("Pass");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Validating Second Item Amount Passed");
		}else {
			System.out.println("Fail");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Validating Second Item Amount Failed");
		}	
		
	}
	
	public void validating_Names_Checkout_Screen(String firstItem_name, String lastItem_name) {
		
		String a = lowPrice_Name_Checkout.getText();
		String b = highPrice_Name_Checkout.getText();
					
		
		Assert.assertEquals(firstItem_name,a );
		Assert.assertEquals(lastItem_name,b );
	}
	
	
	/**********************************************************Personal Details Page****************************************************************/
    
	//firstname textfield
	@FindBy(xpath="//*[@id='first-name']")
	private WebElement firstname;
	

	//lastname textfield
	@FindBy(xpath="//*[@id='last-name']")
	private WebElement lastname;
		
	
	//postalcode textfield
	@FindBy(xpath="//*[@id='postal-code']")
	private WebElement postalcode;
	
	//continue Button
	@FindBy(xpath="//*[@id='continue']")
	private WebElement continueButton;
	
	public void enterFirstname(String Value)
	{
		if(verifyElement.verifyBrowserElementValue(firstname, "firstname") == 0)
		{
			verifyElement.sendKeys(firstname, "firstname", Value);
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	public void enterLastname(String Value)
	{
		if(verifyElement.verifyBrowserElementValue(lastname, "lastname") == 0)
		{
			verifyElement.sendKeys(lastname, "lastname", Value);
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	
	public void enterPostalcode(String Value)
	{
		if(verifyElement.verifyBrowserElementValue(postalcode, "postalcode") == 0)
		{
			verifyElement.sendKeys(postalcode, "postalcode", Value);
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	
	public void clickContinueButton()
	{
		if(verifyElement.verifyBrowserElementValue(continueButton, "continue Button") == 0)
		{
			verifyElement.clickElement(continueButton, "continue Button");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	/**********************************************************Finish Page****************************************************************/
    

	//total_ItemsPrice Amount
	@FindBy(xpath="//*[@id='checkout_summary_container']/div/div[2]/div[5]")
	private WebElement total_ItemsPrice;
	
	
	//total_IncludingTaxPrice Amount
	@FindBy(xpath="//*[@id='checkout_summary_container']/div/div[2]/div[7]")
	private WebElement total_IncludingTaxPrice;

	//finish Button
	@FindBy(xpath="//*[@id='finish']")
	private WebElement finishButton;
    
	
	
	public void validating_Item_totalAmount(double value) {
		
		
		String a = total_ItemsPrice.getText().replaceAll("[^\\d.]", "");
		//System.err.println(a);
		double b = Double.parseDouble(a);	
		double Epsilon =  0.0003;
		
		if(Math.abs(value - b) < Epsilon ) {
			System.out.println("Pass");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Validating Items Total Amount Passed");
		}else {
			System.out.println("Fail");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Validating Items Total Amount Failed");
		}
		
		
	}
	
	public void validating_totalAmount_IncTax(double value) {
		
		String a = total_IncludingTaxPrice.getText().replaceAll("[^\\d.]", "");
		double b = Double.parseDouble(a);	
		double Epsilon =  0.0003;
		
		if(Math.abs(value - b) < Epsilon ) {
			System.out.println("Pass");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Validating Total Amount Including Tax Passed");
		}else {
			System.out.println("Fail");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Validating Total Amount Including Tax Failed");
		}
		
		
	}
	
	
	
	
	public void clickFinishButton()
	{
		if(verifyElement.verifyBrowserElementValue(finishButton, "finishButton") == 0)
		{
			verifyElement.clickElement(finishButton, "finishButton");
			
		}else
		{
			System.err.println("Element couldnt be found ");
		}
	}
	
	/**********************************************************Order Confirmation Page****************************************************************/
	
	//order Confirmation Message
	@FindBy(xpath="//*[@id='checkout_complete_container']/div")
	private WebElement orderConfirmation;
	
	public void validating_orderConfirmation_Message(String message) {
		
		String a = orderConfirmation.getText();
		Assert.assertEquals(message,a );

	}
	
	
	
	

}




