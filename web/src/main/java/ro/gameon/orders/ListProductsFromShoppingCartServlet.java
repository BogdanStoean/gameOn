package ro.gameon.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.entity.Product;
import ro.gameon.model.LoginBean;
import ro.gameon.service.ProductService;
import ro.gameon.util.DataTableResult;
import ro.gameon.util.SessionUtil;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:05 PM
 */
@WebServlet("/orders/list.json")
public class ListProductsFromShoppingCartServlet extends HttpServlet {

	@EJB
	private ProductService productService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<Product> products = new ArrayList<Product>();
		LoginBean loginBean = SessionUtil.getLoggedUser(request);
		if (loginBean != null) {
			Set<Long> productIds = loginBean.getShoppingCart();
			if (productIds.size() > 0) {
				products = productService.listByProductIds(productIds);
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), new DataTableResult<Product>(products));
	}

}
