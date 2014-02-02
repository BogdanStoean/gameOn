package ro.gameon.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.entity.Product;
import ro.gameon.service.ProductService;
import ro.gameon.util.DataTableResult;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by bogdan on 2/2/14.
 */
@WebServlet(name = "ListProductsServlet", urlPatterns = "/products")
public class ListProductsServlet extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = productService.listProducts(0, 10);
        mapper.writeValue(response.getOutputStream(), new DataTableResult<Product>(products));

    }
}
