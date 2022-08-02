package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.bean.PageIndex;
import model.MapUrl;
import model.MySession;
import model.Product;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htlm;utf-8");
		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String url = "deleteproduct";
		String action = request.getParameter("action");
		String message = null;
		String controller = "admin/deleteproduct";

		String idstr = request.getParameter("id");
		int id = 0;
		if (idstr != null) {
			id = Integer.parseInt(idstr);
		}

		try {
			if (action != null && (action.equals("listdelete") || action.equals("searchdelete"))) {
				// delete product from database
				ProductDAO dao = new ProductDAO();
				int result = dao.deleteProduct(id);
				if (result > 0) {
					message = "Delete successfully!";
				} else {
					message = "Delete fail!";
				}
			}

			// url to deleteproduct.jsp
			if (action != null && action.equals("listdelete")) {
				url = "deleteproductadmin";

			} else if (action != null && action.equals("searchdelete")) {
				url = "deleteproduct";
			}

			// pagination
			PageIndex p = new PageIndex();
			int pageAll = 1; // total page product
			int page = 1; // index of page

			String strIndex = request.getParameter("page");
			if (strIndex != null) {
				page = Integer.parseInt(strIndex);
			}
			p.setPage(page);
			List<Product> products = p.getAllProduct();

			pageAll = p.getPageAll();
			ms.setPage(page);
			ms.setPageAll(pageAll);
			ms.setProducts(products);
			ms.setAction("list");
			ms.setMessage(message);
			ms.setController(controller);

			request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
			// response.sendRedirect(mapUrl.getUrl(url));
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
