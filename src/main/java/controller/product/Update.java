package controller.product;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
 * Servlet implementation class EditProduct
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String url = "update";
		String message = null;
		int update = 0;
		String id = request.getParameter("id");
		
		String action = request.getParameter("action");
		if (action == null || !action.equals("submit")) { //show product
			ms.setUpdate(update);
			ms.setMessage(message);
			ms.setProductId(id);
			response.sendRedirect(mapUrl.getUrl(url));
			return;
		}
		
	
		String name = request.getParameter("name");
		String des = request.getParameter("description");
		String price = request.getParameter("price");
		String src = request.getParameter("src");
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		String number = request.getParameter("number");
		update = 1;
		int ids = 0;
		
		if (id != null) {
			id = id.trim();
			ids = Integer.parseInt(id);
		}
		
		int nums = 0;
		if (number != null) {
			nums = Integer.parseInt(number);
		}
		float prices = 0;
		if (price != null) {
			prices = Float.parseFloat(price);
		}
			
		Product product = new Product(ids, name, des, prices, src, type, brand, nums);
		ProductDAO dao = new ProductDAO();
		int result = 0;
		try {
			result = dao.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		message = "Update fail";
		if (result > 0) {
			
			message = "Update successfully";
		}
		
		ms.setUpdate(update);
		ms.setProduct(product);
		ms.setMessage(message);
		ms.setProductId(id);
		
		response.sendRedirect(mapUrl.getUrl(url));
		
	}

}
