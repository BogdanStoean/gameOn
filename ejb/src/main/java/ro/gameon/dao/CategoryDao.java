package ro.gameon.dao;

import ro.gameon.entity.Category;

import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:38 AM
 */
public class CategoryDao extends AbstractDao {

	public List<Category> listAll() {
		return executeQuery("from Category", Category.class);
	}
}
