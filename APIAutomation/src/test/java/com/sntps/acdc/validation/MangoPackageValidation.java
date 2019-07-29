package com.sntps.acdc.validation;

import com.sntps.acdc.get.EarlyProofGet;
import com.sntps.acdc.get.MangoPackageGet;
import com.sntps.acdc.post.CMSPostRequestThread;

public class MangoPackageValidation 
{
	public static void compareFileCountMangoPackageProof()
	{
		String lowerCase = CMSPostRequestThread.responseJsonInLowerCase;
		
		int Out_Zip_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCase, "out_zip");
		int Out_Go_Xml_Post = org.apache.commons.lang3.StringUtils.countMatches(lowerCase, "out_go_xml");
		
		int Out_Go = Out_Go_Xml_Post + Out_Zip_Post;
	    
	    MangoPackageGet.MangoPackageGetCall();
		
		if(Out_Go==MangoPackageGet.Out_Go_Xml_Get)
		{
			System.out.println();
			System.out.println("*****************************CMS is working as expected***********************************");
			System.out.println();
		}
		else
			System.out.println("CMS has developed a bug and needs debugging");
	}
}
