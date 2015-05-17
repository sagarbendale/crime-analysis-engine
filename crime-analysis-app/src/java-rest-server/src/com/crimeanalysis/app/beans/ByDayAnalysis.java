package com.crimeanalysis.app.beans;

public class ByDayAnalysis
{
	@Override
	public String toString()
	{
		return "ByDayAnalysis [dayOfWeek=" + dayOfWeek + ", totalCount=" + totalCount + "]";
	}
	private String dayOfWeek;
	private int	totalCount;
	public String getDayOfWeek()
	{
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek)
	{
		this.dayOfWeek = dayOfWeek;
	}
	public ByDayAnalysis(String dayOfWeek, int totalCount)
	{
		super();
		this.dayOfWeek = dayOfWeek;
		this.totalCount = totalCount;
	}
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
		
}
