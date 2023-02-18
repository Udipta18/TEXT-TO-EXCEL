package com.Excel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextOperation {

	ExcelOperation excelOperation = new ExcelOperation();
	 Boolean isIns=false;
	public void operation() throws FileNotFoundException {
		String path = "C:\\Users\\dasud\\Documents\\ta.txt";

		StringBuilder resultStringBuilder = new StringBuilder();
		// Try block to check for exceptions
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Declaring a new string
			String str;

			String flag = null;
           
			List<Object> li = new ArrayList<>();

			// It holds true till threre is content in file
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				if (str.length() > 0 && str.charAt(str.length() - 1) == '{') {
					String name = maupultaeString(str);
					if(isIns==false)
					flag = name + ".class";
					else
					 flag=name+".instruction";
				} else if (str.length() > 0 && str.contains("}")) {

				}

				else if (!str.equalsIgnoreCase(" ") && !str.isBlank() && str.length() > 0) {
					putDataInMap(str, li, flag);
				}

			}

			excelOperation.print(li);
		}

		// Catch block to handle the exceptions
		catch (IOException e) {

			// Display pop up message if exceptionn occurs
			System.out.println("Error while reading a file.");
		}
	}

	private  String maupultaeString(String str) {
		String[] split = str.split(" ");
		
		if(split[0].equalsIgnoreCase("instruction")) {
			isIns=true;
		}
		
		String string = split[1];
		return string.substring(0, string.length() - 1);
	}

	private static void putDataInMap(String str, List<Object> li, String flag) {
		String[] split = str.split(" ");
		String attribute = split[3];
		String datatype = split[5];
		String description=null;
		
		if(attribute.equalsIgnoreCase("#overLoad#")) {
			attribute=split[4]+"*";
			datatype=split[6];
			StringBuilder sb=new StringBuilder();
			for(int i=8;i<=split.length-1;i++) {
				sb.append(split[i]+" ");
			}
			
			description=sb.toString();
		}

		li.add(new Object(attribute,flag,datatype,description));
	}
}
