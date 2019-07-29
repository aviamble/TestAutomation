package com.sntps.acdc.validation;

import org.testng.Assert;

import com.sntps.acdc.get.ContentStructuringGetCalls;
import com.sntps.acdc.post.ApacheMultipartTest;
import com.sntps.acdc.post.CMSPostRequestThread;

public class ContentStructuringValidation 
{
	
	public static int Structure_Article_Post = 0;
	public static int Extracted_Image_Post = 0;
	
	public static void compareFileCountContentStructuring()
	{
		String lowerCase = CMSPostRequestThread.responseJsonInLowerCase;
		
		Structure_Article_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCase, "structure_article");
	    Extracted_Image_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCase, "extracted_image");		
		
	    
	    System.out.println("Printing Number of files in the POST call for Content Structuring is:");
	    System.out.println();

	    System.out.println("There are "+Structure_Article_Post+" Structure Articles in the POST request");
	    System.out.println("There are "+Extracted_Image_Post+" Extracted Images in the POST request");

	
	}
	
	
}