package ro.gameon.dao;

import ro.gameon.entity.Brand;

import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:40 AM
 */
public class BrandDao extends AbstractDao {

	public List<Brand> listAll() {
		return executeQuery("from Brand", Brand.class);
	}
}
