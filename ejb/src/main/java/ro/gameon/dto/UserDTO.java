package ro.gameon.dto;

import ro.gameon.entity.User;

/**
 * User: bogdan
 * Date: 2/7/14
 * Time: 8:17 PM
 */
public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String address;

	private String role;

	public UserDTO() {

	}

	public UserDTO(String username, String password, String firstName, String lastName, String email,
			String address, String role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUserFromDTO() {
		User user = new User();
		user.setUsername(this.getUsername());
		user.setPassword(this.getPassword());
		user.setAddress(this.getAddress());
		user.setEmail(this.getEmail());
		user.setFirstName(this.getFirstName());
		user.setLastName(this.getLastName());
		user.setRole(this.getRole());
		return user;
	}


}
