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

/**
 * Servlet implementation class UpDateNumber
 */
@WebServlet(urlPatterns={"/updatenumber", "/admin/updatenumber"})
public class UpDateNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpDateNumber() {
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

	/**
	 * update number
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String url = "updatenumber";
		String idstr = request.getParameter("id");
		String message = null;
		int update = 0;
		String action = request.getParameter("action");
		
		if (action == null || !action.equals("submit")) {
			if(action != null && action.equals("updatenumberSearch")) {
				url = "updatenumberSearch";
			}
			ms.setUpdate(update);
			ms.setMessage(message);
			ms.setProductId(idstr);
			response.sendRedirect(mapUrl.getUrl(url));
			return;
		}
		//update
		update = 1;
		int id = 0;
		if (idstr != null) {
			id = Integer.parseInt(idstr);
		}
		
		String numstr = request.getParameter("number");
		int number = 0;
		if (numstr != null) {
			number = Integer.parseInt(numstr);
			ProductDAO dao = new ProductDAO();
			try {
				int result = dao.updateNumber(id, number);
				if (result > 0) {
					message = "Upadate successfully";
				} else {
					message = "Update fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ms.setProductNumber(number);
		ms.setUpdate(update);
		ms.setMessage(message);
		ms.setProductId(idstr);
		response.sendRedirect("updatenumber.jsp");
	}

}
