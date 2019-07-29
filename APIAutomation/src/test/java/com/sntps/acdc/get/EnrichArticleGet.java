package com.sntps.acdc.get;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sntps.acdc.post.JsonCreator;
import com.sntps.acdc.post.TestProperties;
import com.sntps.acdc.utils.Utility;
import com.sntps.acdc.validation.EnrichArticleValidation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class EnrichArticleGet 
{
	static String Enrich_Article = null ;
	public static int Enrich_Article_Get = 1;
	public static int Enrich_Article_Get_one = 0;
	
	//@Test
	public static void EnrichArticleGetCall()
	{
		new JsonCreator();
		
		RestAssured.baseURI = Utility.HTTP_CMS_SERVICES_DEV + TestProperties.stored ;
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("<<<<<<<<<<<<<<<<<<<------------------------- Enrich Article Validation ------------------------->>>>>>>>>>>>>>>>>>>>");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("GET Call URL :"+RestAssured.baseURI);
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		/*----------Enrich_Article GET call--------------*/
		Response responseEnrichArticles = httpRequest.request(Method.GET, "/enrich_article");	
		ResponseBody extractResponseEnrichArticles = responseEnrichArticles.getBody();
		List<String> stringArrayArticles = extractResponseEnrichArticles.jsonPath().get("_links.rel");
		Enrich_Article = stringArrayArticles.toString();
		
		concatenatingAndPrintingEnrichArticlesRoutes();

	}
	
	@Test
	public static void concatenatingAndPrintingEnrichArticlesRoutes()
	{
		
		String routesConcatenation = Enrich_Article;
		
		Enrich_Article_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "enrich_article");
		
		System.out.println("Printing Number of files in the GET call :");
		System.out.println();

		System.out.println("There is/are "+Enrich_Article_Get+" Enrich Articles in the GET request");
		
		if(EnrichArticleValidation.Enrich_Article_Post==Enrich_Article_Get)
		{
			System.out.println("The comparison for VAS is true :");;
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	
}
