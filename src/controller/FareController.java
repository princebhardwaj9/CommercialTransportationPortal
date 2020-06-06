package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeDao;

/**
 * Servlet implementation class FareController
 */
@WebServlet("/fareProcess")
public class FareController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FareController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		System.out.println("In getFare()");
		System.out.println(source);
		System.out.println(destination);
		
		HomeDao homedao = new HomeDao();
		int fare = homedao.getFare(source, destination);
		
		System.out.println(fare);
		
		request.setAttribute("fare", fare);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(request, response);
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String source = request.getParameter("source");
//		String destination = request.getParameter("destination");
//		System.out.println("In getFare()");
//		System.out.println(source);
//		System.out.println(destination);
//		
//		HomeDao homedao = new HomeDao();
//		int fare = homedao.getFare(source, destination);
//		
//		System.out.println(fare);
//		
//		request.setAttribute("fare", fare);
//		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
//		rd.forward(request, response);
//		doGet(request, response);
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		System.out.println("In getFare()");
		System.out.println(source);
		System.out.println(destination);
		
		HomeDao homedao = new HomeDao();
		int fare = homedao.getFare(source, destination);
		
		System.out.println(fare);
		
		request.setAttribute("fare", fare);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(request, response);
	}

}
