package ro.gameon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 7:55 PM
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GEN")
	@SequenceGenerator(name = "ORDER_SEQ_GEN", sequenceName = "SEQ_ORDER", allocationSize = 1)
	private Long id;

	@Column(name = "ORDER_NAME")
	private String orderName;

	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@Column(name = "ORDER_VALUE")
	private Double orderValue;

	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User owner;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
