package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeDao;
import model.Vehicle;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeDao homedao = new HomeDao();
		List<Vehicle> vehicleList = homedao.allVehicle();
		List<String> routelist = homedao.allRoutes();
		for(Vehicle v:vehicleList) {
			System.out.print(v.getImage());
			System.out.print(v.getType());
			System.out.print(v.getDimension());
			System.out.print(v.getAbout());
			System.out.println();
		}
		for(String r:routelist) {
			System.out.println(r);
		}
		
//		String source = request.getParameter("source");
//		String destination = request.getParameter("destination");
		
		request.setAttribute("vehicleList", vehicleList);
		request.setAttribute("routelist", routelist);
//		getFare(request,response);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(request, response);
	}

	/*private void getFare(HttpServletRequest request, HttpServletResponse response) {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		System.out.println("In getFare()");
		System.out.println(source);
		System.out.println(destination);
		
		HomeDao homedao = new HomeDao();
		int fare = homedao.getFare(source, destination);
		
		System.out.println(fare);
		
		request.setAttribute("fare", fare);
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String source = request.getParameter("source");
//		String destination = request.getParameter("destination");
//		
//		System.out.println(source);
//		System.out.println(destination);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(request, response);
		
	}

}
