package ro.gameon.service;

import ro.gameon.entity.Category;

import javax.ejb.Local;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 11:41 AM
 */
@Local
public interface CategoryService {

	List<Category> listAll();

}
