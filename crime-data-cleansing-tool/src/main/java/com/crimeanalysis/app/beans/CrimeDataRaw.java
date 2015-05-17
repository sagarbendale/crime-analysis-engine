package com.crimeanalysis.app.beans;

public class CrimeDataRaw
{

	private String crimeType;
	private String timestampOfCrime;
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
	public String getTimestampOfCrime()
	{
		return timestampOfCrime;
	}
	public void setTimestampOfCrime(String timestampOfCrime)
	{
		this.timestampOfCrime = timestampOfCrime;
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
