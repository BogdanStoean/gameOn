package ro.gameon.orders;

import ro.gameon.entity.Product;
import ro.gameon.util.ConverterUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 10:17 PM
 */
@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("createOrder.jsp").forward(request, response);
	}
}
