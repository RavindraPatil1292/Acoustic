package utilities;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports reports;
	
	private ExtentReportManager() {
		System.out.println("this is private constructor of singleton class");
	}
	
	public static ExtentReports getInstance() {
	   //File file = new File(System.getProperty("user.dir")+"\\test-output\\html\\ExtentReport_"+CaptureScreenshot.curDate+"_"+CaptureScreenshot.curTime+".html");
		File file = new File(System.getProperty("user.dir")+"\\test-output\\html\\ExtentReport.html");
		
		if(htmlReporter==null) {
			htmlReporter = new ExtentHtmlReporter(file);
		}
		if(reports==null) {
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
		}
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\ExtentReportsConfig.xml"), true);
		return reports;
	}
}
