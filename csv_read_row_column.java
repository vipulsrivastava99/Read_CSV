package practise;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class csv_read_row_column {
public static void main(String[] args) throws IOException  {
	BufferedReader br=null;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Row number :");
	int rowNumber=sc.nextInt();	
	try {
	String csvFilePath="C:\\Users\\Vipulsrivastava\\Desktop\\csv_demo.csv";
	String line1="",line2="";
	 br=new BufferedReader(new FileReader(csvFilePath));
	 line1=br.readLine();
	 for(int i=0;i<rowNumber-1;i++)
		 line2=br.readLine();
	 String columnHeaders[]=line1.split("\t");
	 String rowData[]= line2.split("\t");

	 HashMap<String,String> hm=new HashMap<String,String>();
	 for(int i=0;i<6;i++)
		 hm.put(columnHeaders[i],rowData[i]);
	 for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	br.close();
	
}}
