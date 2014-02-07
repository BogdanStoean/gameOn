package ro.gameon.products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/5/14
 * Time: 8:07 PM
 */
@WebServlet(name = "ProductDetailsPageServlet", urlPatterns = "/getPage")
public class ProductDetailsPageServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("productDetails.jsp").forward(request, response);
	}

}
