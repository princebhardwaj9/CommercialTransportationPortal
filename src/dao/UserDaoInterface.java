package dao;

import java.util.List;

import model.Orders;
import model.User;

public interface UserDaoInterface {
	int signUp(User user);
	boolean login(String email, String password);
	void bookingRequest(String email,String source,String destination,String type, String fare); //,String bookingid
//	void deliverSuccessfully(String email,String trucknum,String bookingid);
//	void seePendingRequest(String email);
	List<Orders> seeAllOrders(String email);
}
