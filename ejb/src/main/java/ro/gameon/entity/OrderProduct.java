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

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 8:02 PM
 */
@Entity
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_PRODUCTS_SEQ_GEN")
	@SequenceGenerator(name = "ORDER_PRODUCTS_SEQ_GEN", sequenceName = "SEQ_ORDER_PRODUCTS", allocationSize = 1)
	private Long id;


	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;


	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
