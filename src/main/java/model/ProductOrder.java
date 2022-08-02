package model;

public class ProductOrder {
	private int orderId;
	private int productId;
	private int amoutProduct; // quantity of selected product
	private float price;
	private String nameProduct;
	
	public ProductOrder(int orderId, int productId, int amoutProduct, float price, String nameProduct) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amoutProduct = amoutProduct;
		this.price = price;
		this.nameProduct = nameProduct;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmoutProduct() {
		return amoutProduct;
	}

	public void setAmoutProduct(int amoutProduct) {
		this.amoutProduct = amoutProduct;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	
	
}
