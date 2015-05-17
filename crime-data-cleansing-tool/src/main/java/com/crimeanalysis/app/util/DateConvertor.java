package com.crimeanalysis.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConvertor {

	public Date stringToDate(String stringDate)
	{
		Date date=null;
		try 
		{
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(stringDate);
		} 
		catch (ParseException e) 
		{
			
		}
		System.out.println(date);
		return date;
	}

	public Date stringToDate2(String stringDate)
	{
		Date date=null;
		try 
		{
			date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.ENGLISH).parse(stringDate);
		} 
		catch (ParseException e) 
		{
			date=stringToDate4(stringDate);
		}
		System.out.println(date);
		return date;
	}

	public Date stringToDate3(String stringDate, String timeStamp)
	{
		Date date=null;
		try 
		{
			if(timeStamp.length()==4)
			date = new SimpleDateFormat("MM/dd/yyyy'T'HHmm", Locale.ENGLISH).parse(stringDate+"T"+timeStamp);
			else if(timeStamp.length()==3)
				date = new SimpleDateFormat("MM/dd/yyyy'T'HHmm", Locale.ENGLISH).parse(stringDate+"T0"+timeStamp);
			else if(timeStamp.length()==2)
				date = new SimpleDateFormat("MM/dd/yyyy'T'HHmm", Locale.ENGLISH).parse(stringDate+"T00"+timeStamp);
			else
				date = new SimpleDateFormat("MM/dd/yyyy'T'HHmm", Locale.ENGLISH).parse(stringDate+"T000"+timeStamp);


		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(date);
		return date;


	}

	public Date stringToDate4(String stringDate)
	{
		Date date=null;

		try 
		{	

			date = new SimpleDateFormat("MM/dd/yy HH:mm", Locale.ENGLISH).parse(stringDate);
		} catch (ParseException e) 
		{
			e.printStackTrace();

	//		date=stringToDate5(stringDate);
		}
		finally
		{
			System.out.println("Original Date "+stringDate+"    Parsed Date"+date);

		}
		return date;


	}

	public Date stringToDate5(String stringDate)
	{
		Date date=null;
		try 
		{	

			date = new SimpleDateFormat("MM/dd/yy HH:mm:ss", Locale.ENGLISH).parse(stringDate);
		} catch (ParseException e) 
		{
			date=stringToDate6(stringDate);

		}
		finally
		{
			System.out.println("Original Date "+stringDate+"    Parsed Date"+date);

		}
		return date;


	}
	public Date stringToDate6(String stringDate)
	{
		Date date=null;
		try 
		{	

			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(date);
		return date;
	}

	public Date stringToDate7(String stringDate, String timeStamp)
	{
		Date date=null;
		try 
		{
			date = new SimpleDateFormat("MM/dd/yy'T'HH:mm:ss", Locale.ENGLISH).parse(stringDate+"T"+timeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(date);
		return date;
	}
	
	public Date stringToDate8(String stringDate, String timeStamp)
	{
		Date date=null;
		try 
		{
			date = new SimpleDateFormat("MM/dd/yy'T'HH:mm", Locale.ENGLISH).parse(stringDate+"T"+timeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(date);
		return date;
	}
}
