package ro.gameon.comments;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.gameon.entity.Comment;
import ro.gameon.service.stateful.CommentService;
import ro.gameon.util.DataTableResult;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 6:57 PM
 */
@WebServlet("/comments/list.json")
public class ListCommentsServlet extends HttpServlet {


	@EJB(lookup = "java:app/ejb/CommentServiceBean!ro.gameon.service.stateful.CommentService")
	private CommentService commentService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Comment> comments = commentService.listAllComments();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), new DataTableResult<Comment>(comments));
	}


}
