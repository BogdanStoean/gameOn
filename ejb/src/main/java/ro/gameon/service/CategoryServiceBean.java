package ro.gameon.service;

import ro.gameon.dao.CategoryDao;
import ro.gameon.entity.Category;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:42 AM
 */
@Stateless
public class CategoryServiceBean implements CategoryService {


	@Inject
	private CategoryDao categoryDao;

	@Override
	public List<Category> listAll() {
		return categoryDao.listAll();
	}
}
