package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import BEAN.*;
import DAO.*;

@WebServlet("/ControllerAddCart")
public class ControllerAddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerAddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listCar", ListCar.getList());
		String ID = request.getParameter("dropdownlist");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("account");
			
		request.setAttribute("NotificationCart", AddCartDAO.addCart(name, ID));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
		rd.forward(request, response);
	}

}
