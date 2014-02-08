package ro.gameon.service.webservice;

import ro.gameon.model.ProductBean;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 12:57 PM
 */
@Path("/product")
@Produces("application/json")
public interface SaveProductService {


	@POST
	@Consumes("application/json")
	@Path("/saveProduct.json")
	public Long saveContact(ProductBean productBean);
}
