package ro.gameon.users;

import ro.gameon.entity.User;
import ro.gameon.service.UserService;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

/**
 * User: bogdan
 * Date: 1/24/14
 * Time: 10:43 AM
 */
@WebServlet(name = "ListUsersServlet", urlPatterns = "/users")
public class ListUsersServlet extends HttpServlet {

	@EJB
	private UserService userserviceBean;

	protected void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {

	}

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {
		List<User> users = userserviceBean.listAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}
}