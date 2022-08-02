package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.MapUrl;
import model.MySession;
import model.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/admin/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String url = "addproduct";
		String message = null;
		int addproduct = 0;
		String action = request.getParameter("action");
		String vsearch = request.getParameter("vsearch");

		if (action == null || !action.equals("submit")) {
			if(action !=null && action.equals("addproduct2")) {
				url = "addproductSubmit";
			}
			ms.setVsearch(vsearch);
			ms.setAddProduct(addproduct);
			message = "Please enter information of product!";
			ms.setMessage(message);
			response.sendRedirect(mapUrl.getUrl(url));
			return;
		}
		// add product

		String name = request.getParameter("name");
		String des = request.getParameter("description");
		String price = request.getParameter("price");
		String src = request.getParameter("src");
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		String number = request.getParameter("number");
		url = "addproductSubmit";
		addproduct = 1;
		int result = 0;
		float prices = 0;
		if (price != null) {
			prices = Float.parseFloat(price);
		}
		int numbers = 0;
		if (number != null) {
			numbers = Integer.parseInt(number);
		}
		Product product = new Product(0, name, des, prices, src, type, brand, numbers);
		ProductDAO dao = new ProductDAO();
		try {
			result = dao.insertProduct(product);
			if (result > 0) {
				message = "Add product successfully!";
			} else {
				message = "Add fail";
			}

			ms.setProduct(product);
			ms.setUpdate(numbers);
			ms.setAddProduct(addproduct);
			ms.setMessage(message);
			response.sendRedirect(mapUrl.getUrl(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccessRequest(request, response);
	}

}
