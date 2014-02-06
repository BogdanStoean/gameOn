package ro.gameon.model;

import ro.gameon.entity.User;

/**
 * User: bogdan
 * Date: 2/6/14
 * Time: 6:27 PM
 */
public class UserBean {

	private Long userId;
	private String username;


	public UserBean(Long userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public UserBean(User user) {
		this(user.getId(), user.getUsername());
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
