package testautomation.deviceConfig;


import org.openqa.selenium.remote.DesiredCapabilities;


public class NodeCapability
{

	private DesiredCapabilities cap;
	
	public NodeCapability() 
	{
		cap = new DesiredCapabilities();
	}
	//Setting the capabilities for browsers
	public DesiredCapabilities BrowserNodeCapability(String Browser) 
	{
		//DesiredCapabilities permission = new DesiredCapabilities();
		//permission.setCapability("autoGrantPermissions", true);
		
		switch(Browser)
		{
			case "chrome":
			{
				return cap.chrome();
				//return cap.merge(permission);
				
			
			}
			case "firefox":
			{
				return cap.firefox();
				//return cap.merge(permission);
			}
			case "ie":
			{
				return cap.internetExplorer();
				//return cap.merge(permission);
			}
			case "edge":
			{
				return cap.edge();
				//return cap.merge(permission);
			}
			case "safari":
			{
				return cap.safari();
				//return cap.merge(permission);
			}
		}
		return null;
		
		
	}
	
		



}
