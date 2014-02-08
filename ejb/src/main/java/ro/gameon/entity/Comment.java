package ro.gameon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 6:27 PM
 */
@Entity
@Table(name = "COMMENTS")
public class Comment implements Serializable {


	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GEN")
	@SequenceGenerator(name = "COMMENT_SEQ_GEN", sequenceName = "SEQ_COMMENT", allocationSize = 1)
	private Long id;

	@Column(name = "COMMENT", nullable = false)
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
