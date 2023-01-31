package testautomation.utilities;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import testautomation.extentReports.ExtentTestManager;
import testautomation.listeners.TestListener;



public class ElementFunctionality extends TestListener
{
	private FluentWait<WebDriver> wait;
	public WebDriver BrowserDriver;
	public String Device; 
	//private AndroidCommonErrors androidCommonErrors;

	public ElementFunctionality(WebDriver BrowserDriver, String Device)
	{
		this.BrowserDriver = BrowserDriver;
		this.Device = Device;
		wait = new FluentWait<WebDriver>(BrowserDriver);
		wait.withTimeout(Duration.ofSeconds(100));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementClickInterceptedException.class);
		//androidCommonErrors = new AndroidCommonErrors(testA, Device);
	}

	
	//Verification of element helper function
	public void verifyBrowserElement(WebElement element, String Name)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			System.out.println(Name+" displayed on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.PASS, Name+" displayed on " + Device);
		}
		catch(TimeoutException ex)
		{
			System.err.println(Name + " element could not be found on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.FAIL, Name + " element could not be found on " + Device);
		}

	}
	//validate value  A and B function 
	public void validateValue(WebElement elementValue,String name, String value)
	{
		try
		{
			if(verifyBrowserElementValue(elementValue, name) == 0)
			{
				String base64Screenshot;
				if(elementValue.getText().compareToIgnoreCase(name) == 0)
				{
					System.out.println(name+" is equals too: " + value);
					 base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)BrowserDriver).getScreenshotAs(OutputType.BASE64);

					//Extentreports log and screenshot operations for failed tests.
				
					 ExtentTestManager.getTest().log(LogStatus.FAIL,name);
					ExtentTestManager.getTest().log(LogStatus.PASS, name+" is equals too: " + value ,	ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
				

				}else
				{
					 base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)BrowserDriver).getScreenshotAs(OutputType.BASE64);
					 System.out.println(name+" is not equals too: " + value);
					//Extentreports log and screenshot operations for failed tests.
					ExtentTestManager.getTest().log(LogStatus.FAIL,name);
					ExtentTestManager.getTest().log(LogStatus.FAIL,name,ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
				}
				
			}
		}
		catch(TimeoutException ex)
		{
			System.err.println(name + " element could not be found on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, name + " element could not be found on " + Device);
		}
	}
	//Verification that an element is not visible
	public void verifyBrowserElementInvisibility(WebElement element, String Name)
	{
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println(Name+" no longer visible on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.PASS, Name+" no longer visible ondisplayed on " + Device);
		}
		catch(TimeoutException ex)
		{
			Assert.fail(Name + " element is visible or the page is taking too long to load on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.FAIL, Name + " element is visible or the page is taking too long to load on " + Device);
		}

	}

	//Verification of element programatic
	public int verifyBrowserElementValue(WebElement element, String Name)
	{
		int result = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			//System.out.println(Name+" displayed on " + Device);
			result = 0;

		}
		catch(Exception ex)
		{
			result = 1;

		}
		return result;

	}


	public void clickElement(WebElement element, String Name)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			//Thread.sleep(3000);
			element.click();
			System.out.println(Name+" was clicked on " + Device);
			ExtentTestManager.getTest().log(LogStatus.PASS, Name+" was clicked on " + Device);

		}
		catch (NoSuchElementException e)
		{
			Assert.fail(Name + " element could not be clicked on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, Name+" element could not be clicked on " + Device);
			e.printStackTrace();
		} 

		/*	catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, Name+" element could not be clicked on " + Device);
			}*/
	}



	public void hoverBrowserElement(WebElement element, String Name)
	{
		try
		{

			Actions action = new Actions(BrowserDriver);

			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			action.moveToElement(element).build().perform();

			System.out.println("Hovering over "+ Name +" on "+ Device);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Hovering over "+ Name +" on "+ Device);

		}
		catch (Exception e)
		{

			Assert.fail(element + " element could not be hovered on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.FAIL, " element could not be hovered on " + Device);

		} 



	}

	

		
	public void dismissWebDialog()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = BrowserDriver.switchTo().alert();
		alert.dismiss();
	}

	
	public void sendKeys(WebElement element, String Name, String Text)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			
				element.click();
				element.sendKeys(Text);
				System.out.println("The text: '"+Text +"' was sent to "+ Name +" on " + Device);
				ExtentTestManager.getTest().log(LogStatus.PASS, "The text: '"+Text +"' was sent to "+ Name +" on " + Device);

		}
		catch(TimeoutException ex)
		{
			Assert.fail("The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

	}

	public void sendKeysWithClear(WebElement element, String Name, String Text)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			element.click();
			//element.sendKeys(Keys.chord(Keys.CONTROL, "a"),Text,Keys.ENTER);
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Text,Keys.ENTER);
			System.out.println("The text: '"+Text +"' was sent to "+ Name +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The text: '"+Text +"' was sent to "+ Name +" on " + Device);


		}
		catch(TimeoutException ex)
		{
			Assert.fail("The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

	}
	
	public void sendKeysWithClearNoClick(WebElement element, String Name, String Text)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			element.click();
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Text,Keys.ENTER);
			System.out.println("The text: '"+Text +"' was sent to "+ Name +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The text: '"+Text +"' was sent to "+ Name +" on " + Device);


		}
		catch(TimeoutException ex)
		{
			Assert.fail("The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

	}


	public void sendKeysWithClearNoEnter(WebElement element, String Name, String Text)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			element.click();
			//element.sendKeys(Keys.chord(Keys.CONTROL, "a"),Text);
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Text);
			System.out.println("The text: '"+Text +"' was sent to "+ Name +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The text: '"+Text +"' was sent to "+ Name +" on " + Device);


		}
		catch(TimeoutException ex)
		{
			Assert.fail("The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The text: '"+Text +"' could not be sent to "+ Name + " on " + Device);
		}

	}


	public void selectorOptionPicker(WebElement element, String dropdownName,String option)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			clickElement(element, dropdownName);
			Select dropdown = new Select(element);
			
			int index = 0;
			
			for(WebElement options : dropdown.getOptions()) {
				if(options.getText().equalsIgnoreCase(option)) {
					break;
				}
				index++;
			}
			
			//dropdown.selectByVisibleText(option);
			dropdown.selectByIndex(index);

			System.out.println("The option: '"+option +"' was selected from "+ dropdownName +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The option: '"+option +"' was selected from "+ dropdownName +" on " + Device);



		}
		catch(TimeoutException ex)
		{
			Assert.fail("The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
		}

		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
		}
	}
	

	public boolean isStringPresent(String comparedText, String Keyword)
	{
		boolean blnResult = false;
		if(comparedText.contains(Keyword))
		{
			blnResult = true;
		}

		return blnResult;
	}

	public void waitForFullPageLoad() 
	{
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(BrowserDriver, 30);
		wait.until(pageLoadCondition);
	}


	public void switchToBrowserFrame(WebElement element, String Name) 
	{
		try 
		{
			verifyBrowserElement(element, Name);
			BrowserDriver.switchTo().frame(element);
			//passTest("Successfully switched to " + Name);
		}
		catch(Exception ex)
		{
			//failTest("Unsuccessful switch to " + Name);
		}

	}

	public void switchOutOfBrowserFrame() 
	{
		try 
		{
			BrowserDriver.switchTo().defaultContent();
		}
		catch(Exception ex)
		{
			//failTest("Unsuccessful switch out of iFrame");
		}

	}


	public void selectorOptionPickerByIndex(WebElement element, String dropdownName,int option)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			clickElement(element, dropdownName);
			Select dropdown = new Select(element);
			dropdown.selectByIndex(option);

			System.out.println("The option: '"+option +"' was selected from "+ dropdownName +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The option: '"+option +"' was selected from "+ dropdownName +" on " + Device);



		}
		catch(TimeoutException ex)
		{
			Assert.fail("The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
		}

		catch(Exception ex)
		{
			System.out.println("The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The option: '"+option +"' could not be selected from "+ dropdownName +" on " + Device);
		}
	}



}

