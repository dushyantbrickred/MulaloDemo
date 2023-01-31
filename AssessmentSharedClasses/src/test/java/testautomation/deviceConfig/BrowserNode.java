package testautomation.deviceConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BrowserNode extends Node
{
	private WebDriver BrowserDriver;
	
	/**
	 * @return the browserDriver
	 */
	public WebDriver getBrowserDriver() {
		return BrowserDriver;
	}

	/**
	 * @param browserDriver the browserDriver to set
	 */
	public void setBrowserDriver(WebDriver browserDriver) {
		BrowserDriver = browserDriver;
	}

	public BrowserNode(WebDriver browserDriver, DesiredCapabilities desiredCapabilities, String hostURL) 
	{
		super(desiredCapabilities,hostURL);
		setBrowserDriver(browserDriver);
	
	}

}
