package ro.gameon.dao;

import ro.gameon.entity.UserProduct;

import java.util.List;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 6:51 PM
 */
public class UserProductDao extends AbstractDao {


	public List<UserProduct> listProductsByUserId(int start, int limit, Long userId) {
		return listPaginated("from UserProduct up where up.user.id = ?", UserProduct.class, start, limit, userId);
	}

	public Long countProductsByUserId(Long userId) {
		return executeSingleResultQuery("select count(up) from UserProduct up where up.user.id = ?", Long.class,
				userId);
	}
}
