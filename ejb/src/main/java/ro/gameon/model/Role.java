package ro.gameon.model;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 8:39 PM
 */
public enum Role {

	ADMIN("Application administrator"),
	USER("Application customer");

	private String role;

	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
