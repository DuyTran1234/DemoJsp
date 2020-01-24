package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import BEAN.*;
import DAO.*;

@WebServlet("/ControllerCart")
public class ControllerCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControllerCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("account");
		
		request.setAttribute("accountCart", name);
		request.setAttribute("listCar", DisplayCartDAO.displayCart(name));
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Cart.jsp");
		rd.forward(request, response);
	}

}
