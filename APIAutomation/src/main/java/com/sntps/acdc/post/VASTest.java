package com.sntps.acdc.post;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class VASTest 
{
	//public static String ExpectedRoute = null;
	/*VAS Request*/
	@Test
	//(priority=3)
	public static void vasRequest()
	{
		List<String> filesToUpload = new ArrayList<>();
		
		filesToUpload.add("D:\\mango.xml");
		
		ApacheMultipartTest.ExpectedRoute="enrich_article";
		
		Runnable VASThread = new CMSPostRequestThread("enrich_article", filesToUpload);
		
		/*new Thread(VASThread, "VASThread").start();*/
		
		VASThread.run();
		
	}
}
