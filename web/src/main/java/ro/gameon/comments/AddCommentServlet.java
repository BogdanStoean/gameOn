package ro.gameon.comments;

import ro.gameon.entity.Comment;
import ro.gameon.service.stateful.CommentService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 6:40 PM
 */
@WebServlet("/comment/save")
public class AddCommentServlet extends HttpServlet {


	@EJB(lookup = "java:app/ejb/CommentServiceBean!ro.gameon.service.stateful.CommentService")
	private CommentService commentService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String comm = request.getParameter("comment");
		Comment comment = new Comment();
		comment.setComment(comm);
		commentService.addComment(comment);
	}
}
