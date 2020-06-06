package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Orders;
import model.User;
import utility.ConnectionManager;

public class UserDao implements UserDaoInterface {
	
	Connection con;
	List<Orders> allOrderList = new ArrayList<Orders>();

	@Override
	public int signUp(User user) {
		try {
			con = ConnectionManager.getconnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");
			ps.setString(1, user.getEmail());
			ResultSet userexist = ps.executeQuery();
			if(userexist.next()) {
				return 0;
			}
			else {
				PreparedStatement ps1 = con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?)");
				ps1.setString(1, user.getName());
				ps1.setString(2, user.getEmail());
				ps1.setString(3, user.getMobilenumber());
				ps1.setString(4, user.getPassword());
				ps1.executeUpdate();
				con.close();
				return 1;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return 2;
		}
	}

	@Override
	public boolean login(String email, String password) {
		try {
			con = ConnectionManager.getconnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void bookingRequest(String email, String source, String destination, String type, String fare) {   //, String bookingid
		try {
			con = ConnectionManager.getconnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO ORDERS VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setString(4, type);
			ps.setString(5, fare);
			ps.setString(6, "Pending");
			ps.setString(7, null);
			ps.setString(8, null);
			ps.setString(9, null);
			ps.execute();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Orders> seeAllOrders(String email) {
		
		try {
			con = ConnectionManager.getconnection();
			Orders order = new Orders();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ORDERS WHERE EMAIL=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order.setSource(rs.getString("source"));
				order.setDestination(rs.getString("destination"));
				order.setFare(rs.getString("fare"));
				order.setStatus(rs.getString("status"));
				order.setTrucknum(rs.getString("trucknum"));
				order.setDriverName(rs.getString("drivername"));
				order.setDriverNumber(rs.getString("drivernumber"));
				allOrderList.add(order);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return allOrderList;
	}
	
}
