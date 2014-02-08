package ro.gameon.model;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 9:41 PM
 */
public enum OrderStatus {

	NEW("New order"),
	PROCESSING("Processing order"),
	FINALIZED("Finalized order");

	private String status;

	OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
