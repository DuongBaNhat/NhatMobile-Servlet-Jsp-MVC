package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.MapUrl;
import model.MySession;
import model.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		MySession ms = new MySession(session);
		String controller = "cart";
		ms.setController(controller);
		String url = "cart";
		MapUrl mapUrl = new MapUrl();
		String action = request.getParameter("action");
		String idstr = request.getParameter("id");
				
		
		int id = -1;
		if (idstr != null) {
			id = Integer.parseInt(idstr);
		}
		
		
		Cart cart  = ms.getCart();
		if (cart == null) {
			cart = new Cart();
		}
		//num = 10;
		String numstr = request.getParameter(id + "");
		int num = 0;
		if (numstr != null) {
			num = Integer.parseInt(numstr);
			cart.setNumber(id, num);
		}
		
		if (action !=null && action.equals("delete")) {
			cart.setNumber(id, 0);
		} else if (action != null && action.equals("add")){
			Product product = (Product) session.getAttribute("product");
			cart.add(product);			
		} else if (action != null && action.equals("plus")) {
			cart.add(id);
		} else if (action != null && action.equals("minus")) {
			cart.remove(id);
		}
		
		
		ms.setProductAll(cart.getProductAll());
		ms.setCart(cart);
		
		request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
	}

}
