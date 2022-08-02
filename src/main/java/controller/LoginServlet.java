package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.MapUrl;
import model.MyCookie;
import model.MySession;
import model.User;

/**
 * Servlet implementation class Controller
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccessRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccessRequest(request, response);
	}

	private void proccessRequest(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			MapUrl mapUrl = new MapUrl();
			HttpSession session = request.getSession();
			MySession mySession = new MySession(session);

			String controller = "login";
			String url = "login";
			String message = null;
			int role = -1;

			String action = request.getParameter("action");
			if (action == null || !action.equals("dologin")) {
				mySession.setMessage(message);
				request.getRequestDispatcher(mapUrl.getUrl(url)).forward(request, response);
				return;
			}

			// login
			String email = request.getParameter("username");
			String password = request.getParameter("password");
			String remember = request.getParameter("remember");
			session.setAttribute("remember", remember);
			MyCookie cookie = new MyCookie(request, response);
			cookie.saveCookie("username", email, remember);
			
			User user = new User(email, password);
			Account acc = null;
			//validate username and password 
			if (!user.validate()) {
				url = "login";
			} else {
				acc = user.login();
				role = acc.getRole();
				if (role == 0) {
					url = "user";
				} else if (role == 1) {
					url = "index";
				} else {
					url = "login";
				}
				mySession.setCheck(acc.getCheck());
			}
			message = user.getMessage();

			mySession.setUserName(email);
			mySession.setRole(role);
			mySession.setController(controller);
			mySession.setAction(url);
			mySession.setMessage(message);
			
			response.sendRedirect(mapUrl.getUrl(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
