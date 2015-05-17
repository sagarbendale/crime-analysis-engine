package com.crimeanalysis.app.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.crimeanalysis.app.beans.CrimeData;
import com.crimeanalysis.app.connection.ConnectDB;


public class CrimeDataWriter {
	public void writeCrimeData(ArrayList<CrimeData> op)
	{
		try {
			ConnectDB connection=new ConnectDB();
			Connection con = connection.connect();
			PreparedStatement ps = null;
			String sql =null;
			Double count=0.0;
			for(CrimeData cd : op)
			{

				ps = null;
				sql = "INSERT INTO `crimedata` (crimeType,timestampOfCrime,lat,lon) VALUES (?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, cd.getCrimeType());
				ps.setTimestamp(2, new Timestamp(cd.getTimestampOfCrime().getTime()));
				ps.setDouble(3,cd.getLat());
				ps.setDouble(4,cd.getLon());
				System.out.println(ps);
				ps.execute();
				count++;
			}
			System.out.println("Number of rows inserted : "+count);


		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
}

