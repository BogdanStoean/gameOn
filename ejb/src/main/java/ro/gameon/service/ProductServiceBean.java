package ro.gameon.service;

import ro.gameon.dao.ProductDao;
import ro.gameon.dao.UserProductDao;
import ro.gameon.entity.Product;
import ro.gameon.entity.UserProduct;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 2/2/14.
 */
@Stateless
public class ProductServiceBean implements ProductService {

	@Inject
	private ProductDao productDao;


	@Inject
	private UserProductDao userProductDao;

	@Override
	public List<Product> listProducts(int start, int limit) {
		return productDao.listAllProduct(start, limit);
	}

	@Override
	public Long countProducts() {
		return productDao.countAllProducts();
	}

	@Override
	public List<Product> listProductsByUserId(int start, int limit, Long userId) {
		List<Product> products = new ArrayList<Product>();
		List<UserProduct> userProducts = userProductDao.listProductsByUserId(start, limit, userId);
		for(UserProduct userProduct : userProducts) {
			products.add(userProduct.getProduct());
		}
		return products;
	}

	@Override
	public Long countProductsByUserId(Long userId) {
		return userProductDao.countProductsByUserId(userId);
	}
}
