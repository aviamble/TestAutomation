package com.sntps.acdc.validation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.LogStatus;
import com.sntps.acdc.get.PackageServiceGetCalls;
import com.sntps.acdc.post.ApacheMultipartTest;
import com.sntps.acdc.post.CMSPostRequestThread;
import com.sntps.acdc.utils.Utility;

public class PackageServiceValidation 
{
	static String status = "null";
	
	public static int Manuscript_Post = 0;
	public static int Supplement_Post= 0;
	public static int  Import_Post = 0;
	public static int Go_Post = 0;
	public static int Metadata_Post = 0;
	
	@SuppressWarnings("deprecation")
	public static void validatingCountOfFiles()
	{
		/*Comparision code*/
		String lowerCasePackageService = CMSPostRequestThread.responseJsonInLowerCase;
		lowerCasePackageService=lowerCasePackageService.replace("manuscript_id", "");
		
		/*Counting Number Of Different Files*/
		Manuscript_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCasePackageService, "manuscript");
		Supplement_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCasePackageService, "supplement");
		Import_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCasePackageService, "import_xml");
		Go_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCasePackageService, "go_xml");
		Metadata_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCasePackageService, "metadata_xml");

	
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("<<<<<<<<<<<<<<<<<<<------------------------- Package Service Validation ------------------------->>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println();

		
		System.out.println("Printing Number of files in the POST call :");
		System.out.println();

		
		/*Printing Number Of Different Files*/
		System.out.println("There are "+Manuscript_Post+" Manuscripts in the POST request");
		System.out.println("There are "+Supplement_Post+" Supplements in the POST request");
		System.out.println("There is "+Import_Post+" import_xml in the POST request");
		System.out.println("There is "+Go_Post+" go_xml in the POST request");
		System.out.println("There is "+Metadata_Post+" metadata_xml in the POST request");
		
	}
	
}






































