package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import BEAN.User;
import DAO.RegisterDAO;

@WebServlet("/ControllerRegister")
public class ControllerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setAccount(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		String confirmPassword = request.getParameter("confirm");
		
		if (RegisterDAO.registerAccount(user, confirmPassword).equals("true")) {
			request.setAttribute("NotificationRegister", "Register success!");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Register.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("NotificationRegister", RegisterDAO.registerAccount(user, confirmPassword));
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Register.jsp");
			rd.forward(request, response);
		}
	}

}
