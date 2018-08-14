package practise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class csv_read_access {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
	
		try {
			String csvFilePath = "C:\\Users\\Vipulsrivastava\\Desktop\\csv_demo.csv";
			String line1 = "";
			br = new BufferedReader(new FileReader(csvFilePath));
			ArrayList[] l = new ArrayList[10];
			HashMap<String, ArrayList> hm = new HashMap<String, ArrayList>();
			br.readLine();
			
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

			for (Map.Entry m : hm.entrySet()) {
				System.out.println(m.getKey() + " " + m.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();

	}
}
