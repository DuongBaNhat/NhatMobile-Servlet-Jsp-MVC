package controller.product;

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
 * Servlet implementation class SearchAdminServlet
 */
@WebServlet("/SearchAdminServlet")
public class SearchAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		MapUrl mapUrl = new MapUrl();
		int page = 1, pageAll = 1;
		String vsearch = request.getParameter("nsearch");
		String pageIndex = request.getParameter("page");
		String action = request.getParameter("action");
		Pagination p = new Pagination();
		String controller = "admin/searchadmin";
		String url = "";
		if(action != null && action.equals("search")) {
			url = "searchAdmin";
			controller = "searchadmin";
		} else if (action != null && action.equals("searchadmin")) {
			url = "searchList";
			controller = "admin/searchadmin";
		}
		List<Product> products = null;
		String message = null;
				
		if(pageIndex != null) {
			page = Integer.parseInt(pageIndex);
		}
		p.setPage(page);
		
		if (vsearch == null) {
			vsearch = (String) session.getAttribute("vsearch");
		}
		
		try {
			products = p.search(vsearch);
			pageAll = p.getPageAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(products.size() == 0) {
			message = "Sorry! not found infomation.";
		}
		
		//set attribute of session
		MySession mySession = new MySession(session);
		mySession.setAction(action);
		mySession.setController(controller);
		mySession.setPage(page);
		mySession.setPageAll(pageAll);
		mySession.setProducts(products);
		mySession.setVsearch(vsearch);
		mySession.setProductAll(p.getProductAll());
		mySession.setMessage(message);
		
		response.sendRedirect(mapUrl.getUrl(url));

	}

}
