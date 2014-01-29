package ro.gameon.dao;

import ro.gameon.entity.User;

import java.util.List;

/**
 * Created by bogdan on 1/29/14.
 */
public class UserDao extends GenericDao {

    public List<User> listAll() {
        return executeQuery("from User u", User.class);
    }
}
