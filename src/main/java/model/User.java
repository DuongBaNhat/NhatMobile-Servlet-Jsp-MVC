package model;


import dao.AccountDAO;

public class User {
	private String email;
	private String password;
	private String message;

	public User() {
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public boolean validate() throws Exception {
		boolean result = false;
		// make sure that email is valid
		String regexEmail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regexPwd = "[a-zA-Z0-9_!@#%^&*]+";
		if (email == null) {
			message = "Email is null";
		} else if (password == null) {
			message = "Password is null";
		} else if (!email.matches(regexEmail) || !password.matches(regexPwd)) {
			message = "Email invalid syntex";
		} else if (!password.matches(regexPwd)) {
			message = "Password is invalid syntex";
		} else {

			result = true;
		}

		return result;
	}

	public String getMessage() {
		return message;
	}
	
	public Account login() throws Exception {
		AccountDAO dao = new AccountDAO();
		Account acc = dao.getAccount(email);
		if (acc == null) {
			acc = new Account();
			message = "Account is not exists.";
		} else {
			if (this.password.equals(acc.getPassword())) {
				acc.setCheck(1);
				message = "Login successfully";
			} else {
				acc = new Account();
				message = "Incorrect password";
			}
		}
		acc.setMessage(message);
		return acc;
	}
	
	
}
