package com.crimeanalysis.app.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.crimeanalysis.app.beans.CrimeDataRaw;
import com.crimeanalysis.app.beans.CrimeDataSepTSRaw;
import com.crimeanalysis.app.beans.SampleDataRAW;

public class CrimeDataRawReader
{
	
	public List<CrimeDataRaw> readCrimeData(String filename)
	{
		CSVReader reader=null;
		List list=null;
		CsvToBean csv=null;
		ColumnPositionMappingStrategy strat=null;
		try
		{
			reader = new CSVReader(new FileReader(filename));
			strat = new ColumnPositionMappingStrategy();
			strat.setType(CrimeDataRaw.class);
			String[] columns = new String[] {"crimeType", "timestampOfCrime", "lat","lon"}; 
			strat.setColumnMapping(columns);
			csv = new CsvToBean();
			list = csv.parse(strat, reader);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CrimeDataSepTSRaw> readCrimeDataSepTS(String filename)
	{
		CSVReader reader=null;
		List list=null;
		CsvToBean csv=null;
		ColumnPositionMappingStrategy strat=null;
		try
		{
			reader = new CSVReader(new FileReader(filename));
			strat = new ColumnPositionMappingStrategy();
			strat.setType(CrimeDataSepTSRaw.class);
			String[] columns = new String[] {"crimeType","dateOfCrime","timeOfCrime", "lat","lon"}; 
			strat.setColumnMapping(columns);
			csv = new CsvToBean();
			list = csv.parse(strat, reader);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SampleDataRAW> readSampleData(String filename)
	{
		CSVReader reader=null;
		List list=null;
		CsvToBean csv=null;
		ColumnPositionMappingStrategy strat=null;
		try
		{
			reader = new CSVReader(new FileReader(filename));
			strat = new ColumnPositionMappingStrategy();
			strat.setType(SampleDataRAW.class);
			String[] columns = new String[] {"timestampOfCrime", "lat","lon"}; 
			strat.setColumnMapping(columns);
			csv = new CsvToBean();
			list = csv.parse(strat, reader);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
