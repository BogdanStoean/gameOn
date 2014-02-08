package ro.gameon.service.webservice;

import ro.gameon.entity.Brand;
import ro.gameon.entity.Category;
import ro.gameon.entity.Product;
import ro.gameon.model.ProductBean;
import ro.gameon.service.ProductService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 1:05 PM
 */
@Stateless
public class SaveProductServiceBean implements SaveProductService {


	@EJB
	private ProductService productService;

	@Override
	public Long saveContact(ProductBean productBean) {
		return productService.saveProduct(getProductFromBean(productBean));
	}


	private Product getProductFromBean(ProductBean productBean) {
		Product product = new Product();
		product.setBannerLink(productBean.getBannerLink());
		product.setBrand(new Brand(productBean.getBrandId()));
		product.setCategory(new Category(productBean.getCategoryId()));
		product.setDescription(productBean.getDescription());
		product.setId(productBean.getId());
		product.setPictureLink(productBean.getPictureLink());
		product.setPrice(productBean.getPrice());
		product.setProductCode("PRODUCT_CODE");
		product.setProductName(productBean.getProductName());
		return product;
	}
}
