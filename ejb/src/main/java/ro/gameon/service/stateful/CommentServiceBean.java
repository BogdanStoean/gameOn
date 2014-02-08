package ro.gameon.service.stateful;

import ro.gameon.entity.Comment;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 6:30 PM
 */
@Stateful
public class CommentServiceBean implements CommentService {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;

	@Override
	public void addComment(Comment comment) {
		entityManager.merge(comment);
	}

	@Override
	public List<Comment> listAllComments() {
		return entityManager.createQuery("from Comment", Comment.class).getResultList();
	}
}
