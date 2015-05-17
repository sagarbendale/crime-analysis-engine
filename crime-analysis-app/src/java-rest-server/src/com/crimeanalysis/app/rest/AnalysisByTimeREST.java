package com.crimeanalysis.app.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.glassfish.jersey.server.JSONP;

import com.crimeanalysis.app.beans.AnalysisRequest;
import com.crimeanalysis.app.beans.ByTimeAnalysis;
import com.crimeanalysis.app.db.dao.ByTimeAnalysisDAO;
import com.crimeanalysis.app.util.DateUtil;


@Path("/analysis")
public class AnalysisByTimeREST
{
	
	
	
	@GET
	@Path("/byTime")
	@JSONP(queryParam="callback")
	@Produces({"application/x-javascript"})
	public ArrayList<ByTimeAnalysis> getAllTestData(@QueryParam("callback") String callback,
												   @QueryParam("start_date") String startDate,
												   @QueryParam("end_date") String endDate,
												   @QueryParam("lat") String lat,
												   @QueryParam("lon") String lon,
												   @QueryParam("radius") String radius) 
	{

		AnalysisRequest analysisRequest=new AnalysisRequest();
		
		analysisRequest.setStartDate(DateUtil.convert(startDate));
		analysisRequest.setEndDate(DateUtil.convert(endDate));
		analysisRequest.setLat(Double.parseDouble(lat));
		analysisRequest.setLon(Double.parseDouble(lon));
		analysisRequest.setRadius(Integer.parseInt(radius));
		
		ByTimeAnalysisDAO dao=new ByTimeAnalysisDAO();
		return dao.getAnalysis(analysisRequest);
	    
	}
}
