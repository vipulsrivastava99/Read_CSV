package practise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class csv_read_access_column {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Column Name : ");
		String columnName = sc.next();
		int columnIndex=0;
		try {
			String csvFilePath = "C:\\Users\\Vipulsrivastava\\Desktop\\csv_demo.csv";
			String line1 = "";
			br = new BufferedReader(new FileReader(csvFilePath));
			ArrayList[] l = new ArrayList[10];
			HashMap<String, ArrayList> hm = new HashMap<String, ArrayList>();
			line1=br.readLine();
			String columnHeaders[]=line1.split("\t");
		for(int k=0;k<=6;k++)
		{
			if(columnHeaders[k].equalsIgnoreCase(columnName))
			{
				columnIndex=k;
				break;
			}
		}
			while ((line1 = br.readLine()) != null) {
				int i = 0;
				String rowData[] = line1.split("\t");

				if (rowData[0].equalsIgnoreCase("yes")) {
					l[i] = new ArrayList();
					for (int j = 2; j <= 6; j++)
						l[i].add(rowData[j]);
					hm.put(rowData[1], l[i]);
				}
				i++;
			}

			/*for (Map.Entry m : hm.entrySet()) {
				if(columnIndex==1)
					System.out.println(m.getKey());
				else {
			String listValues[]=m.getValue().toString().split(",");
			System.out.println(listValues[columnIndex-2]);
				}
				}
				
		*/for (Map.Entry m : hm.entrySet()) {
			if(columnIndex==1)
				System.out.println(m.getKey());
			else {
		System.out.println(((ArrayList)(m.getValue())).get(columnIndex-2));
			}
		}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();

	}
}
