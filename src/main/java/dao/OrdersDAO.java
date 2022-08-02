package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Order;
import model.Product;
import model.ProductOrder;

public class OrdersDAO {
	public void insertOrder (Order o, Cart c) throws Exception {
		ResultSet rs = null;
		DBContext context = new DBContext();
		Connection conn = context.getConnection();
		
		//1. insert into orders table
		String sql = "insert into orders "
				+ "(user_mail, order_status, order_discount_code, order_address)"
				+ "values (?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
		psmt.setString(1, o.getUserMail());
		psmt.setInt(2, o.getStatus());
		psmt.setString(3, o.getDiscount());
		psmt.setString(4, o.getAddress());
		psmt.execute();
		
		//2. insert into order_detail table
		
		rs = psmt.getGeneratedKeys();
		int id = 1;
		if (rs.next()) {
			id = rs.getInt(1);
		}
	
		List<Product> items = c.getItems();	
	
		//psmt.setInt(4, );
		for (Product p : items) {
			String sql2 = "insert into orders_detail "
					+ "(order_id, product_id, amount_product, price_product) "
					+ "values (?, ?, ?, ?)";
			PreparedStatement psmt2 = conn.prepareStatement(sql2);
			psmt2.setInt(1, id);
			psmt2.setInt(2, p.getId());
			psmt2.setInt(3, p.getNumber());
			psmt2.setDouble(4, p.getPrice());
			
			psmt2.execute();
			psmt2.close();
		}
		rs.close();
		psmt.close();
		conn.close();
	}
	
	
	public List<ProductOrder> getProductOders (String orderId) throws Exception {
		List<ProductOrder> lp = new ArrayList<ProductOrder>();
		Connection conn = new DBContext().getConnection();
		String sql = "select * from orders_detail where order_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, orderId);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String idProduct = rs.getString("product_id");		
			String name = new ListProductDAO().getProduct(idProduct).getName();
			
			lp.add(new ProductOrder(
					rs.getInt("order_id"), 
					rs.getInt("product_id"), 
					rs.getInt("amount_product"), 
					rs.getFloat("price_product"), 
					name
					));
		}
		rs.close();
		ps.close();
		conn.close();
		
		return lp;
	}
	
	public List<Order> search(String email) throws Exception {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = new DBContext().getConnection();
		String sql = "select * from orders where user_mail = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int orderId = rs.getInt("order_id");
			float price = 0;
			List<ProductOrder> lp = getProductOders(orderId + "");
			for (ProductOrder p : lp) {
				price += p.getPrice() * p.getAmoutProduct();
			}
			
			orders.add(new Order(
					orderId, 
					price, 
					rs.getInt("order_status"), 
					rs.getDate("order_date"), 
					rs.getString("order_address"), 
					null, 
					lp, 
					rs.getString("user_mail"), 
					null
					));			
		}
		rs.close();
		ps.close();
		conn.close();
		
		return orders;
	}

}
