package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email);
			System.out.println(password);
			
			UserDao userdao = new UserDao();
			boolean valid = userdao.login(email, password);
			System.out.println(valid);
			
			if(valid && email!=null && password!=null) {
				Cookie cookie = new Cookie("email",email);
				response.addCookie(cookie);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerHome.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message", "Enter valid details");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
				rd.forward(request, response);
			}
	}

}
