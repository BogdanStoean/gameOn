package ro.gameon.service.stateful;

import ro.gameon.model.LoginBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 9:59 AM
 */
@Stateful
@LocalBean
public class CurrentLoggedUserBean {

	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
}
