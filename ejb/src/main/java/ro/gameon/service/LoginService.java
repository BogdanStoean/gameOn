package ro.gameon.service;

import ro.gameon.model.LoginBean;

import javax.ejb.Stateful;

/**
 * User: bogdan
 * Date: 2/6/14
 * Time: 6:37 PM
 */
public interface LoginService {

	LoginBean doLogin(String username, String password);
}
