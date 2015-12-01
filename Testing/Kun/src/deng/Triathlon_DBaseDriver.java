package deng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Triathlon_DBaseDriver {
	
	private Connection csc3610conn;
	
	public Triathlon_DBaseDriver(String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
		Class.forName("org.mariadb.jdcb.Driver");		
		csc3610conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ath_info", "root", "password");	
	}
	
	public void shutdown() throws SQLException {
		if(csc3610conn != null){
			csc3610conn.close();
		}
	}
	
	public List<Triathlon_Info> getMaleAthleteInfo() throws SQLException {
		try(
			Statement stmt = csc3610conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from male_athletes");
				) {
			List<Triathlon_Info> athList = new ArrayList<>();
			while (rs.next()){
				
				String FirstNames = rs.getString("FirstName");
				String LastNames = rs.getString("LastName");
				String Number = rs.getString("Number");
				String RunTime = rs.getString("RunTime");
				String BikeTime = rs.getString("BikeTime");
				String SwimTime = rs.getString("SwimTime");
				String TotalTime = rs.getString("TotalTime");
				String Gender = rs.getString("Gender");
				String Rank = rs.getString("Rank");

				Triathlon_Info athInfo = new Triathlon_Info(FirstNames, LastNames, Number, RunTime, BikeTime, SwimTime,
						TotalTime, Gender, Rank);
				athList.add(athInfo);
			}
			return athList;
		}
	}
	
	public List<Triathlon_Info> getFemaleAthleteInfo() throws SQLException {
		try(
			Statement stmt = csc3610conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from female_athletes");
				) {
			List<Triathlon_Info> athleteList = new ArrayList<>();
			while (rs.next()){
				String FirstNames = rs.getString("FirstName");
				String LastNames = rs.getString("LastName");
				String Number = rs.getString("Number");
				String RunTime = rs.getString("RunTime");
				String BikeTime = rs.getString("BikeTime");
				String SwimTime = rs.getString("SwimTime");
				String TotalTime = rs.getString("TotalTime");
				String Gender = rs.getString("Gender");
				String Rank = rs.getString("Rank");

				Triathlon_Info athletes = new Triathlon_Info(FirstNames,LastNames,Number, RunTime, BikeTime, SwimTime,
						TotalTime, Gender, Rank);
				athleteList.add(athletes);
				}
		
			return athleteList;
		}
	}
}
