package ro.gameon.dao;

import ro.gameon.entity.Product;

import java.util.List;

/**
 * Created by bogdan on 2/2/14.
 */
public class ProductDao extends AbstractDao {

	public List<Product> listAllProduct(int start, int limit) {
		return listPaginated("from Product", Product.class, start, limit);
	}

	public Long countAllProducts() {
		return executeSingleResultQuery("select count(p) from Product p", Long.class);
	}

}
