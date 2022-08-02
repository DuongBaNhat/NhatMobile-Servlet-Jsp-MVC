package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id; //id of order
	private String userMail; //byer's email
	private int status;
	private Date orderDate; //date order
	private String address; //byer's address
	private String discount;
	
	private String phoneNumber;
	private List<ProductOrder> lp;
	private Date receivedDate;
	private float price;//total amount of order
	
	public Order() {
		super();
	}

	
	public Order(int status, String address, String phoneNumber, String userMail, 
			Date receivedDate, String discount) {
		super();
		this.status = status;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userMail = userMail;
		this.receivedDate = receivedDate;
		this.discount = discount;
	}


	public Order(int id, float price, int status, Date orderDate, String address, 
			String phoneNumber,	List<ProductOrder> lp, String userMail, Date receivedDate) {
		super();
		this.id = id;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.userMail = userMail;
		this.receivedDate = receivedDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public List<ProductOrder> getLp() {
		return lp;
	}


	public void setLp(List<ProductOrder> lp) {
		this.lp = lp;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public Date getReceivedDate() {
		return receivedDate;
	}


	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
	
	
	
}
