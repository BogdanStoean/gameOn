package ro.gameon.users;

import ro.gameon.dto.UserDTO;
import ro.gameon.entity.User;
import ro.gameon.model.Role;
import ro.gameon.service.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 7:56 PM
 */

@WebServlet("/saveAccount.json")
public class SaveAccountServlet extends HttpServlet {

	@EJB
	private UserService userService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		UserDTO userDTO = new UserDTO(username, password, firstName, lastName, email, address, Role.USER.toString());
		userService.saveOrUpdate(userDTO.getUserFromDTO());

	}
}
