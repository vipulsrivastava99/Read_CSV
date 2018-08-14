package com.qait.advancetatoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before Class Executed");
	}
	@Test(dataProvider="dataMethod")
	public void testMethod(String...p1)
	{
		int k;
		Scanner sc=new Scanner(System.in);
		String columnName=sc.nextLine();
		String columnHeaders[]=p1[0].split("\t");
		for(k=0;k<=6;k++)
		{
			if(columnHeaders[k].equalsIgnoreCase(columnName))
				break;
		}
		System.out.println("The parameters are ");
		  for(String s:p1)
		  {  
			  if(s!=null)
				  if(s.contains("yes"))
				  {
					  String rowData[]=s.split("\t");
					  System.out.println(rowData[k]);  
					  	  
				  }
				
		  }  
		
	}
	@DataProvider
	public Object[][] dataMethod() throws InterruptedException
	{
		Object[][] returnObject;
		String[] checkPoint=ReadfromCSV();
	//	returnObject = new Object[][]{checkPoint };
		 //  return new Object[][] { { "one" }, { "two" } };
		//returnObject = ReadfromCSV();
		returnObject = new Object[][]{checkPoint };
        return returnObject;
	}
		
	 public String[] ReadfromCSV() throws InterruptedException {


         String[] data= null;
         String csvFile = "C:\\\\Users\\\\Vipulsrivastava\\\\Desktop\\\\csv_demo.csv";
         BufferedReader br = null;
         String line[] = new String[10];
         try {

             br = new BufferedReader(new FileReader(csvFile));
             int k=0;
             while ((line[k++] = br.readLine()) != null) {
             }

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (br != null) {
                 try {
                     br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
         	return line;

     }
	
}
