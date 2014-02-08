package ro.gameon.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.model.LoginBean;
import ro.gameon.util.ConverterUtil;
import ro.gameon.util.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 3:14 PM
 */
@WebServlet("/addToCart.json")
public class AddToCartServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String productIdParam = request.getParameter("productId");
		Long productId = ConverterUtil.getLongFromString(productIdParam);
		if (productId != null && productId.compareTo(0L) > 0) {
			LoginBean loginBean = SessionUtil.getLoggedUser(request);
			loginBean.getShoppingCart().add(productId);
			SessionUtil.setLoggedUser(request, loginBean);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), "success");
	}

}
