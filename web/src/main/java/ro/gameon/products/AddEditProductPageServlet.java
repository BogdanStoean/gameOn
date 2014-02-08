package ro.gameon.products;

import ro.gameon.entity.Product;
import ro.gameon.service.ProductService;
import ro.gameon.util.ConverterUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:28 AM
 */
@WebServlet("/addProduct")
public class AddEditProductPageServlet extends HttpServlet {


	@EJB
	private ProductService productService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		Long productId = ConverterUtil.getLongFromString(request.getParameter("productId"));
		if (productId != null && productId.compareTo(0L) > 0) {
			Product product = productService.getById(productId);
			request.getSession().setAttribute("product", product);
		} else {
			request.getSession().setAttribute("product", null);
		}

		request.getSession().setAttribute("productId", productId);
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}
}
