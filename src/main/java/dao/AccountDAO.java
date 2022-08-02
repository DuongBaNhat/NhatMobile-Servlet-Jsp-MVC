package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;

public class AccountDAO {
	public List<Account> search(String charactor) throws Exception {
		List<Account> accounts = new ArrayList<Account>();
		Connection conn = new DBContext().getConnection();
		String sql = "select * from account where user_mail like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + charactor + "%");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Account acc = new Account();
			acc.setUser(rs.getString("user_mail"));
			acc.setPassword(rs.getString("password"));
			acc.setRole(rs.getInt("account_role"));
			acc.setName(rs.getString("user_name"));
			acc.setAddress(rs.getString("user_address"));
			acc.setPhone(rs.getString("user_phone"));
			accounts.add(acc);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return accounts;
	}
	
	public Account getAccount(String email) throws Exception {
		Account account = null;
		Connection conn = new DBContext().getConnection();
		String sql = "select * from account where user_mail = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			account = new Account();
			account.setUser(rs.getString("user_mail"));
			account.setPassword(rs.getString("password"));
			account.setRole(rs.getInt("account_role"));
			account.setName(rs.getString("user_name"));
			account.setAddress(rs.getString("user_address"));
			account.setPhone(rs.getString("user_phone"));
		}
		rs.close();
		ps.close();
		conn.close();
		return account;
	}
	
	public boolean insert(Account account) throws Exception {
		boolean result = false;
		Connection conn = new DBContext().getConnection();
		String sql = "insert into account (user_mail, password, account_role, user_name, user_address, user_phone) "
				+ "values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account.getUser());
		ps.setString(2, account.getPassword());
		ps.setInt(3, account.getRole());
		ps.setString(4, account.getName());
		ps.setString(5, account.getAddress());
		ps.setString(6, account.getPhone());
		
		int rs = ps.executeUpdate();
		if (rs > 0) {
			result = true;
		}
		
		ps.close();
		conn.close();
		
		return result;
	}
	
	
}
