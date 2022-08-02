package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.PageIndex;
import model.MapUrl;
import model.MySession;
import model.Product;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htlm;utf-8");
		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String url = "listadmin";
		String action = "list";
		String controller = "list";
		
		PageIndex p = new PageIndex();
		int pageAll = 1; // total page product
		int page = 1; // index of page	
		
		//pagination
		String strIndex = request.getParameter("page");
		if (strIndex != null) {
			page = Integer.parseInt(strIndex);
		}
		p.setPage(page);
			
		// list products and index of page
		try {
			List<Product> products = p.getAllProduct();
			pageAll = p.getPageAll();
			ms.setPage(page);
			ms.setPageAll(pageAll);
			ms.setProducts(products);
			ms.setAction(action);
			ms.setController(controller);
			
			request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
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

}
