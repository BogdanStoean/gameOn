package ro.gameon.dao;

import ro.gameon.entity.Comment;

import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 6:47 PM
 */
public class CommentDao extends AbstractDao {

	public List<Comment> listAll() {
		return executeQuery("from Comment", Comment.class);
	}
}
