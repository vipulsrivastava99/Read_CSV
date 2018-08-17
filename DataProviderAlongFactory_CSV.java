

package com.qait.advancetatoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

 public class DataProviderAlongFactory_CSV {
	static HashMap<String, ArrayList> hm = new HashMap<String, ArrayList>();
	String caseID;
	static int columnIndex;
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before Class Executed");
	}
	
	@Factory(dataProvider = "dataMethod")
	public DataProviderAlongFactory_CSV(String caseID)
	{
		this.caseID=caseID;
	}
	
	@Test
	public void testMethod()
	{
	System.out.println((hm.get(caseID)).get(columnIndex));
	}  
		

	@DataProvider
	public Iterator<Object[]> dataMethod() throws InterruptedException, IOException
	{
//storing object array in each list element	
		List<Object[]> returnObject=new ArrayList<Object[]>();
	//storing case ids in checkpoint array
		String checkPoint[]=ReadfromCSV();
		for(int i=0;i<checkPoint.length;i++) {
			returnObject.add(new Object[] {checkPoint[i]});
		}
         return returnObject.iterator();
         
	}
		
	 public String[] ReadfromCSV() throws InterruptedException, IOException {
			BufferedReader br = null;
			Scanner sc = new Scanner(System.in);
//taking input column name from user to print that column
			System.out.println("Enter Column Name : ");
			String columnName = sc.next();
			
			//array containing the case ids with access =yes	
			String CaseIDColumn[]=new String[4];
			try {
				String csvFilePath = "C:\\Users\\Vipulsrivastava\\Desktop\\csv_demo.csv";
				String line1 = "";
				br = new BufferedReader(new FileReader(csvFilePath));
				
				//array list store the row data as value in map
				ArrayList[] l = new ArrayList[10];
				line1=br.readLine();
				String columnHeaders[]=line1.split("\t");
			//finding the index of column entered by user
				for(int p=0;p<=7;p++)
			{
				if(columnHeaders[p].equalsIgnoreCase(columnName))
				{
					columnIndex=p-2;
					break;
				}
			}
				int k=0;
	

				while ((line1 = br.readLine()) != null) 
				{
					int i = 0;
					String rowData[] = line1.split("\t");
//only if the access column is yes
					if (rowData[1].equalsIgnoreCase("yes")) 
					{ 
						
						l[i] = new ArrayList();
						for (int j = 2; j <= 7; j++)
								l[i].add(rowData[j]);
	//rowdata[0] contains case ids 
		//storing caseIds as keys and list objects as values
						hm.put(rowData[0], l[i]);
				//storing case ids in array with access =yes
						CaseIDColumn[k++]=rowData[0];
					}
					i++;
				}}
				catch (IOException e) {
					e.printStackTrace();
				}
				br.close();
				
				return  CaseIDColumn;
     }
	
}
