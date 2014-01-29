package ro.gameon.service;

import ro.gameon.dao.UserDao;
import ro.gameon.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * User: bogdan
 * Date: 1/24/14
 * Time: 10:40 AM
 */
@Stateless
public class UserServiceBean implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }
}
