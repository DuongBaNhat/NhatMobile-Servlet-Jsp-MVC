package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdersDAO;
import model.MapUrl;
import model.MyCookie;
import model.MySession;
import model.Order;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String controller = "history";
		String url = "history";
		//String action = ms.getAction();
		
		OrdersDAO dao = new OrdersDAO();
		List<Order> lo = null;
		String email = new MyCookie(request, response).getValue("username");
		try {
			lo = dao.search(email);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(lo == null) {
			ms.setMessage("Your history is empty");
		}
		ms.setOrders(lo);
		ms.setController(controller);
		ms.setAction(url);
		
		request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
	}

}
