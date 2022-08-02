package model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyCookie {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public MyCookie(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

	}

	public String getValue(String cookieName) {
		String value = null;
		Cookie[] cookies = this.request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					value = c.getValue();
					break;
				}
			}
		}

		return value;
	}

	public void saveCookie(String cookieName, String value, String remember) throws UnsupportedEncodingException {
		try {
			Cookie[] cookies = this.request.getCookies();
			Cookie cookie = null;

			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals(cookieName)) {
						cookie = c;
						cookie.setValue(value);
						break;
					}
				}
			}

			if (cookie == null) {
				cookie = new Cookie(cookieName, value);
			}

			if (remember == null || !remember.equals("checked")) {
				cookie.setMaxAge(0);
			}
			this.response.addCookie(cookie);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setMaxAge(String cookieName, int time) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					c.setMaxAge(time);
					this.response.addCookie(c);
					break;
				}
			}
		}
	}
}
