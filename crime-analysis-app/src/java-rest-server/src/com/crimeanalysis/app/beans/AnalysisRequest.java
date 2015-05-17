package com.crimeanalysis.app.beans;

import java.util.Date;

public class AnalysisRequest
{

	private Date startDate;
	private Date endDate;
	private double lat;
	private double lon;
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
	private double radius;
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}


	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	
}
