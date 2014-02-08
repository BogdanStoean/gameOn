package ro.gameon.service;

import ro.gameon.dao.BrandDao;
import ro.gameon.entity.Brand;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:45 AM
 */

@Stateless
public class BrandServiceBean implements BrandService {


	@Inject
	private BrandDao brandDao;

	@Override
	public List<Brand> listAll() {
		return brandDao.listAll();
	}
}
