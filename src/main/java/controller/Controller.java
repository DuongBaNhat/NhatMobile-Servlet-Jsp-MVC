package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.bean.PageIndex;
import model.MapUrl;
import model.MySession;
import model.Product;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MySession ms = new MySession(session);
		String controller = "controller";
		ms.setControlsrc(controller);
		ms.setController(controller);
		
		MapUrl mapUrl = new MapUrl();
		String url = request.getParameter("action");
		int pageAll = 1; // total page product
		int page = 1; // index of page
		String strIndex = request.getParameter("page");
		if (strIndex != null) {
			page = Integer.parseInt(strIndex);
			
		}
		url = request.getParameter("action");
		if (url == null || !mapUrl.containsKey(url)) {
			url = "home";
		}
		
		// list products and index of page
		PageIndex pageIndex = new PageIndex();
		pageIndex.setPage(page);		
		try {
			List<Product> products = pageIndex.getAllProduct();
			pageAll = pageIndex.getPageAll();
			
			ms.setAction(url);
			ms.setPage(page);
			ms.setPageAll(pageAll);
			ms.setProducts(products);
			
			

			request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
