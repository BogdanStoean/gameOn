package ro.gameon.service.messagedrivenbean;

import ro.gameon.dao.OrderDao;
import ro.gameon.dao.OrderProductDao;
import ro.gameon.dao.UserProductDao;
import ro.gameon.entity.Order;
import ro.gameon.entity.OrderProduct;
import ro.gameon.entity.Product;
import ro.gameon.entity.User;
import ro.gameon.entity.UserProduct;
import ro.gameon.model.OrderBean;
import ro.gameon.model.OrderStatus;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.List;

/**
 * User: bogdan
 * Date: 2/8/14
 * Time: 7:39 PM
 */
@MessageDriven(mappedName = "orderQueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class OrderManagerBean implements MessageListener {


	@Inject
	private OrderDao orderDao;


	@Inject
	private OrderProductDao orderProductDao;

	@Inject
	private UserProductDao userProductDao;


	@Override
	public void onMessage(Message message) {


		if (message instanceof ObjectMessage) {
			try {
				Object obj = ((ObjectMessage) message).getObject();
				System.out.println(obj.toString());
				OrderBean orderBean = (OrderBean) obj;
				Order order = new Order();
				order.setOrderDate(orderBean.getOrderDate());
				order.setOrderName(orderBean.getOrderName());
				order.setOrderStatus(OrderStatus.NEW.toString());
				order.setOrderValue(orderBean.getOrderValue());
				order.setOwner(new User(orderBean.getUserId()));

				order = orderDao.merge(order);

				List<Long> productIds = orderBean.getProductIds();
				for(Long productId : productIds) {
					OrderProduct orderProduct = new OrderProduct();
					orderProduct.setOrder(order);
					orderProduct.setProduct(new Product(productId));
					orderProductDao.merge(orderProduct);

					UserProduct userProduct = new UserProduct();
					userProduct.setUser(new User(orderBean.getUserId()));
					userProduct.setProduct(new Product(productId));
					userProductDao.merge(userProduct);
				}

				order.setOrderStatus(OrderStatus.FINALIZED.toString());
				orderDao.merge(order);
			} catch (JMSException e) {

			}

		}
//		OrderBean orderBean = (OrderBean) message;
//		Order order = new Order();
//		order.setOrderDate(orderBean.getOrderDate());
//		order.setOrderName(orderBean.getOrderName());
//		order.setOrderStatus(OrderStatus.NEW.toString());
//		order.setOrderValue(orderBean.getOrderValue());
//		order.setOwner(new User(orderBean.getUserId()));
//
//		order = orderDao.merge(order);
//
//		List<Long> productIds = orderBean.getProductIds();
//		for(Long productId : productIds) {
//			OrderProduct orderProduct = new OrderProduct();
//			orderProduct.setOrder(order);
//			orderProduct.setProduct(new Product(productId));
//			orderProductDao.merge(orderProduct);
//
//			UserProduct userProduct = new UserProduct();
//			userProduct.setUser(new User(orderBean.getUserId()));
//			userProduct.setProduct(new Product(productId));
//			userProductDao.merge(userProduct);
//		}
//
//		order.setOrderStatus(OrderStatus.FINALIZED.toString());
//		orderDao.merge(order);
	}
}
