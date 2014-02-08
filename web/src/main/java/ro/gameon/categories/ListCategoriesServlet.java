package ro.gameon.categories;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.entity.Category;
import ro.gameon.service.CategoryService;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:51 AM
 */
@WebServlet("/categories/list.json")
public class ListCategoriesServlet extends HttpServlet {

	@EJB
	private CategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Category> categories = categoryService.listAll();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), categories);
	}
}
