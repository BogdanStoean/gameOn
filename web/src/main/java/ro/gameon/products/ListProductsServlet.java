package ro.gameon.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.entity.Product;
import ro.gameon.service.ProductService;
import ro.gameon.util.ConverterUtil;
import ro.gameon.util.DataTableResult;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by bogdan on 2/2/14.
 */
@WebServlet("/products/list.json")
public class ListProductsServlet extends HttpServlet {

	@EJB
	private ProductService productService;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String limitParam = request.getParameter("limit");
		String startParam = request.getParameter("start");
		String userIdParam = request.getParameter("userId");
		String tab = request.getParameter("tabId");
		int limit = ConverterUtil.getIntFromString(limitParam);
		int start = ConverterUtil.getIntFromString(startParam);
		Long userId = ConverterUtil.getLongFromString(userIdParam);
		Long tabId = ConverterUtil.getLongFromString(tab);

		List<Product> products = new ArrayList<Product>();
		Long count = 0L;
		if (tabId == null || tabId.equals(0L)) {
			products = productService.listProducts(start, limit);
			count = productService.countProducts();
		} else if (tabId.equals(1L)) {
			if (userId != null) {
				products = productService.listProductsByUserId(start, limit, userId);
				count = productService.countProductsByUserId(userId);
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), new DataTableResult<Product>(products, count));
	}
}
