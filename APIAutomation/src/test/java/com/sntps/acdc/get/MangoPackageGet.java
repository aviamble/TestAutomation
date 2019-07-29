package com.sntps.acdc.get;

import java.util.List;

import org.testng.annotations.Test;

import com.sntps.acdc.post.JsonCreator;
import com.sntps.acdc.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class MangoPackageGet 
{
	static String Out_Go_Xml = null ;
	static String Out_Zip = null ;

	public static int Out_Go_Xml_Get = 0 ;
	public static int Out_Zip_Get = 0 ;
	
	static String Exctracted_Images = null;
	static String Supplements = null;
	
	
	//@Test
	public static void MangoPackageGetCall()
	{
		new JsonCreator();
		
		RestAssured.baseURI = Utility.HTTP_CMS_SERVICES_DEV +  Utility.postCallRandomGenerator ;
		
		
		System.out.println("GET Call URL :"+RestAssured.baseURI);
		
		RequestSpecification httpRequest = RestAssured.given();
		
		/*----------Enrich_Article GET call--------------*/
		Response responseOutGoXml = httpRequest.request(Method.GET, "/mango_package");	
		ResponseBody extractResponseresponseOutGoXml = responseOutGoXml.getBody();
		List<String> stringArrayOutGoXml = extractResponseresponseOutGoXml.jsonPath().get("_links.rel");
		Out_Go_Xml = stringArrayOutGoXml.toString();
	}
	
	@Test
	public static void concatenatingAndPrintingMangoPackageRoutes()
	{
		MangoPackageGetCall();
		
		String routesConcatenation = Out_Zip+Out_Go_Xml;
		
		Out_Go_Xml_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "mango_package");
		/*Out_Zip_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "mango_package");*/
		
	}
}
