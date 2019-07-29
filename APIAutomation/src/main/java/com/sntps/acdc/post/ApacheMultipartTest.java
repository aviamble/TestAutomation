package com.sntps.acdc.post;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;


public class ApacheMultipartTest
{
	public static String ExpectedRoute=null;
	
	
	/*Package Service Request*/
	@Test
	//(priority=1)
	public void packageServiceRequest() throws InterruptedException
	{
		List<String> filesToUpload = new ArrayList<>();
		
		filesToUpload.add("D:\\HARWBeta150-D-18-60026_11.zip");
	
		ExpectedRoute="null";
		
		Runnable packgeServiceThread = new CMSPostRequestThread(null, filesToUpload);
		
		packgeServiceThread.run();	
	}
	

	/*Mango Package Request*/
	//@Test
	//(priority=5)
	public static void mangoPackageRequest()
	{
		
		List<String> filesToUpload = new ArrayList<>();
		
		filesToUpload.add("D:\\PackagePacker.zip");
		
		ExpectedRoute="mango_package";
	
		Runnable mangoPackageThread = new CMSPostRequestThread("mango_package", filesToUpload);
	
		new Thread(mangoPackageThread, "MangoPackageThread").start();
				
		mangoPackageThread.run();
	}
	
}
