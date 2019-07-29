package com.sntps.acdc.utils;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Utility 
{
	
		public static final String HTTP_CMS_SERVICES_DEV = "http://cms-services-dev.dev.cf.private.springer.com/";
		public static final String HTTP_CMS_SERVICES_QA = "http://cms-services-qa.dev.cf.private.springer.com/";
		private static final String HTTP_CMS_SERVICES_STAGE = "http://cms-services-qa.dev.cf.private.springer.com/";
		private static final String HTTP_LOCALHOST_8080 = "http://localhost:8080/";
		
		public static String postCallRandomGenerator = null ;
		
		public static ExtentTest test;
		static ExtentReports report;
	
		/*@BeforeClass
		public static void startTest()
		{
			report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
			test = report.startTest("ApacheMultipartTest");
		}
*/
		
		/* Random String generator method */
		public static String generateRandom() 
		{
			String SALTCHARS = "4-x5kbdwak-QATesting-8w79moyo";
	        StringBuilder salt = new StringBuilder();
	     
	       Random rnd = new Random();
	        
	       while (salt.length() < 18) 
	        { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        StringBuilder str = new StringBuilder(saltStr);
			    
	        str.insert(10, "-QATesting-");
	        String testStr = str.toString();
			/*postCallRandomGenerator = "abcdefhgijklmnpq";
	        return postCallRandomGenerator;*/
	        return testStr;
	        
		}
		
		//4-x5kbdwak-QATesting-8w79mabf
		/*@AfterClass
		public static void endTest()
		{
			report.endTest(test);
			report.flush();
		}*/
}
