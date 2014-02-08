package ro.gameon.brands;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.entity.Brand;
import ro.gameon.service.BrandService;

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
 * Time: 11:47 AM
 */
@WebServlet("/brands/list.json")
public class ListBrandsServlet extends HttpServlet {


	@EJB
	private BrandService brandService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Brand> brands = brandService.listAll();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), brands);
	}

}
