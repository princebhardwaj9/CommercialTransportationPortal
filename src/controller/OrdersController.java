package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Orders;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/orders")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet ordersController");
		List<Orders> ordersList = new ArrayList<Orders>();
		String email = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equalsIgnoreCase("email")) {
				email = cookies[i].getValue();
			}
		}
		if(email!=null) {
			UserDao userdao =new UserDao();
			ordersList = userdao.seeAllOrders(email);
		}
		request.setAttribute("ordersList", ordersList);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orders.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
//		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orders.jsp");
//		rd.forward(request, response);
	}

}
