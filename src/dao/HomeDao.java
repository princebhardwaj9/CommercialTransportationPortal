package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Vehicle;
import utility.ConnectionManager;

public class HomeDao {
	
	public List<Vehicle> allVehicle() {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		Connection con;
		try {
			con = ConnectionManager.getconnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM VEHICLE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Vehicle vehicle = new Vehicle();
				vehicle.setImage(rs.getString(1));
				vehicle.setType(rs.getString(2));
				vehicle.setDimension(rs.getString(3));
				vehicle.setAbout(rs.getString(4));
				vehicleList.add(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleList;
	}
	
	public List<String> allRoutes() {
		List<String> routelist = new ArrayList<String>();
		Connection con;
		try {
			con = ConnectionManager.getconnection();
			PreparedStatement ps = con.prepareStatement("SELECT DISTINCT SOURCE FROM ROUTES");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				routelist.add(rs.getString(1));
			}
			
			PreparedStatement ps1 = con.prepareStatement("SELECT DISTINCT DESTINATION FROM ROUTES");
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				if(!routelist.contains(rs1.getString(1))) {
					routelist.add(rs1.getString(1));
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return routelist;
	}
	
	public int getFare(String source, String destination) {
		Connection con;
		int fare = 0;
		try {
			System.out.println("In dao try");
			con = ConnectionManager.getconnection();
			PreparedStatement ps = con.prepareStatement("SELECT FARE FROM ROUTES WHERE SOURCE=? AND DESTINATION=?");
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs = ps.executeQuery();
			
			PreparedStatement ps1 = con.prepareStatement("SELECT FARE FROM ROUTES WHERE SOURCE=? AND DESTINATION=?");			
			ps1.setString(1, destination);
			ps1.setString(2, source);
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs.next()) {
				System.out.println("In dao try if");
				fare = Integer.parseInt(rs.getString("fare"));
			}			
			else if(rs1.next()){
				System.out.println("In dao try else if");
				fare = Integer.parseInt(rs1.getString("fare"));
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return fare;
	}
	
}



















