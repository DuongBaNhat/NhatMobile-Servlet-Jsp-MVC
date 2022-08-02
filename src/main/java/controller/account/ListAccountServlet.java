package controller.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.Account;
import model.MapUrl;
import model.MySession;

/**
 * Servlet implementation class ListAccountServlet
 */
@WebServlet("/admin/listaccount")
public class ListAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htlm;utf-8");
		MySession ms = new MySession(request.getSession());
		MapUrl mapUrl = new MapUrl();
		String url = "listaccount";
		String controller = "admin/listaccount";
		try {
			AccountDAO dao = new AccountDAO();
			List<Account> accounts = dao.search("");
			
			
			ms.setAccounts(accounts);
			ms.setAction(url);
			ms.setAction("staff");
			ms.setController(controller);
			
			response.sendRedirect(mapUrl.getUrl(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
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

}
