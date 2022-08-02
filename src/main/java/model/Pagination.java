package model;

import java.util.ArrayList;
import java.util.List;

import dao.ListProductDAO;

/**
 * public void setPage(int page)<br>
 * public void setSize(int size)<br>
 * public int getPageAll()<br>
 * public List<Product> search(String charactor, String type)<br>
 * public List<Product> search(String charactor)<br>
 * 
 * @author Minh Tuyen
 *
 */
public class Pagination {
	int page, size, pageAll, productAll;

	public Pagination() {
		page = 1;
		size = 8;
		pageAll = 1;
		productAll = 0;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPageAll() {
		return pageAll;
	}
	
	public int getProductAll() {
		return productAll;
	}
	
	
	/**
	 * class Pagination
	 * @param charactor
	 * @return list products in one page
	 * @throws Exception
	 */
	public List<Product> search(String charactor, String type) throws Exception {
		List<Product> listP = new ArrayList<Product>();
		ListProductDAO dao = new ListProductDAO();
		List<Product> products = dao.search(charactor, type);
		int from = (page - 1) * size;
		int to = page * size;
		
		for (int i = from; i < products.size(); i++) {
			if (i >= to) {
				break;
			}
			listP.add(products.get(i));
		}
		
		int row = products.size();
		pageAll = (int) (row < size ? 1 : Math.ceil((row * 1.0) / size));
		productAll = row;
		return listP;
	}
	
	/**
	 * search(String charactor) -- class Pagination
	 * @param charactor
	 * @return list products in one page
	 * @throws Exception
	 */
	public List<Product> search(String charactor) throws Exception {
		return search(charactor, null);
	}
	
	
}
