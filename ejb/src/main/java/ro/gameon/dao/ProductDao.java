package ro.gameon.dao;

import ro.gameon.entity.Product;

import java.util.List;
import java.util.Set;

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

	public List<Product> listByProductIds(Set<Long> productIds) {
		String hql = "from Product p where p.id in ( ";
		int count = 0;
		for(Long productId : productIds) {
			hql += productId;
			if (count < productIds.size() - 1) {
				hql += ", ";
			} else {
				hql += " ";
			}
			count++;
		}
		hql += " )";

		return executeQuery(hql, Product.class);
	}
}
