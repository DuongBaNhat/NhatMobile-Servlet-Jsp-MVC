package model;

import java.util.HashMap;
import java.util.Map;

public class MapUrl {
	Map<String, String> map;

	public MapUrl() {
		map = new HashMap<String, String>();
		map.put("home", "home.jsp");
		map.put("product", "product.jsp");
		map.put("about", "about.jsp");
		map.put("login", "login.jsp");
		map.put("logout", "login.jsp");
		map.put("register", "register.jsp");
		map.put("index", "admin/index.jsp");	
		map.put("list", "list.jsp");
		map.put("listadmin", "admin/list.jsp");		
		//map.put("staff", "admin/staff.jsp");	
		
		map.put("searchAdmin", "admin/search_admin.jsp");
		map.put("searchList", "search_admin.jsp");		
		
		map.put("infoProduct", "infoProduct.jsp");
		map.put("cart", "cart.jsp");
		map.put("user", "pay.jsp");
		map.put("user", "user/indexuser.jsp");
		map.put("history", "user/history.jsp");
		map.put("search", "search.jsp");
		map.put("pay", "pay.jsp");
		map.put("update", "update.jsp");
		map.put("updatenumber", "admin/updatenumber.jsp");
		map.put("updatenumberSearch", "updatenumber.jsp");
		map.put("addproduct", "admin/addproduct.jsp");
		map.put("addproductSubmit", "addproduct.jsp");
		map.put("addproductSearch", "addproduct.jsp");
		
		map.put("deleteproduct", "deleteproduct.jsp");
		map.put("deleteproductadmin", "admin/deleteproduct.jsp");
		
		map.put("listaccount", "staff.jsp");

	}

	public String getUrl(String url) {
		if(url == null) {
			return null;
		}
		return map.get(url);
	}

	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
}
