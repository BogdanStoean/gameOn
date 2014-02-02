package ro.gameon.service;

import ro.gameon.entity.Product;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bogdan on 2/2/14.
 */
@Local
public interface ProductService {

    List<Product> listProducts(int start, int limit);
}
