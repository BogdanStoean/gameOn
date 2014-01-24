package ro.gameon;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

/**
 * User: bogdan
 * Date: 1/24/14
 * Time: 10:43 AM
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/helloworld")
public class HelloWorldServlet extends javax.servlet.http.HttpServlet {
	@EJB
	private HelloWorldBean helloWorldBean;
	protected void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {

	}
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {
		String hello=helloWorldBean.sayHello();
		request.setAttribute("hello",hello);
		request.getRequestDispatcher("hello.jsp").forward(request,response);
	}
}
