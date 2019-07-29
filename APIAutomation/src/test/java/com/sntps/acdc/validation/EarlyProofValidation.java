package com.sntps.acdc.validation;

import org.testng.Assert;

import com.sntps.acdc.get.ContentStructuringGetCalls;
import com.sntps.acdc.get.EarlyProofGet;
import com.sntps.acdc.get.EnrichArticleGet;
import com.sntps.acdc.post.ApacheMultipartTest;
import com.sntps.acdc.post.CMSPostRequestThread;

public class EarlyProofValidation 
{
	public static void compareFileCountEarlyProof()
	{
		String lowerCase = CMSPostRequestThread.responseJsonInLowerCase;
		
		int Html_Markup_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCase, "html_markup");	
		
		System.out.println("Printing Number of files in the POST call for Early Proof is:");
		System.out.println();

		System.out.println("There are "+Html_Markup_Post+" Html Markup in the POST request");	
		
		if(Html_Markup_Post==EarlyProofGet.Html_Markup_Get)
		{
			System.out.println("The comparison for XML Transformation is true :");;
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
