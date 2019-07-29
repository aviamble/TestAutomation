package com.sntps.acdc.get;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sntps.acdc.post.JsonCreator;
import com.sntps.acdc.post.TestProperties;
import com.sntps.acdc.utils.Utility;
import com.sntps.acdc.validation.ContentStructuringValidation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ContentStructuringGetCalls 
{
	static String Structure_Article = null;
	static String Extracted_Image = null;
	static String Articles = null;
	public static int Structure_Article_Get = 0;
	public static int Extracted_Image_Get = 0;
	
	
	//@Test
	public static void articlesGetCalls()
	{
		new JsonCreator();
		
		RestAssured.baseURI = Utility.HTTP_CMS_SERVICES_DEV + TestProperties.stored + "/articles";
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("<<<<<<<<<<<<<<<<<<<------------------------- Content Structuring Validation ------------------------->>>>>>>>>>>>>>>>>>>>");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("GET Call URL :"+RestAssured.baseURI);
		System.out.println();
		
		RequestSpecification httpRequest = RestAssured.given();
		
		/*----------Manuscript GET call--------------*/
		Response responseArticles = httpRequest.request(Method.GET, "/structure_article");	
		ResponseBody extractResponseArticles = responseArticles.getBody();
		List<String> stringArrayArticles = extractResponseArticles.jsonPath().get("_links.rel");
		Structure_Article = stringArrayArticles.toString();
		
		/*----------Supplements GET call--------------*/
		Response responseExtractedImage = httpRequest.request(Method.GET, "/extracted_images");
		ResponseBody extractResponseExtractedImage = responseExtractedImage.getBody();	
		List<String> stringArrayExtractedImage = extractResponseExtractedImage.jsonPath().get("_links.rel");
		Extracted_Image = stringArrayExtractedImage.toString();
	}
	
	@Test
	public static void concatenatingAndPrintingArticlesRoutes()
	{
		articlesGetCalls();
		
		String routesConcatenation = Structure_Article+Extracted_Image;
		
		Structure_Article_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "structure_article");
		Extracted_Image_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "extracted_image");
		
		System.out.println("Printing Number of files in the GET call :");
		System.out.println();

		System.out.println("There is/are "+Structure_Article_Get+" Structure Articles in the GET request");
		System.out.println("There is/are "+Extracted_Image_Get+" Extracted Images in the GET request");
		System.out.println();
		
		
		if(ContentStructuringValidation.Structure_Article_Post==Structure_Article_Get &&
				ContentStructuringValidation.Extracted_Image_Post==Extracted_Image_Get )
				{
					;
				}
				else
				{
					Assert.assertTrue(false);
				}
		
	}
}