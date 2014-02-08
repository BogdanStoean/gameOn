package ro.gameon.util;

import ro.gameon.model.LoginBean;

import javax.servlet.http.HttpServletRequest;

/**
 * User: bogdan
 * Date: 2/6/14
 * Time: 7:11 PM
 */
public class SessionUtil {

	public static final void setLoggedUser(HttpServletRequest request, LoginBean loginBean) {
		request.getSession().setAttribute("_gameOnLoggedUser", loginBean);
	}

	public static final LoginBean getLoggedUser(HttpServletRequest request) {
		return (LoginBean) request.getSession().getAttribute("_gameOnLoggedUser");

	}

}
