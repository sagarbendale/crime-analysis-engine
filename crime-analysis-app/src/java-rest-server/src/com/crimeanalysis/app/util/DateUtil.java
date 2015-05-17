package com.crimeanalysis.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class DateUtil
{

	public static Date convert(String dateString)
	{
		Date date=null;
		SimpleDateFormat sdf = null;
		String dd=null;
		String mm=null; 
		String yyyy =null;
	
		
		try
		{
			StringTokenizer st = new StringTokenizer(dateString, "-");
			while(st.hasMoreTokens()) 
			{
				dd = st.nextToken();
				mm = st.nextToken();
				yyyy =st.nextToken();
				System.out.println();
			} 
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			date = sdf.parse(dd + "/" +mm+"/"+yyyy);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return date; 
		
	}
	
	public static Date getCurrentDate()
	{
		
	
		Date date = new Date();

		return date;
	}
}
