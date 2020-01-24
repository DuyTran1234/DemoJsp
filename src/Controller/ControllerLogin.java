package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import BEAN.*;
import DAO.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setAccount(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		if(LoginDAO.loginAccount(user)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("account", user.getAccount());
			request.setAttribute("listCar", ListCar.getList());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Home.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("Notification", "Login fail");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Login.jsp");
			rd.forward(request, response);
		}
	}

}
