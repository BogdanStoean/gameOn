package ro.gameon.dao;

import ro.gameon.entity.User;

import java.util.List;

/**
 * Created by bogdan on 1/29/14.
 */
public class UserDao extends GenericDao {

	public List<User> listAll() {
		return executeQuery("from User", User.class);
	}

	public User getByUsernameAndPassword(String username, String password) {

		List<User> users = executeQuery("from User u where u.username = ?  and u.password = ?", User.class, username,
				password);

		if (users != null && users.size() == 1) {
			return users.get(0);
		}

		return null;
	}
}
