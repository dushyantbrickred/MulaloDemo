package testautomation.deviceConfig;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Node 
{
	private DesiredCapabilities nodeCapabilities;
	private String hostURL;
	
	/**
	 * @return the nodeCapabilities
	 */
	public DesiredCapabilities getNodeCapabilities() {
		return nodeCapabilities;
	}

	/**
	 * @param nodeCapabilities the nodeCapabilities to set
	 */
	public void setNodeCapabilities(DesiredCapabilities nodeCapabilities) {
		this.nodeCapabilities = nodeCapabilities;
	}

	/**
	 * @return the hostURL
	 */
	public String getHostURL() {
		return hostURL;
	}

	/**
	 * @param hostURL the hostURL to set
	 */
	public void setHostURL(String hostURL) {
		this.hostURL = hostURL;
	}

	/**
	 * @param nodeName
	 * @param nodeCapabilities
	 * @param hostURL
	 */
	public Node(DesiredCapabilities nodeCapabilities, String hostURL) {
		this.nodeCapabilities = nodeCapabilities;
		this.hostURL = hostURL;
	}
	
	
	//Constructor for setting up the node
	
} 
