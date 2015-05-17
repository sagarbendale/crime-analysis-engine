package com.crimeanalysis.app.beans;

import java.util.Date;

public class CrimeData
{

	
	private String crimeType;
	private Date timestampOfCrime;
	private double lat;
	private double lon;
	public String getCrimeType()
	{
		return crimeType;
	}
	public void setCrimeType(String crimeType)
	{
		this.crimeType = crimeType;
	}
	public Date getTimestampOfCrime()
	{
		return timestampOfCrime;
	}
	public void setTimestampOfCrime(Date timestampOfCrime)
	{
		this.timestampOfCrime = timestampOfCrime;
	}
	public double getLat()
	{
		return lat;
	}
	public void setLat(double lat)
	{
		this.lat = lat;
	}
	public double getLon()
	{
		return lon;
	}
	public void setLon(double lon)
	{
		this.lon = lon;
	}
}
