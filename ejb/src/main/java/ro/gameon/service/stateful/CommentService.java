package ro.gameon.service.stateful;

import ro.gameon.entity.Comment;

import javax.ejb.Local;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 6:26 PM
 */
@Local
public interface CommentService {

	void addComment(Comment comment);

	List<Comment> listAllComments();

}
