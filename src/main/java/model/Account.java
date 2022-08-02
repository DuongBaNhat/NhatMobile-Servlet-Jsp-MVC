package model;

import dao.AccountDAO;

public class Account {
	private String user, password;
	private int role;
	private String name, address, phone;

	private int check;
	private String message;

	public Account() {
		this.role = -1;
	}

	public Account(String user, String password, int role, String name, String address, String phone, int check) {
		super();
		this.user = user;
		this.password = password;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.check = check;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Account register() throws Exception {
		
		AccountDAO dao = new AccountDAO();
		if (this.user != null) {
			if (dao.getAccount(this.user) != null) {
				message = "Account is exists";
			} else {
				boolean result = dao.insert(this);
				if (result) {
					message = "Register sucessfully";
				} else {
					message = "Register fail";
				}
			}

		} else {
			message = "User is empty";
		}
		this.setMessage(message);
		return this;
	}
}
