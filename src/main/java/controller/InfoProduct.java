package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.MapUrl;
import model.MySession;
import model.Product;

/**
 * Servlet implementation class InfoProduct
 */
@WebServlet("/infoproduct")
public class InfoProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoProduct() {
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String controller = "infoproduct";
			MapUrl mapUrl = new MapUrl();
			String url = "infoProduct";
			// String action = request.getParameter("action");
			HttpSession session = request.getSession();
			MySession mySession = new MySession(session);
			mySession.setController(controller);

			ListProductDAO dao = new ListProductDAO();
			String id = request.getParameter("id");

			Product product = null;
			try {
				product = dao.getProduct(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// set attribute of session
			mySession.setProduct(product);

			request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
