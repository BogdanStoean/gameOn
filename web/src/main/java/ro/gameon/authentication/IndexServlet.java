package ro.gameon.authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 1:45 PM
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
