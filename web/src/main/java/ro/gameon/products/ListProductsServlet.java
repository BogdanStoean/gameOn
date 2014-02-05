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
		int limit = ConverterUtil.getIntFromString(limitParam);
		int start = ConverterUtil.getIntFromString(startParam);


		List<Product> products = productService.listProducts(start, limit);
		Long count = productService.countProducts();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), new DataTableResult<Product>(products,count));
	}
}
