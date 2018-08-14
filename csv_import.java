package practise;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class csv_import {
public static void main(String[] args)  {
	BufferedReader br=null;
	int index=0;
	Scanner sc=new Scanner(System.in);
	String columnName=sc.nextLine();	
	try {
	String csvFilePath="C:\\Users\\Vipulsrivastava\\Desktop\\csv_demo.csv";
	String line="";
	 br=new BufferedReader(new FileReader(csvFilePath));
	 line=br.readLine();
	 String w[]=line.split("\t");
		for(String check:w)
		{
		//	check.trim();
			if(check.equals(columnName))
				break;
			
			else index++;
		}
		System.out.println(index);
		
	 while((line=br.readLine())!=null)
	{
		 w=line.split("\t");
		System.out.println(w[index]);
		
	}
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally {
		try {
	br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
}
