package dao.bean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class PageIndex {
	private int page;
	private int size;
	private String type;
	private int productAll;
	
	public PageIndex() {
		page = 1;
		size = 8;
		productAll = 0;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getProductAll() {
		return productAll;
	}
	
	/**
	 * List<Product> getAllProduct()
	 * @return list products in one page
	 * @throws Exception
	 */
	public List<Product> getAllProduct() throws Exception {
		List<Product> products = new ArrayList<Product>();
		int from = (page - 1) * size + 1;
		int to = page * size;
		
		Connection conn = new DBContext().getConnection();
		CallableStatement cs = conn.prepareCall("{call GetProducts(?, ?)}");
		cs.setInt(1, from);		
		cs.setInt(2, to);
		
		ResultSet rs = cs.executeQuery();
				
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
			
			products.add(p);
		}
		rs.close();
		cs.close();
		conn.close();
		return products;
	}
	
	/**
	 * int getPageAll()
	 * @return quantity page
	 * @throws Exception
	 */
	public int getPageAll() throws Exception {
		int pageAll = 1, row = 0;
		String sql = "select count(*) as count from products where product_delete = ?";
		Connection conn;
		
		conn = new DBContext().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 0);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			row = rs.getInt("count");
		}
		
		rs.close();
		ps.close();
		conn.close();
		pageAll = (int) (row < size ? 1 : Math.ceil((row*1.0) / size))	;
		return pageAll;
	}
	/**
	 * getProductsType()
	 * @return list of products in category
	 * @throws Exception
	 */
	public List<Product> getProductsType() throws Exception {
		List<Product> products = new ArrayList<Product>();
		int from = (page - 1) * size + 1;
		int to = page * size;
		
		DBContext context = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		context = new DBContext();
		conn = context.getConnection();
		cs = conn.prepareCall("{call GetProductsType(?, ?, ?)}");
		cs.setInt(1, from);
		cs.setInt(2, to);
		cs.setString(3, this.type);
		
		rs = cs.executeQuery();
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
			
			products.add(p);
		}
		conn.close();
		cs.close();
		rs.close();
		return products;
	}
	
	/**
	 * 
	 * @return quantity page
	 * @throws Exception
	 */
	public int getPageType() throws Exception {
		int pageType = 1, row = 0;
		DBContext context = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		context = new DBContext();
		conn = context.getConnection();
		String sql = "select count(*) as count from products where product_type = ? and product_delete = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 0);
		
		ps.setString(1, this.type);
		rs = ps.executeQuery();
		if (rs.next()) {
			row = rs.getInt("count");
		}
		
		this.productAll = row;
		pageType = (int) (row < this.size ? 1 : Math.ceil((row * 1.0) / this.size));
		
		conn.close();
		ps.close();
		rs.close();
		return pageType;
	}
	
}
