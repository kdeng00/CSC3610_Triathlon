package database_triatholon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Triatholon_DBaseDriver {
	private Connection triatholonconn;
	
	public Triatholon_DBaseDriver(String dbURL, String user, String password) throws SQLException {
			
	triatholonconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/athlete_results", "root", "password");	
	}


public void shutdown() throws SQLException {
	if(triatholonconn != null){
		triatholonconn.close();
	}
}

public List<Triatholon_Info> getMaleAthleteInfo() throws SQLException {
	
	try(
		Statement stmt = triatholonconn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from ath_info");
			) {
		List<Triatholon_Info> athleteList = new ArrayList<>();
		while (rs.next()){
		
			String Names = rs.getString("Names");
			String Number = rs.getString("Number");
			String RunTime = rs.getString("RunTime");
			String BikeTime = rs.getString("BikeTime");
			String SwimTime = rs.getString("SwimTime");
			String TotalTime = rs.getString("TotalTime");
			String Gender = rs.getString("Gender");
			String Rank = rs.getString("Rank");


			Triatholon_Info athletes = new Triatholon_Info(Names,Number, RunTime, BikeTime, SwimTime,
					TotalTime, Gender, Rank);
			athleteList.add(athletes);
			
		}
		return athleteList;
	}}
	
	public List<Triatholon_Info> getFemaleAthleteInfo() throws SQLException {
		try(
			Statement stmt = triatholonconn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ath_info");
				) {
			List<Triatholon_Info> athleteList = new ArrayList<>();
			while (rs.next()){
				String Names = rs.getString("Names");
				String Number = rs.getString("Number");
				String RunTime = rs.getString("RunTime");
				String BikeTime = rs.getString("BikeTime");
				String SwimTime = rs.getString("SwimTime");
				String TotalTime = rs.getString("TotalTime");
				String Gender = rs.getString("Gender");
				String Rank = rs.getString("Rank");
				


				Triatholon_Info athletes = new Triatholon_Info(Names,Number, RunTime, BikeTime, SwimTime,
						TotalTime, Gender, Rank);
				athleteList.add(athletes);
				}
			
			return athleteList;
		}
	
}
