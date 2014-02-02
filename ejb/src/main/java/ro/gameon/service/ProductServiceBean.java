package ro.gameon.service;

import ro.gameon.dao.ProductDao;
import ro.gameon.entity.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by bogdan on 2/2/14.
 */
@Stateless
public class ProductServiceBean implements ProductService {

    @Inject
    private ProductDao productDao;

    @Override
    public List<Product> listProducts(int start, int limit) {
        return productDao.listAllProduct(start, limit);
    }
}
