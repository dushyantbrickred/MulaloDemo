package testautomation.extentReports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;


public class ExtentManager 
{
	private static ExtentReports extent;
	 
    public synchronized static ExtentReports getReporter()
    {
        if(extent == null)
        {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        	Date date = new Date();
        	
            String fileName = "ExtentReportResults "+formatter.format(date)+".html";
            
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) 
            {
            	 extent = new ExtentReports(workingDir+"\\ExtentReports\\"+fileName, true);
            } 
            else if (operSys.contains("nix") || operSys.contains("nux")|| operSys.contains("aix")) 
            {
                
            } 
            else if (operSys.contains("mac")) 
            {
            	 extent = new ExtentReports(workingDir+"/ExtentReports/"+fileName, true);
            }
        }
        return extent;	
    }
}
