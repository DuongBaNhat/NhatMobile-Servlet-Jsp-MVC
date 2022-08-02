package model;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

public class MySession implements Serializable {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private int page;
	private int pageAll;
	
	public MySession(HttpSession session) {
		this.session = session;
		this.page = 1;
		this.pageAll = 1;
		session.setAttribute("page", this.page);
		session.setAttribute("pageAll", this.pageAll);
		//session.setAttribute("email", "Login");
	}	
	public void setAccounts(List<Account> accounts) {
		session.setAttribute("accounts", accounts);
	}
	
	public void setAddProduct(int addProduct) {
		session.setAttribute("addproduct", addProduct);
	}
	public void setUpdate(int update) {
		session.setAttribute("update", update);
	}
	public void setCheck(int check) {
		session.setAttribute("check", check);
	}

	public void setCart(Cart cart) {
		session.setAttribute("cart", cart);
	}
	
	public Cart getCart() {
		return (Cart) session.getAttribute("cart");
	}
	
		
	/**
	 * --1--
	 * @param action
	 */
	public void setAction(String action) {
		session.setAttribute("action", action);
	}
	public String getAction() {
		return (String)session.getAttribute("action");
	}
	/**
	 * --2--
	 * @param controller
	 */
	public void setController(String controller) {
		session.setAttribute("controller", controller);
	}
	
	public void setControlsrc(String controlsrc) {
		session.setAttribute("controlsrc", controlsrc);
	}
	public String getController() {
		return (String)session.getAttribute("controller");
	}
	/**
	 * --3--
	 * @param message
	 */
	public void setMessage(String message) {
		session.setAttribute("message", message);
	}
	
	/**
	 * --4--
	 * @param page
	 */
	public void setPage(int page) {
		session.setAttribute("page", page);
	}
	
	/**
	 * --5--
	 * @param pageAll
	 */
	public void setPageAll(int pageAll) {
		this.pageAll = pageAll;
		session.setAttribute("pageAll", pageAll);
	}
	
	/**
	 * --6--
	 * @param productAll
	 */
	public void setProductAll(int productAll) {
		session.setAttribute("productAll", productAll);
	}
	/**
	 * --7--
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		session.setAttribute("products", products);
	}
	public void setProductId(String productId) {
		session.setAttribute("productId", productId);
	}
	
	public void setProduct(Product product) {
		session.setAttribute("product", product);
	}
	public void setProductNumber(int number) {
		session.setAttribute("productnumber", number);
	}
	
	/**
	 * --8--
	 * @param type
	 */
	public void setType(String type) {
		session.setAttribute("type", type);
	}
	
	/**
	 * --9--
	 * @param vsearch
	 */
	public void setVsearch(String vsearch) {
		session.setAttribute("vsearch", vsearch);
	}	
	
	public void setOrders(List<Order> orders) {
		session.setAttribute("orders", orders);
	}

	public void setRole(int role) {
		session.setAttribute("role", role);
	}
	public void setUserName(String email) {
		session.setAttribute("username", email);
		
	}
	
}
