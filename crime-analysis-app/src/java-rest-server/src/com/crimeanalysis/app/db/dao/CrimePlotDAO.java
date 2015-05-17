package com.crimeanalysis.app.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crimeanalysis.app.beans.AnalysisRequest;
import com.crimeanalysis.app.beans.CrimePlot;
import com.crimeanalysis.app.db.connectors.MySQLConnector;

public class CrimePlotDAO
{
	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<CrimePlot> getAnalysis(AnalysisRequest analysisRequest)
	{
		ArrayList<CrimePlot> output = null;

		try
		{
			dbConnection = MySQLConnector.getConnection();
			
			
			preparedStatement = dbConnection.prepareStatement("SELECT"+
															  " lat,"+
															  " 	lon,"+
															  " 	crimeType,"+
															  " 		("+
															  " 					3959 * acos "+
															  " 					("+
															  " 						cos ( "+
															  " 							radians(?) "+
									  						  " 						)"+
															  " 	* cos( "+
															  " 		radians( lat ) "+
															  " 	 )"+
															  " 	* cos( "+
															  " 		radians( lon ) - radians(?) "+
															  " 	 )"+
															  " 	+ sin ( "+
															  " 		radians(?) "+
															  " 	   )"+
															  " 	* sin( "+
															  " 		radians( lat ) "+
															  " )"+
															  " 	)"+
															  " ) AS distance,"+
															  "  timestampOfCrime"+
															  " FROM CrimeDB.crimedata"+
															  " HAVING distance < ?"+
															  " AND"+
															  " (timestampOfCrime between ? and ? )"+
														      " ORDER BY timestampOfCrime");
			
			
			
			preparedStatement.setDouble(1, analysisRequest.getLat());
			preparedStatement.setDouble(2, analysisRequest.getLon());
			preparedStatement.setDouble(3, analysisRequest.getLat());
			preparedStatement.setDouble(4,analysisRequest.getRadius()) ;
			preparedStatement.setDate(5,new java.sql.Date( analysisRequest.getStartDate().getTime()));
			preparedStatement.setDate(6,new java.sql.Date(  analysisRequest.getEndDate().getTime()));
		
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			output = new ArrayList<CrimePlot>();
			CrimePlot crimePlot=null;
			while (resultSet.next())
			{
				crimePlot=new CrimePlot();
				
				crimePlot.setCrimeType(resultSet.getString("lat"));
				crimePlot.setLat(resultSet.getString("lon"));
				crimePlot.setLon(resultSet.getString("crimeType"));
				crimePlot.setTimeStamp(resultSet.getString("timestampOfCrime"));
				
				output.add(crimePlot);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (resultSet != null)
				{
					resultSet.close();
				}

				if (preparedStatement != null)
				{
					preparedStatement.close();
				}

				if (dbConnection != null)
				{
					dbConnection.close();
				}

			}
			catch (SQLException e)
			{

				e.printStackTrace();
			}
		}
		return output;

	}
}
