package ro.gameon.service;

import ro.gameon.entity.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bogdan on 1/29/14.
 */
@Local
public interface UserService {

	List<User> listAll();

	User getByUsernameAndPassword(String username, String password);

	Long saveOrUpdate(User user);
}
