package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	//return list of products by product name
	public List<Product> search(String characters, String type) throws Exception {
		List<Product> listP = new ArrayList<Product>();
		DBContext context = new DBContext();
		Connection conn = context.getConnection();
		PreparedStatement psmt = null;
		String sql = "select * from products where product_name like ? and product_delete = ?";
		if(type != null && !type.equals("all")) {
			sql = "select * from products where product_name like ? and product_type = ? and product_delete = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + characters + "%");
			psmt.setString(2, type);
			psmt.setInt(3, 0);
		} else {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + characters + "%");
			psmt.setInt(2, 0);
		}
			
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("product_id"));
			p.setName(rs.getString("product_name"));
			p.setDescription(rs.getString("product_des"));
			p.setPrice(rs.getFloat("product_price"));
			p.setSrc(rs.getString("product_img_source"));
			p.setType(rs.getString("product_type"));
			p.setBrand(rs.getString("product_brand"));
			p.setNumber(rs.getInt("product_number"));
			listP.add(p);
		}
		rs.close();
		psmt.close();
		conn.close();
		return listP;
	}
	public List<Product> search(String characters) throws Exception{
		return search(characters, null);
	}
	//get the product
	public Product getProduct (String id) throws Exception {
		Product p = new Product();
		DBContext context = new DBContext();
		Connection conn = context.getConnection();
		String sql = "select * from products where product_id = ? and product_delete = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setInt(2, 0);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			p.setId(rs.getInt("product_id"));
			p.setName(rs.getString("product_name"));
			p.setDescription(rs.getString("product_des"));
			p.setPrice(rs.getFloat("product_price"));
			p.setSrc(rs.getString("product_img_source"));
			p.setType(rs.getString("product_type"));
			p.setBrand(rs.getString("product_brand"));
			p.setNumber(rs.getInt("product_number"));
		
		}
		
		rs.close();
		psmt.close();
		conn.close();
		return p;
	}
	
}
