package com.sntps.acdc.post;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class CTTest 
{
	/*Content Structuring Request*/
	@Test
	//(priority=2)
	public static void contentStructuringRequest() throws InterruptedException
	{
		List<String> filesToUpload = new ArrayList<>();
		
		filesToUpload.add("D:\\CS.zip");
		
		ApacheMultipartTest.ExpectedRoute="articles";
	
		Runnable contentStructuringThread = new CMSPostRequestThread("articles", filesToUpload);
	
		/*new Thread(contentStructuringThread, "contentStructuringThread").start();*/
		
		contentStructuringThread.run();
	}
}
