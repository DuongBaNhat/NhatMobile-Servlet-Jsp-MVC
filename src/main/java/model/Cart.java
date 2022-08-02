package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items; //list of item in cart
	
	public Cart() {
		items = new ArrayList<Product>();
	}
	public void setNumber(int id, int number) {
		if(number < 0) {
			return;
		}
		for (Product x : items) {
			if (x.getId() == id) {
				x.setNumber(number);
				if(number == 0) {
					items.remove(x);
				}
				return;
			}
		}
	}
	//1. add a new product to cart
	public void add (Product ci) {
		if(ci == null) {
			return;
		}
		for (Product x : items) {
			if(x.getId() == ci.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		ci.setNumber(1);
		items.add(ci);
	}
	
	
	/**
	 * Add a product to cart follow id
	 * @param id
	 */
	public void add(int id) {
		for (Product x : items) {
			if (x.getId() == id) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
	}
	
	//2. remove a product from cart
	public void remove (int id) {
		for (Product x : items) {
			if (x.getId() == id) {				
				if(x.getNumber() > 0) {
					x.setNumber(x.getNumber() - 1);
				}
				if(x.getNumber() == 0) {
					items.remove(x);
				}
				
				return;
			}
		}
	}
	public void remove (int id, int number) {
		for (Product x : items) {
			if (x.getId() == id) {
				if (number == -1 || number >= x.getNumber()) {
					x.setNumber(0);					
				} else if (number > 0 & number < x.getNumber()){
					x.setNumber(x.getNumber() - number);
				}
				
				if (x.getNumber() == 0) {
					this.items.remove(x);
				}
				return;
			}
		}
	}
	
	//3. return total amount of cart
	public double getAmount() {
		double sum = 0;
		for (Product x : items) {
			sum += x.getNumber() * x.getPrice();
		}
		sum = Math.round(sum * 100.0) / 100.0;
		return sum;
	}
	//4. return list of products in cart
	public List<Product> getItems() {
		return items;
	}
	//5. return product in list items
	public Product getProduct (int id) {
		for (Product x : items) {
			if (x.getId() == id) {
				return x;
			}
		}
		return null;
	}
	
	public int getProductAll() {
		int sum = 0;
		for (Product x : items) {
			sum += x.getNumber();
		}
		return sum;
	}
}
