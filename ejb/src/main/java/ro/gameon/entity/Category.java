package ro.gameon.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bogdan on 2/2/14.
 */

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ_GEN")
	@SequenceGenerator(name = "CATEGORY_SEQ_GEN", sequenceName = "SEQ_CATEGORY", allocationSize = 1)
	private Long id;

	@Column(name = "CATEGORY_CODE", nullable = false)
	private String categoryCode;

	@Column(name = "CATEGORY_NAME", nullable = false)
	private String categoryName;


	public Category() {
	}

	public Category(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
