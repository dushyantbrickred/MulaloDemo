package testautomation.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import testautomation.deviceConfig.BrowserNode;
import testautomation.deviceConfig.Node;
import testautomation.deviceConfig.SetUpHashMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseTest 
{
    public WebDriverWait wait;
	public String url; 
	public HashMap<String,Node> SeleniumGrid;
	public SetUpHashMap HashSetup; 
	public String Device;
	public WebDriver testB;
	
    public WebDriver getDriver() 
    {
    	WebDriver web = null;
		for(Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet())
		{
			if(currentNode.getKey().equals(Device))
			{
				
				//Browser
				if(currentNode.getValue() instanceof BrowserNode)
				{
					
					web = returnWebDriver(); 
				}
				else
				{
					web = null;
				}
					
			}
		}
		return web;
		
        
    }

    
    public WebDriver returnWebDriver()
    {
    	return testB;
    }
    
    @BeforeClass (description = "Initialize Grid")
    public void setup () 
    {
    	System.out.println("Initializing Nodes");
		
		SeleniumGrid = new HashMap<>();
		HashSetup = new SetUpHashMap(SeleniumGrid);
		
		try
		{
			
			HashSetup.SetUpBrowser();
			
			
		}
		
		catch (Exception e) 
		{
			Assert.fail();
			e.printStackTrace();
		} 
    }

   
}
