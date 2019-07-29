package com.sntps.acdc.post;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class XMLTest 
{
	//public static String ExpectedRoute = null;
	/*VAS Request*/
	@Test
	//(priority=4)
	public static void xmlTransformationRequest()
	{

		List<String> filesToUpload = new ArrayList<>();
		
		filesToUpload.add("D:\\mango.html");
		
		ApacheMultipartTest.ExpectedRoute="early_proof";
	
		Runnable enrichArticleThread = new CMSPostRequestThread("early_proof", filesToUpload);
	
		/*new Thread(enrichArticleThread, "EnrichArticleThread").start();*/
		
		enrichArticleThread.run();
		
	}
}
