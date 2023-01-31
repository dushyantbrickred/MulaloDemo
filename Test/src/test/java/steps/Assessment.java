package steps;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import testautomation.deviceConfig.BrowserNode;
import testautomation.deviceConfig.Node;
import testautomation.pages.Assessment_ObjectPage;
import testautomation.steps.BaseTest;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment extends BaseTest
{
	private Assessment_ObjectPage assessment_ObjectPage;


	@Parameters({"URL","Device"})
	@BeforeClass (description = "Instantiate Grid")
    public void setupTest (String URL, String device) {
		try
		{
			HashSetup.SetUpBrowser();
	
			System.out.println("Instantiating Nodes");
			url = URL;
		  	Device = device;
		
			//Loop runs through all the Nodes in the Grid and performs the tests on them
			for(Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet())
			{
				if(currentNode.getKey().equals(Device))
				{
					
					//Browsers
					if(currentNode.getValue() instanceof BrowserNode)
					{
						try
						{


                            WebDriverManager.chromedriver().setup();
                            testB = new ChromeDriver(); 							
							System.out.println("ChromeDriver Setup Complete");

						}
						catch(Exception e)
						{
							Assert.fail();
							e.printStackTrace();

						}

					}

				}
			}


		}

		catch (Exception e)
		{
			Assert.fail();
			e.printStackTrace();

		}

	  }
	
	

	@Test(priority=0,description="Inspired Testing Assessment")
	public void order()
	  {
	  try
		{
			//Loop runs through all the Nodes in the Grid and performs the tests on them
			for(Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet())
			{
				if(currentNode.getKey().equals(Device))
				{
					//Browsers
					if(currentNode.getValue() instanceof BrowserNode)
					{
						try
						{

							String baseUrl="https://www.saucedemo.com";							
							testB.navigate().to(baseUrl);
							testB.navigate().to("https://www.saucedemo.com");						   
							testB.manage().window().maximize();
							
							System.out.println("Initializing Pages");
							assessment_ObjectPage= new  Assessment_ObjectPage(testB,Device);							
							System.out.println("Initializing Pages Complete");
										
							
							
							//starts
							
							//Login Page
							assessment_ObjectPage.ValidatePageElements();
							assessment_ObjectPage.enterUsername("standard_user");						
							assessment_ObjectPage.enterPassword("secret_sauce");
							assessment_ObjectPage.clickloginButton();
							

							//Order/Items Page
							assessment_ObjectPage.sortProducts("Price (low to high)");
							assessment_ObjectPage.clickLowPrice_Addbutton();
							assessment_ObjectPage.clickHighPrice_Addbutton();
							assessment_ObjectPage.clickShoppingCartIcon();
							
							
							//Checkout page
							assessment_ObjectPage.validating_FirstItemPrices_Checkout_Screen(7.99);
							assessment_ObjectPage.validating_SecondItemPrices_Checkout_Screen(49.99);
							assessment_ObjectPage.validating_Names_Checkout_Screen("Sauce Labs Onesie", "Sauce Labs Fleece Jacket");
							assessment_ObjectPage.clickCheckoutButton();
													
							
							//Personal Info Page
							assessment_ObjectPage.enterFirstname("Mulalo");
							assessment_ObjectPage.enterLastname("Test");
							assessment_ObjectPage.enterPostalcode("0002");
							assessment_ObjectPage.clickContinueButton();
							
							
							//Finish Page
							assessment_ObjectPage.validating_Item_totalAmount(57.98);
							assessment_ObjectPage.validating_totalAmount_IncTax(62.62);
							assessment_ObjectPage.clickFinishButton();

							//Order Confirmation Page
							assessment_ObjectPage.validating_orderConfirmation_Message("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
							
						
						}
						catch(Exception e)
						{
							e.printStackTrace();
							Assert.fail();
							

						}

					}

				}
			}


		}



		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
	

		}

	  }

	
	
	
	
	@AfterTest
	public void closeBrowser() throws Throwable
	{
		 try
			{
				//Loop runs through all the Nodes in the Grid and performs the tests on them
				for(Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet())
				{
					if(currentNode.getKey().equals(Device))
					{
		
						//Browsers
						if(currentNode.getValue() instanceof BrowserNode)
						{
							try
							{

							  // screenRecorder.stop();
								testB.quit();

							}
							catch(Exception e)
							{
								Assert.fail();
								e.printStackTrace();

							}

						}

					}
				}


			}

			catch (Exception e)
			{
				Assert.fail();
				e.printStackTrace();
			}

	}


}
