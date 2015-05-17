package com.crimeanalysis.app.beans;

public class ByTimeAnalysis
{

	
	@Override
	public String toString()
	{
		return "ByTimeAnalysis [crimeTime=" + crimeTime + ", totalCount=" + totalCount + "]";
	}
	private String crimeTime;
	private int totalCount;
	public String getCrimeTime()
	{
		return crimeTime;
	}
	public void setCrimeTime(String crimeTime)
	{
		this.crimeTime = crimeTime;
	}
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public ByTimeAnalysis(String crimeTime, int totalCount)
	{
		super();
		this.crimeTime = crimeTime;
		this.totalCount = totalCount;
	}
	
}
