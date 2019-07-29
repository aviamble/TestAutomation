package com.sntps.acdc.validation;

import org.testng.Assert;

import com.sntps.acdc.get.ContentStructuringGetCalls;
import com.sntps.acdc.get.EnrichArticleGet;
import com.sntps.acdc.get.PackageServiceGetCalls;
import com.sntps.acdc.post.ApacheMultipartTest;
import com.sntps.acdc.post.CMSPostRequestThread;

public class EnrichArticleValidation 
{
	public static int Enrich_Article_Post = 0 ;
	
	public static void compareFileCountEnrichArticleProof()
	{
		
		
		String lowerCase = CMSPostRequestThread.responseJsonInLowerCase;
		
		Enrich_Article_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCase, "enrich_article");
		
		System.out.println("Printing Number of files in the POST call for Content Structuring is:");
		System.out.println();

		System.out.println("There are "+Enrich_Article_Post+" Enrich Articles in the POST request");
	   		
	}
}
