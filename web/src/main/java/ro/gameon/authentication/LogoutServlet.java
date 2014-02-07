package ro.gameon.authentication;

import ro.gameon.model.LoginBean;
import ro.gameon.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 4:35 PM
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		SessionUtil.setLoggedUser(request, null);
	}

}
