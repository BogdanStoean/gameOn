package ro.gameon.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: bogdan
 * Date: 2/6/14
 * Time: 6:27 PM
 */
public class LoginBean implements Serializable {

	private UserBean userBean;
	private Set<Long> shoppingCart = new HashSet<Long>();
	private int shoppingCartSize = 0;


	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Set<Long> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Set<Long> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public int getShoppingCartSize() {
		return shoppingCart.size();
	}

	public void setShoppingCartSize(int shoppingCartSize) {
		this.shoppingCartSize = shoppingCartSize;
	}
}
