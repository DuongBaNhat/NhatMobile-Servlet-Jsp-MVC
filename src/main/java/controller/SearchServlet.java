package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MapUrl;
import model.MySession;
import model.Pagination;
import model.Product;

/**
 * Servlet implementation class Search
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doSearch(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doSearch(request, response);
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		MySession ms = new MySession(session);	
		MapUrl mapUrl = new MapUrl();
		String controller = "search";
		String url = "search";
		String message = null;
	
		ms.setController(controller);
		ms.setControlsrc(controller);
		
		int page = 1, pageAll = 1;
		List<Product> products = null;
		String type = request.getParameter("product_cat");
		String vsearch = request.getParameter("nsearch");
		String pageIndex = request.getParameter("page");
		String action = request.getParameter("action");
		Pagination p = new Pagination();

		if (pageIndex != null) {
			page = Integer.parseInt(pageIndex);
		}
		p.setPage(page);
		
		if (vsearch == null) {
			vsearch = (String) session.getAttribute("vsearch");
		}

		if (type == null) {
			type = (String) session.getAttribute("type");
		}

		try {
			products = p.search(vsearch, type);
			pageAll = p.getPageAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (products.size() == 0) {
			message = "Sorry, not found information!";
		}

		
		ms.setAction(action);
		
		ms.setPage(page);
		ms.setPageAll(pageAll);
		ms.setProductAll(p.getProductAll());
		ms.setProducts(products);
		ms.setType(type);
		ms.setVsearch(vsearch);
		ms.setMessage(message);

		response.sendRedirect(mapUrl.getUrl(url));
	}
}
