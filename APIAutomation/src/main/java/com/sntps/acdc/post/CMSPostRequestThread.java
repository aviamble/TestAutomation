package com.sntps.acdc.post;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
//import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sntps.acdc.get.ContentStructuringGetCalls;
import com.sntps.acdc.get.EarlyProofGet;
import com.sntps.acdc.get.EnrichArticleGet;
import com.sntps.acdc.get.MangoPackageGet;
import com.sntps.acdc.get.PackageServiceGetCalls;
import com.sntps.acdc.post.GenericPostRequest;
import com.sntps.acdc.post.PackageServiceUnzipRequest;
import com.sntps.acdc.utils.Utility;
import com.sntps.acdc.validation.ContentStructuringValidation;
import com.sntps.acdc.validation.EarlyProofValidation;
import com.sntps.acdc.validation.EnrichArticleValidation;
import com.sntps.acdc.validation.MangoPackageValidation;
import com.sntps.acdc.validation.PackageServiceValidation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class CMSPostRequestThread implements Runnable 
{
	
	private String route;
	private List<String> files = new ArrayList<>();
	public static String responseJsonInLowerCase = null;


	public String getRoute()
	{
		return route;
	}

	public void setRoute(String route) 
	{
		this.route = route;
	}

	public List<String> getFiles() 
	{
		return files;
	}

	public void setFiles(List<String> files) 
	{
		this.files = files;
	}

	
	/*This method takes the route and input files*/
	public CMSPostRequestThread(String route, List<String> files) 
	{ 
		super();
		this.route = route;
		this.files.addAll(files);
	}

	
	/*Run Method*/
	//@Override
	public void run() 
	{
		for (String zipFileLocation : files) 
		{
			try
			{
				createRequestPkgService(zipFileLocation, route);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	

	/*This method calls two different methods in Json Creator class depending on routes*/
	private void createRequestPkgService(String ZipFileLocation, String route) throws IOException 
	{
		final ObjectMapper jacksonObjectMapper = new ObjectMapper();
			if (null == route) 
				{
					PackageServiceUnzipRequest packageServiceUnzipRequest = JsonCreator.createPackageServiceUnzipRequestJsonFromZip(ZipFileLocation);

					String jsonString = jacksonObjectMapper.writeValueAsString(packageServiceUnzipRequest);

					createExecuteHTTPRequestPackageServicePost(jsonString, ZipFileLocation, packageServiceUnzipRequest.getId());
				} 
			else
				{
				
					GenericPostRequest genericPostRequest = JsonCreator.createGenericPostRequestJsonFromZip(ZipFileLocation,route);

					String jsonString = jacksonObjectMapper.writeValueAsString(genericPostRequest);

					createExecuteHTTPRequestPackageServicePost(jsonString, ZipFileLocation, genericPostRequest.getId(), route);
				}
	}

	
	/*This methods Posts http request and prints the POST URI*/
	public synchronized void createExecuteHTTPRequestPackageServicePost(String responseJson, String filePath, String id, String... args)
			throws ClientProtocolException, IOException 
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost uploadFile = null;
		
		if (args.length > 0)
			{
				uploadFile = new HttpPost(Utility.HTTP_CMS_SERVICES_DEV+id+args[0]);
			}
		else
			{
				uploadFile = new HttpPost(Utility.HTTP_CMS_SERVICES_DEV +id);
			}
		
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("metadata", responseJson, ContentType.TEXT_PLAIN);

		/*This attaches the file to the POST:*/
		File uploadFile1 = new File(filePath);
		builder.addBinaryBody("file", new FileInputStream(uploadFile1), ContentType.APPLICATION_OCTET_STREAM,uploadFile1.getName());

		HttpEntity multipart = builder.build();
		uploadFile.setEntity(multipart);
		
		CloseableHttpResponse response = httpClient.execute(uploadFile);
		
		String inputLine;
		StringBuffer responseBuffer = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		while ((inputLine = reader.readLine()) != null) 
			{
				responseBuffer.append(inputLine);
			}

		reader.close();
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println
		(
			"Request URL :" + uploadFile + "\n"
			+ "Response  Code  :" + response.getStatusLine().getStatusCode()
			+"\n"
			+"POST Call Json :"+responseJson
		);
		
		
		responseJsonInLowerCase=responseJson.toLowerCase();
		
	
		callingMethodsAsPer_Routes();
		
		//httpClient.close();
	}
	
	/*This method calls the different as per routes*/
	public static void callingMethodsAsPer_Routes()
	{
		switch(ApacheMultipartTest.ExpectedRoute)
	{
		 case "null" : 
			 
			 PackageServiceValidation.validatingCountOfFiles();
			 
			 PackageServiceGetCalls.packageServiceGetCalls();
			 
			 break;
			 
		 case "articles" :
			 
			 ContentStructuringValidation.compareFileCountContentStructuring();
			 
			 ContentStructuringGetCalls.concatenatingAndPrintingArticlesRoutes();
			 
			 break ;
	     
		 case "enrich_article" :
			 
			 EnrichArticleValidation.compareFileCountEnrichArticleProof();
			 
			 EnrichArticleGet.EnrichArticleGetCall();
			 
			 break ;

		 case "early_proof" :
			 
			 EarlyProofGet.concatenatingAndPrintingEarlyProofRoutes();
			 
			 EarlyProofValidation.compareFileCountEarlyProof();
			 
			 break ;

		 case "mango_package" :
			 
			 MangoPackageGet.concatenatingAndPrintingMangoPackageRoutes();
			 
			 MangoPackageValidation.compareFileCountMangoPackageProof();
			 
			 break ;

		 case "default":
			    break;
		}
	}
}
