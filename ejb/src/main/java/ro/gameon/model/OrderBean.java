package ro.gameon.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 9:35 PM
 */
public class OrderBean implements Serializable {


	private static final long serialVersionUID = 6905559563442671900L;

	private List<Long> productIds;
	private Long userId;
	private String orderName;
	private Date orderDate;
	private Double orderValue;
	private String orderStatus;


	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderBean)) return false;

		OrderBean orderBean = (OrderBean) o;

		if (orderDate != null ? !orderDate.equals(orderBean.orderDate) : orderBean.orderDate != null) return false;
		if (orderName != null ? !orderName.equals(orderBean.orderName) : orderBean.orderName != null) return false;
		if (orderStatus != null ? !orderStatus.equals(orderBean.orderStatus) : orderBean.orderStatus != null)
			return false;
		if (orderValue != null ? !orderValue.equals(orderBean.orderValue) : orderBean.orderValue != null) return false;
		if (productIds != null ? !productIds.equals(orderBean.productIds) : orderBean.productIds != null) return false;
		if (userId != null ? !userId.equals(orderBean.userId) : orderBean.userId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = productIds != null ? productIds.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
		result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
		result = 31 * result + (orderValue != null ? orderValue.hashCode() : 0);
		result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "OrderBean{" +
				"productIds=" + productIds +
				", userId=" + userId +
				", orderName='" + orderName + '\'' +
				", orderDate=" + orderDate +
				", orderValue=" + orderValue +
				", orderStatus='" + orderStatus + '\'' +
				'}';
	}
}
