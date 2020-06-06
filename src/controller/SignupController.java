package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signup.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("mobile");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm-password");
		
		System.out.println(name+"="+email+"="+contact+"="+password);
		
		User user = new User();
		UserDao userdao = new UserDao();
		
		if(password.equals(confirm_password)) {
			user.setName(name);
			user.setEmail(email);
			user.setMobilenumber(contact);
			user.setPassword(password);
			
			int insert = userdao.signUp(user);
			System.out.println(insert);
			if(insert==0) {
				request.setAttribute("message", "User Already Exists");
			}
			else if(insert==2) {
				request.setAttribute("message", "Exception");
			}
			else {
				request.setAttribute("message", "SignUp Successfully");
			}
			
		}
		else {
			request.setAttribute("message", "Password not match");
		}
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signup.jsp");
		rd.forward(request, response);
	}

}
