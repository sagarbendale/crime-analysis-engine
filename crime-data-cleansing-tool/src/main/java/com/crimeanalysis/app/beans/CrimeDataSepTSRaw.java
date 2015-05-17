package com.crimeanalysis.app.beans;

public class CrimeDataSepTSRaw
{

	private String crimeType;
	private String timeOfCrime;
	private String dateOfCrime;
	private String lat;
	private String lon;

	public String getCrimeType()
	{
		return crimeType;
	}
	public void setCrimeType(String crimeType)
	{
		this.crimeType = crimeType;
	}
	public String getTimeOfCrime()
	{
		return timeOfCrime;
	}
	public void setTimeOfCrime(String timeOfCrime)
	{
		this.timeOfCrime = timeOfCrime;
	}
	public String getDateOfCrime()
	{
		return dateOfCrime;
	}
	public void setDateOfCrime(String dateOfCrime)
	{
		this.dateOfCrime = dateOfCrime;
	}
	public String getLat()
	{
		return lat;
	}
	public void setLat(String lat)
	{
		this.lat = lat;
	}
	public String getLon()
	{
		return lon;
	}
	public void setLon(String lon)
	{
		this.lon = lon;
	}
	
}
