package com.sntps.acdc.get;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.apache.commons.exec.util.StringUtils;
import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;

import com.sntps.acdc.post.CMSPostRequestThread;
import com.sntps.acdc.post.JsonCreator;
import com.sntps.acdc.post.TestProperties;
import com.sntps.acdc.utils.Utility;
import com.sntps.acdc.validation.PackageServiceValidation;

import java.io.*;

public class PackageServiceGetCalls 
{
	public static int countget=0;
	public static int Manuscript_Get = 0;
	public static int Supplement_Get= 0;
	public static int  Metadata_Get = 0;
	public static int Import_Get = 0;
	public static int Go_Get = 0;
	static String Manuscripts = null;
	static String Supplementary = null;
	static String Metadata = null;
	static String Go = null;
	static String Import = null;
	public static HashMap<Integer, String> hash_map_get = new HashMap<Integer, String>();
	
	/*Stores respective route URI's into different strings*/	
	//@Test
	public static void earlyProofGet()
	{
		new JsonCreator();
		
		RestAssured.baseURI = Utility.HTTP_CMS_SERVICES_DEV +  TestProperties.stored;
		
		System.out.println("Package Service GET Call URL :"+RestAssured.baseURI);
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		
		/*----------Manuscript GET call--------------*/
		Response responseManuscript = httpRequest.request(Method.GET, "/manuscripts");
			
		ResponseBody extractResponseManuscript = responseManuscript.getBody();
		
		List<String> stringArrayManuscript = extractResponseManuscript.jsonPath().get("_links.rel");
		
		Manuscripts = stringArrayManuscript.toString();
		
		
		/*----------Supplements GET call--------------*/
		Response responseSupplements = httpRequest.request(Method.GET, "/supplements");
		
		ResponseBody extractResponseSupplements = responseSupplements.getBody();
	
		List<String> stringArraySupplements = extractResponseSupplements.jsonPath().get("_links.rel");
	
		Supplementary = stringArraySupplements.toString();
		
		
		/*----------import_xml GET call--------------*/
		Response responseImport = httpRequest.request(Method.GET, "/import_xml");
		
		ResponseBody extractResponseImport = responseImport.getBody();
	
		List<String> stringArrayImport = extractResponseImport.jsonPath().get("_links.rel");
	
		Import = stringArrayImport.toString();
		
		//System.out.println("import_xml GET call :"+Import);
		
		
		/*----------go_xml GET call--------------*/
		Response responseGo = httpRequest.request(Method.GET, "/go_xml");
		
		ResponseBody extractResponseGo = responseGo.getBody();
	
		List<String> stringArrayGo = extractResponseGo.jsonPath().get("_links.rel");
	
		Go = stringArrayGo.toString();
		
		
		/*----------metadata_xml GET call--------------*/
		Response responseMetadata = httpRequest.request(Method.GET, "/metadata_xml");
		
		ResponseBody extractResponseMetadata = responseMetadata.getBody();
	
		List<String> stringArrayMetadata = extractResponseMetadata.jsonPath().get("_links.rel");
	
		Metadata = stringArrayMetadata.toString();
	}
	
	
	/*Counts individual files inside input package*/
	//@Test
	public static void packageServiceGetCalls()
	{
		earlyProofGet();
		
		String routesConcatenation = Supplementary+Manuscripts+Metadata+Go+Import;
		routesConcatenation=routesConcatenation.replace("manuscript_id", "");
		
		Manuscript_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "manuscript");
		Supplement_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "supplement");
		Import_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "import_xml");
		Go_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "go_xml");
		Metadata_Get = org.apache.commons.lang3.StringUtils.countMatches(routesConcatenation, "metadata_xml");
		
		System.out.println();
		System.out.println("Printing Number of files in the GET call :");
		System.out.println();
		System.out.println("There are "+Manuscript_Get+" Manuscripts in the GET request");
		System.out.println("There are "+Supplement_Get+" Supplements in the GET request");
		System.out.println("There is "+Import_Get+" import_xml in the GET request");
		System.out.println("There is "+Go_Get+" go_xml in the GET request");
		System.out.println("There is "+Metadata_Get+" metadata_xml in the GET request");
		System.out.println();
		
	
		if(PackageServiceValidation.Manuscript_Post==PackageServiceGetCalls.Manuscript_Get &&
				PackageServiceValidation.Supplement_Post==PackageServiceGetCalls.Supplement_Get &&
						PackageServiceValidation.Import_Post==PackageServiceGetCalls.Import_Get &&
								PackageServiceValidation.Go_Post==PackageServiceGetCalls.Go_Get	&&
										PackageServiceValidation.Metadata_Post==PackageServiceGetCalls.Metadata_Get)
				{	
					System.out.println();
					System.out.println("CMS for Package Service is working as expected :");
					System.out.println();
					
				}
				else
					{
						
						System.out.println("CMS has developed a bug and needs debugging");
						Assert.assertTrue(false);
					}
	}
}


