package com.crimeanalysis.app.util;

public class Cleaner 
{
	
	public static String clean(String str)
	{
		str=str.trim();
		str=str.replace("'", "");
		str=str.replace("\"", "");
		str=str.replace("NULL", "");
		str=str.replace("null", "");


		System.out.println(str);
		return str;
		
	}

}
