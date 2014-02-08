package ro.gameon.orders;

import ro.gameon.model.LoginBean;
import ro.gameon.model.OrderBean;
import ro.gameon.util.ConverterUtil;
import ro.gameon.util.SessionUtil;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 9:54 PM
 */
@WebServlet("/orders/send.json")
public class OrdersServlet extends HttpServlet {


	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/queue/test")
	private Queue queue;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		response.setContentType("application/xhtml+xml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String orderName = request.getParameter("orderName");
		Double orderValue = ConverterUtil.getDoubleFromString(request.getParameter("orderValue"));


		OrderBean orderBean = new OrderBean();
		orderBean.setOrderName(orderName);
		orderBean.setOrderValue(orderValue);
		orderBean.setOrderDate(new Date());
		orderBean.setUserId(SessionUtil.getLoggedUser(request).getUserBean().getUserId());
		orderBean.setProductIds(new ArrayList<Long>(SessionUtil.getLoggedUser(request).getShoppingCart()));
		sendOrder(orderBean);

		LoginBean loginBean = SessionUtil.getLoggedUser(request);
		loginBean.getShoppingCart().clear();
		SessionUtil.setLoggedUser(request, loginBean);

	}


	private void sendOrder(OrderBean orderBean) {
		MessageProducer orderManager = null;
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			orderManager = session.createProducer(queue);
			ObjectMessage orderMessage = session.createObjectMessage();
			orderMessage.setObject(orderBean);
			orderManager.send(orderMessage);
		} catch (JMSException e) {

		} finally {
			if (orderManager != null) {
				try {
					orderManager.close();
				} catch (JMSException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
				}
			}
		}
	}
}
