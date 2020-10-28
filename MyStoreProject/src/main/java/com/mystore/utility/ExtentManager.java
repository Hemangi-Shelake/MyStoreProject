package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	public static void setExtent()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//ExtentReport//"+"//MyReports.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"//extent_config.xml");
		//htmlReporter.config().setDocumentTitle("Automation Test Report");
		//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		//htmlReporter.config().setTheme(Theme.DARK);

		extentReports=new ExtentReports();
		extentReports.attachReporter(htmlReporter);

		extentReports.setSystemInfo("HostName", "MyHost");
		extentReports.setSystemInfo("ProjectName", "MyStoreProject");
		extentReports.setSystemInfo("Tester", "Hemangi");
		extentReports.setSystemInfo("OS", "Mac");
		extentReports.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport()
	{
		extentReports.flush();
	}


}
