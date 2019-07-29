package com.sntps.acdc.post;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import org.testng.annotations.Test;

import com.sntps.acdc.utils.Utility;

public class TestProperties
{
	static String str ;
	public static String stored ;
	@Test
	public static String test()throws Exception{  
		 writingStringToFile();
		
		FileReader reader=new FileReader("src\\test.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader); 
	   
	   System.out.println(p.getProperty("Random")); 
	   
	   stored = p.getProperty("Random");
	   
	   System.out.println("The stored value is :"+stored);
	   return stored;
	 
	}  
	
	public static void writingStringToFile() 
			  throws IOException {
		
				str=Utility.generateRandom();
			    FileWriter fileWriter = new FileWriter("src\\test.properties");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print("Random="+str);
			    printWriter.close();
			}
	
}

