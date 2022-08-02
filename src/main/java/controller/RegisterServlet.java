package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.MapUrl;
import model.MyCookie;
import model.MySession;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String controller = "register";
		String url = "register";
		MapUrl mapUrl = new MapUrl();
		String action = request.getParameter("action");
		if (action == null || !action.equals("doregister")) {
		
			request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
			return;
		}

		
		MySession ms = new MySession(request.getSession());
		String message = null;

		String email = request.getParameter("username");
		String pass = request.getParameter("password");
		String rePass = request.getParameter("repassword");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		String remember = request.getParameter("remember");
		ms.setUserName(email);
		MyCookie cookie = new MyCookie(request, response);
		cookie.saveCookie("username", email, remember);

		if (email == null) {
			message = "Email is empty";
		}
		if (pass == null) {
			message = "Password is empty";
		} else if (!pass.equals(rePass)) {
			message = "Repeat password fail";
		} else {
			User user = new User(email, pass);
			try {
				if (!user.validate()) {
					message = user.getMessage();
				} else {
					Account account = new Account(email, pass, 0, name, address, phone, 0);
					account = account.register();
					message = account.getMessage();
				}

			} catch (Exception e) {
				message = "Register fail";
				e.printStackTrace();
			}

		}

		// set session and direct
		
		ms.setController(controller);
		ms.setMessage(message);

		response.sendRedirect(mapUrl.getUrl(url));
	}
}
