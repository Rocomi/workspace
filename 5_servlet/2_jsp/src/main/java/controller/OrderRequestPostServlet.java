package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderRequestPostServlet
 */
@WebServlet("/orderRequest.or")
public class OrderRequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");			
		String userTel = request.getParameter("userTel");				
		String address = request.getParameter("address");
		String ask = request.getParameter("ask");
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String edge = request.getParameter("edge");
		String dow = request.getParameter("dow");
		String[] side = request.getParameterValues("side");
		String[] beverage = request.getParameterValues("beverage");
		
		
		request.setAttribute("userName", userName);
		request.setAttribute("userTel", userTel);
		request.setAttribute("address", address);
		request.setAttribute("ask", ask);
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("edge", edge);
		request.setAttribute("dow", dow);
		request.setAttribute("side", side);
		request.setAttribute("beverage", beverage);
		
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/orderResponsePage.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
