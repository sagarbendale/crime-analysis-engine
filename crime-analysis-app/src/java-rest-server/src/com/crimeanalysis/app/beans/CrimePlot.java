package com.crimeanalysis.app.beans;

public class CrimePlot
{
	@Override
	public String toString()
	{
		return "CrimePlot [crimeType=" + crimeType + ", lat=" + lat + ", lon=" + lon + ", timeStamp=" + timeStamp + "]";
	}
	private String crimeType;
	private String lat;
	private String lon;
	private String timeStamp;
	public String getCrimeType()
	{
		return crimeType;
	}
	public void setCrimeType(String crimeType)
	{
		this.crimeType = crimeType;
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
	public String getTimeStamp()
	{
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	
}
