package com.crimeanalysis.app.processors;

import java.util.ArrayList;

import com.crimeanalysis.app.beans.CrimeData;
import com.crimeanalysis.app.beans.CrimeDataRaw;
import com.crimeanalysis.app.beans.CrimeDataSepTSRaw;
import com.crimeanalysis.app.beans.SampleDataRAW;
import com.crimeanalysis.app.util.Cleaner;
import com.crimeanalysis.app.util.DateConvertor;
import com.crimeanalysis.app.util.RandomCrimeTypeGenerator;

public class Processor
{


	public ArrayList<CrimeData> processData(ArrayList<CrimeDataRaw> cdRaw)
	{
		ArrayList<CrimeData> crimeDataList=new ArrayList<CrimeData>() ;
		CrimeData cddata=null;
		DateConvertor dc=new DateConvertor();

		for(CrimeDataRaw cd: cdRaw)
		{
			
			if(cd.getLat()==null || cd.getCrimeType()==null || cd.getLon()==null || cd.getTimestampOfCrime()==null)
			{
				System.out.println("empty found");
			}
			else if(Cleaner.clean(cd.getLat()).equals("") || Cleaner.clean(cd.getLon()).equals("") || Cleaner.clean(cd.getTimestampOfCrime()).equals("") || Cleaner.clean(cd.getCrimeType()).equals(""))
			{
				System.out.println("empty found");
			}
			else
			{
				cddata=new CrimeData();
				cddata.setCrimeType(cd.getCrimeType());
				cddata.setTimestampOfCrime(dc.stringToDate4(Cleaner.clean(cd.getTimestampOfCrime())));
				cddata.setLat(Double.parseDouble(cd.getLat()));
				cddata.setLon(Double.parseDouble(cd.getLon()));
				crimeDataList.add(cddata);
			}

			
		}
		return crimeDataList;
	}
	
	
	public ArrayList<CrimeData> processDataSepTS(ArrayList<CrimeDataSepTSRaw> cdRaw)
	{
		ArrayList<CrimeData> crimeDataList=new ArrayList<CrimeData>() ;
		CrimeData cddata=null;
		DateConvertor dc=new DateConvertor();

		for(CrimeDataSepTSRaw cd: cdRaw)
		{
			if(cd.getLat()==null ||cd.getLat()=="0" || cd.getCrimeType()==null || cd.getLon()==null || cd.getLon()=="0" || cd.getDateOfCrime()==null || cd.getTimeOfCrime()==null)
			{
				System.out.println("empty found");
			}
			else if(Cleaner.clean(cd.getLat()).equals("") || Cleaner.clean(cd.getLon()).equals("") || Cleaner.clean(cd.getDateOfCrime()).equals("") || Cleaner.clean(cd.getCrimeType()).equals("") || Cleaner.clean(cd.getTimeOfCrime()).equals(""))
			{
				System.out.println("empty found");
			}
			else
			{
			cddata=new CrimeData();
			
			cddata.setCrimeType(cd.getCrimeType());
			cddata.setTimestampOfCrime(dc.stringToDate3(cd.getDateOfCrime(),cd.getTimeOfCrime()));
			cddata.setLat(Double.parseDouble(cd.getLat()));
			cddata.setLon(Double.parseDouble(cd.getLon()));

			crimeDataList.add(cddata);
			}
		}
		return crimeDataList;
	}
	
	public ArrayList<CrimeData> processSampleData(ArrayList<SampleDataRAW> cdRaw)
	{
		ArrayList<CrimeData> crimeDataList=new ArrayList<CrimeData>() ;
		CrimeData cddata=null;
		DateConvertor dc=new DateConvertor();
		RandomCrimeTypeGenerator rg=new RandomCrimeTypeGenerator();

		for(SampleDataRAW cd: cdRaw)
		{
			
			if(cd.getLat()==null ||  cd.getLon()==null || cd.getTimestampOfCrime()==null)
			{
				System.out.println("empty found");
			}
			else if(Cleaner.clean(cd.getLat()).equals("") || Cleaner.clean(cd.getLon()).equals("") || Cleaner.clean(cd.getTimestampOfCrime()).equals(""))
			{
				System.out.println("empty found");
			}
			else
			{
				cddata=new CrimeData();
				cddata.setCrimeType(rg.getRandomCrimeType());
				cddata.setTimestampOfCrime(dc.stringToDate4(Cleaner.clean(cd.getTimestampOfCrime())));
				cddata.setLat(Double.parseDouble(cd.getLat()));
				cddata.setLon(Double.parseDouble(cd.getLon()));
				crimeDataList.add(cddata);
			}

			
		}
		return crimeDataList;
	}
}
