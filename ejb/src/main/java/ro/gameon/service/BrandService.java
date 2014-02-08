package ro.gameon.service;

import ro.gameon.entity.Brand;

import javax.ejb.Local;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:44 AM
 */
@Local
public interface BrandService {

	List<Brand> listAll();
}
