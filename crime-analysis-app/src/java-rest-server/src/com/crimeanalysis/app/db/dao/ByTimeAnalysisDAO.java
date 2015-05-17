package com.crimeanalysis.app.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crimeanalysis.app.beans.AnalysisRequest;
import com.crimeanalysis.app.beans.ByTimeAnalysis;
import com.crimeanalysis.app.db.connectors.MySQLConnector;

public class ByTimeAnalysisDAO
{

	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<ByTimeAnalysis> getAnalysis(AnalysisRequest analysisRequest)
	{
		ArrayList<ByTimeAnalysis> output = null;

		try
		{
			dbConnection = MySQLConnector.getConnection();
			
			
			preparedStatement = dbConnection.prepareStatement("select result.Hours,count(*) as totalCount from "+
											  " ("+
											  " 	SELECT"+
											  " 	DAYNAME(timestampOfCrime) as dayOfWeek,"+
											  " 	("+
											  " 					3959 * acos "+
											  " 					("+
											  " 						cos ( "+
											  " 								radians(?) "+
											  " 							)"+
											  " 						* cos( "+
											  " 								radians( lat ) "+
											  " 							 )"+
											  " 						* cos( "+
											  " 								radians( lon ) - radians(?) "+
											  " 							 )"+
											  " 						+ sin ( "+
											  " 								radians(?)"+ 
											  " 							   )"+
											  " 						* sin( "+
											  " 								radians( lat ) "+
											  " 						)"+
											  " 					)"+
											  " 	) AS distance,"+
											  "     timestampOfCrime,"+
											  " 	CASE "+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 0 AND 1 THEN '00:00 - 01:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 1 AND 2 THEN '01:00 - 02:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 2 AND 3 THEN '02:00 - 03:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 3 AND 4 THEN '03:00 - 04:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 4 AND 5 THEN '04:00 - 05:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 5 AND 6 THEN '05:00 - 06:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 6 AND 7 THEN '06:00 - 07:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 7 AND 8 THEN '07:00 - 08:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 8 AND 9 THEN '08:00 - 09:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 9 AND 10 THEN '09:00 - 10:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 10 AND 11 THEN '10:00 - 11:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 11 AND 12 THEN '11:00 - 12:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 12 AND 13 THEN '12:00 - 13:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 13 AND 14 THEN '13:00 - 14:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 14 AND 15 THEN '14:00 - 15:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 15 AND 16 THEN '15:00 - 16:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 16 AND 17 THEN '16:00 - 17:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 17 AND 18 THEN '17:00 - 18:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 18 AND 19 THEN '18:00 - 19:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 19 AND 20 THEN '19:00 - 20:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 20 AND 21 THEN '20:00 - 21:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 21 AND 22 THEN '21:00 - 23:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 22 AND 23 THEN '22:00 - 23:00'"+
											  " 		WHEN HOUR(timestampOfCrime) BETWEEN 23 AND 24 THEN '23:00 - 00:00'"+
											  " 		END AS `Hours`"+
											  " 	FROM CrimeDB.crimedata"+
											  " 	HAVING distance < ?"+
											  " 	AND"+
											  " 	(timestampOfCrime between ? and ? )"+
											  " 	ORDER BY timestampOfCrime"+
											  " ) AS result "+
											  "   group by Hours");
			
			
			
			preparedStatement.setDouble(1, analysisRequest.getLat());
			preparedStatement.setDouble(2, analysisRequest.getLon());
			preparedStatement.setDouble(3, analysisRequest.getLat());
			preparedStatement.setDouble(4,analysisRequest.getRadius()) ;
			preparedStatement.setDate(5,new java.sql.Date( analysisRequest.getStartDate().getTime()));
			preparedStatement.setDate(6,new java.sql.Date(  analysisRequest.getEndDate().getTime()));
		
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			output = new ArrayList<ByTimeAnalysis>();
			while (resultSet.next())
			{
				output.add(new ByTimeAnalysis (resultSet.getString("Hours"), Integer.parseInt(resultSet.getString("totalCount") )));
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
