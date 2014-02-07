package ro.gameon.authentication;

import ro.gameon.model.LoginBean;
import ro.gameon.service.LoginService;
import ro.gameon.service.stateful.CurrentLoggedUserBean;
import ro.gameon.util.SessionUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/6/14
 * Time: 6:09 PM
 */
@WebServlet("/authentication")
public class LoginServlet extends HttpServlet {


	@EJB
	private CurrentLoggedUserBean currentLoggedUserBean;

	@EJB
	private LoginService loginService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = loginService.doLogin(username, password);
		currentLoggedUserBean.setLoginBean(loginBean);
		SessionUtil.setLoggedUser(request, loginBean);
	}

}
