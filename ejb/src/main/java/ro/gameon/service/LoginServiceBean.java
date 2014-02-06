package ro.gameon.service;

import ro.gameon.entity.User;
import ro.gameon.model.LoginBean;
import ro.gameon.model.UserBean;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 * User: bogdan
 * Date: 2/6/14
 * Time: 6:39 PM
 */
@Stateless
public class LoginServiceBean implements LoginService {


	@EJB
	private UserService userService;

	@Override
	public LoginBean doLogin(String username, String password) {

		User user = userService.getByUsernameAndPassword(username, password);
		if (user != null) {
			UserBean userBean = new UserBean(user);
			LoginBean loginBean = new LoginBean();
			loginBean.setUserBean(userBean);
			return loginBean;
		}
		return null;
	}
}
