package com.crimeanalysis.app.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crimeanalysis.app.beans.AnalysisRequest;
import com.crimeanalysis.app.beans.ByDayAnalysis;
import com.crimeanalysis.app.db.connectors.MySQLConnector;


public class ByDayAnalysisDAO
{
	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<ByDayAnalysis> getAnalysis(AnalysisRequest analysisRequest)
	{
		ArrayList<ByDayAnalysis> output = null;

		try
		{
			dbConnection = MySQLConnector.getConnection();
			
			
			preparedStatement = dbConnection.prepareStatement("select result.dayOfWeek,count(*) as totalCount from "+
											   " ("+
											   " 	SELECT"+
											   "    timestampOfCrime,"+
											   " 	DAYNAME(timestampOfCrime) as dayOfWeek,"+
											   " 	("+
											   " 					3959 * acos "+
											   " 					("+
											   " 						cos ( "+
											   " 								radians( ? ) "+
											   " 							)"+
											   " 						* cos( "+
											   " 								radians( lat ) "+
											   " 							 )"+
											   " 						* cos( "+
											   " 								radians( lon ) - radians( ? )"+
											   " 							 )"+
											   " 						+ sin ("+ 
											   " 								radians( ? ) "+
											   " 							   )"+
											   " 						* sin( "+
											   " 								radians( lat ) "+
											   " 						)"+
											   " 					)"+
											   " 	) AS distance"+
											   " 	FROM CrimeDB.crimedata"+
											   " 	HAVING distance < ?"+
											   " 	AND"+
											   " 	(timestampOfCrime between ? and ? )"+
											   " 	ORDER BY timestampOfCrime"+
											   " ) AS result "+
											   "  group by dayOfWeek");
			
			
			
			preparedStatement.setDouble(1, analysisRequest.getLat());
			preparedStatement.setDouble(2, analysisRequest.getLon());
			preparedStatement.setDouble(3, analysisRequest.getLat());
			preparedStatement.setDouble(4,analysisRequest.getRadius()) ;
			preparedStatement.setDate(5,new java.sql.Date( analysisRequest.getStartDate().getTime()));
			preparedStatement.setDate(6,new java.sql.Date(  analysisRequest.getEndDate().getTime()));
		
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			output = new ArrayList<ByDayAnalysis>();
			while (resultSet.next())
			{
				output.add(new ByDayAnalysis (resultSet.getString("dayOfWeek"), Integer.parseInt(resultSet.getString("totalCount") )));
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
