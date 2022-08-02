package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import model.Cart;
import model.MapUrl;
import model.MySession;
import model.Order;
import model.Product;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String controller = "pay";
		String url = "pay";
		MapUrl mapUrl = new MapUrl();
		HttpSession sesion = request.getSession();
		MySession ms = new MySession(sesion);
		
		Cart cart = ms.getCart();
		if (cart == null) {
			return;
		}
		
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String discount = request.getParameter("discount");
		
		for (Product p : cart.getItems()) {
			String nums = request.getParameter("" + p.getId());
			if (nums != null) {
				int number = Integer.parseInt(nums);
				p.setNumber(number);
			}
		}
				
		//save information of cart and orders to datdabase
		Order orders = new Order(2, address, "", email, null, discount);
		OrdersDAO dao = new OrdersDAO();
		dao.insertOrder(orders, cart);
		
		ms.setController(controller);
		ms.setCart(null);
		response.sendRedirect(mapUrl.getUrl(url));
		
	}

}
