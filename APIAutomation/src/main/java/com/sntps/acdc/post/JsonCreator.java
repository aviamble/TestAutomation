package com.sntps.acdc.post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.monitor.FileEntry;
import org.sat4j.pb.PseudoOptDecorator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sntps.acdc.post.FileMetadata;
import com.sntps.acdc.post.GenericPostRequest;
import com.sntps.acdc.post.PackageServiceUnzipRequest;
import com.sntps.acdc.utils.Utility;

public class JsonCreator 
{

	public static String myValue = null;

	public static PackageServiceUnzipRequest createPackageServiceUnzipRequestJsonFromZip(String filePath)throws IOException 
	{
		ZipInputStream zipInputStream = null;
		
		try 
		  {
			File zipFile = new File(filePath);
			zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			List<FileMetadata> fileList = new ArrayList<>();

			while (null != zipEntry) 
			{
				String fileName = zipEntry.getName();
				FileMetadata fileMetadata = new FileMetadata();
				fileMetadata.setFileName(fileName);
				switch(ApacheMultipartTest.ExpectedRoute)
				{	
					case "null":
					fileMetadata.setFileType(fileName.contains("go") ? "go_xml"
										: fileName.contains("Import") ? "import_xml"
										: fileName.contains(".xml") ? "metadata_xml" 
										: fileName.contains(".pdf") ? "supplement"
										: "manuscript");
					break;
					
					case "articles":
					
					fileMetadata.setFileType(fileName.contains(".jpeg") ? "extracted_image"
										: "structure_article");
					break;
					
					case "enrich_article":
					
						fileMetadata.setFileType(fileName.contains(".xml") ? "enrich_article"
											: "enrich_article");
						break;
						
					case "early_proof":
						
						fileMetadata.setFileType(fileName.contains(".html") ? "html_markup"
											: "html_markup");
						break;
					
					case "default":
						System.out.println("Invalid Route Entered");
				}
					fileList.add(fileMetadata);
				zipEntry = zipInputStream.getNextEntry();
			}

			PackageServiceUnzipRequest packageServiceUnzipRequest = new PackageServiceUnzipRequest();
			packageServiceUnzipRequest.setFiles(fileList);
			try {
				packageServiceUnzipRequest.setId(TestProperties.test());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//packageServiceUnzipRequest.setId(Utility.generateRandom());
			packageServiceUnzipRequest.setJournalId(1);
			packageServiceUnzipRequest.setManuscriptId("1");
			packageServiceUnzipRequest.setRevision(0);

			return packageServiceUnzipRequest;
		  }

		finally 
		{
			if (null != zipInputStream)
				zipInputStream.close();
		}
	}

	public static GenericPostRequest createGenericPostRequestJsonFromZip(String filePath, String route)throws IOException 
	{
		List<FileMetadata> fileList = new ArrayList<>();
		GenericPostRequest genericPostRequest = new GenericPostRequest();
		ZipInputStream zipInputStream = null;

		try {
			File file = new File(filePath);
				if ("mango_package".equals(route) || "articles".equals(route) || "enrich_article".equals(route) ||
					"early_proof".equals(route))
			
					{		
							if(file.getName().endsWith(".zip"))
								{
									zipInputStream = new ZipInputStream(new FileInputStream(file));
									ZipEntry zipEntry = zipInputStream.getNextEntry();
					
										while (null != zipEntry) 
											{
												String fileName = zipEntry.getName();
												FileMetadata fileMetadata = new FileMetadata();
												fileMetadata.setFileName(fileName);
												fileMetadata.setFileType(getFileTypeBasedOnRoute(fileName, route));
												fileList.add(fileMetadata);
												genericPostRequest.setId(TestProperties.stored+"/");
												//genericPostRequest.setId(Utility.generateRandom()+"/");
												zipEntry = zipInputStream.getNextEntry();
											}
												zipEntry = zipInputStream.getNextEntry();
								}	
							
							else
							   {
								FileMetadata fileMetadata = new FileMetadata();
								//File file = new File(filePath);
								fileMetadata.setFileName(file.getName());
								fileMetadata.setFileType(getFileTypeBasedOnRoute(file.getName(), route));
								fileList.add(fileMetadata);
								String fileNmae = file.getName();
								genericPostRequest.setId(TestProperties.stored+"/");
								//genericPostRequest.setId(Utility.generateRandom()+"/");
							   }
					
							PackageServiceUnzipRequest packageServiceUnzipRequest = new PackageServiceUnzipRequest();
							packageServiceUnzipRequest.setId(TestProperties.stored);
					
					} 
			
			genericPostRequest.setFiles(fileList);
			return genericPostRequest;
		} 
		finally
		{
			if (null != zipInputStream)
				zipInputStream.close();
		}
		// return genericPostRequest;
	}

	
	/*This method assigns the file type to the input files as per their extensions*/ 
	private static String getFileTypeBasedOnRoute(String fileName, String route) 
	{
		if (route.equals("articles")) 
		{
			return fileName.contains(".jpeg") || fileName.contains(".png") || fileName.contains(".tiff") ? "extracted_image"
					: fileName.contains(".xml") ? "structure_article" : "";
		} 
		
		else if (route.equals("enrich_article"))
		{
			return fileName.contains(".xml") ? "enrich_article" : "";
		}
		
		else if (route.equals("early_proof"))
		{
			return "html_markup";
		}
		
		else if (route.equals("mango_package"))
		{
			return fileName.contains(".zip") ? "out_zip" : fileName.contains(".xml") ? "out_go_xml" : "";
		}
		
		else
		{
			throw new RuntimeException("invalid route");
		}

	}

}