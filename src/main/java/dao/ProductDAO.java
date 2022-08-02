package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import context.DBContext;
import model.Product;

public class ProductDAO {

	public int insertProduct (Product o) throws Exception {
		int result = 0;
		DBContext context = new DBContext();
		Connection conn = context.getConnection();
		
		//1. insert into orders table
		String sql = "insert into products "
				+ "(product_name, product_des, product_price, product_img_source, "
				+ "product_type, product_brand, product_number) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, o.getName());
		psmt.setString(2, o.getDescription());
		psmt.setFloat(3, o.getPrice());
		psmt.setString(4, o.getSrc());
		psmt.setString(5, o.getType());
		psmt.setString(6, o.getBrand());
		psmt.setInt(7, o.getNumber());
		
		result = psmt.executeUpdate();
		
		
		
		psmt.close();
		conn.close();
		return result;
	}
	
	public int updateProduct (Product o) throws Exception {
		
		DBContext context = new DBContext();
		Connection conn = context.getConnection();

		String sql = "update products set "
				+ "product_name = ?, "
				+ "product_des = ?, "
				+ "product_price = ?, "
				+ "product_img_source = ?, "
				+ "product_type = ?, "
				+ "product_brand = ?, "
				+ "product_number = ? "
				+ "where product_id = ? "
				+ "and product_delete = ?";

		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, o.getName());
		psmt.setString(2,o.getDescription());
		psmt.setFloat(3, o.getPrice());
		psmt.setString(4, o.getSrc());
		psmt.setString(5, o.getType());
		psmt.setString(6, o.getBrand());
		psmt.setInt(7, o.getNumber());
		psmt.setInt(8, o.getId());
		psmt.setInt(9, 0);
		
		int result = psmt.executeUpdate();
		
		
		
		psmt.close();
		conn.close();
		return result;
	}
	
	public int updateNumber(int id, int number) throws Exception {
		int result = 0;
		if (id <= 0 || number <0) {
			result = -1;
			return result;
		}
		
		DBContext context = new DBContext();
		Connection conn = context.getConnection();
		String sql = "update products "
				+ "set "
				+ "product_number = ? "
				+ "where product_id = ? "
				+ "and product_delete = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, number);
		ps.setInt(2, id);
		ps.setInt(3, 0);
		
		result = ps.executeUpdate();
		
		ps.close();
		conn.close();
		return result;
	}

	public int deleteProduct(int id) throws Exception {
		int result = 0;
		DBContext context = new DBContext();
		Connection conn = context.getConnection();
		String sql = "update products set product_delete = ? where product_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, id);
		
		result = ps.executeUpdate();
		
		ps.close();
		conn.close();
		return result;
	}
}
