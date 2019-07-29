package com.sntps.acdc.get;

import java.util.List;

import org.testng.annotations.Test;

import com.sntps.acdc.post.JsonCreator;
import com.sntps.acdc.post.TestProperties;
import com.sntps.acdc.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class EarlyProofGet 
{
	static String Html_Markup = null;
	static String Exctracted_Images = null;
	static String Supplements = null;
	public static int Html_Markup_Get = 1;
	
	
	//@Test
	public static void EarlyProofGetCall()
	{
		new JsonCreator();
		
		RestAssured.baseURI = Utility.HTTP_CMS_SERVICES_DEV +  TestProperties.stored;
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("<<<<<<<<<<<<<<<<<<<------------------------- Early Proof Validation ------------------------->>>>>>>>>>>>>>>>>>>>");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("GET Call URL :"+RestAssured.baseURI);
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		/*----------Enrich_Article GET call--------------*/
		Response responseEarlyProof = httpRequest.request(Method.GET, "/early_proof");	
		ResponseBody extractResponseEarlyProof = responseEarlyProof.getBody();
		List<String> stringArrayEarlyProof = extractResponseEarlyProof.jsonPath().get("_links.rel");
		Html_Markup = stringArrayEarlyProof.toString();
		
	}
	
	@Test
	public static void concatenatingAndPrintingEarlyProofRoutes()
	{
		EarlyProofGetCall();
		
		String routesConcatenation = Html_Markup;
		
		Html_Markup_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "html_markup");
		
		System.out.println("Printing Number of files in the GET call :");
		System.out.println();

		System.out.println("There is/are "+Html_Markup_Get+" HTML Markup's in the GET request");
		
	}
}