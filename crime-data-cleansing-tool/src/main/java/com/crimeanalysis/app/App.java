package com.crimeanalysis.app;

import java.util.ArrayList;

import com.crimeanalysis.app.beans.CrimeDataRaw;
import com.crimeanalysis.app.beans.CrimeDataSepTSRaw;
import com.crimeanalysis.app.beans.SampleDataRAW;
import com.crimeanalysis.app.processors.Processor;
import com.crimeanalysis.app.util.CrimeDataRawReader;
import com.crimeanalysis.app.util.CrimeDataWriter;

public class App 
{
	public static void main( String[] args )
	{
		//Change in DateConvertor and Processor
		CrimeDataRawReader cdreader=new CrimeDataRawReader();
		CrimeDataWriter writer= new CrimeDataWriter();
		Processor p= new Processor();

	//	ArrayList<CrimeDataRaw> cdRaw=(ArrayList<CrimeDataRaw>) cdreader.readCrimeData("/Users/sagarbendale/Desktop/Project/A-Boston.csv");
		ArrayList<CrimeDataSepTSRaw> cdRaw=(ArrayList<CrimeDataSepTSRaw>) cdreader.readCrimeDataSepTS("/Users/sagarbendale/Desktop/Project/A-LAPD_Crime_and_Collision_Raw_Data_-_2014.csv");
	//	ArrayList<SampleDataRAW> cdRaw=(ArrayList<SampleDataRAW>) cdreader.readSampleData("/Users/sagarbendale/Desktop/Project/S-SanJose$.csv");

	
	//	writer.writeCrimeData(p.processData(cdRaw));
		writer.writeCrimeData(p.processDataSepTS(cdRaw));
	//	writer.writeCrimeData(p.processSampleData(cdRaw));
	}
}