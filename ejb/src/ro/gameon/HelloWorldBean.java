package ro.gameon;

import javax.ejb.Stateless;

/**
 * User: bogdan
 * Date: 1/24/14
 * Time: 10:40 AM
 */
@Stateless(name = "HelloWorldEJB")
public class HelloWorldBean {
	public HelloWorldBean() {
	}

	public String sayHello() {
		return "Hello, World!";
	}
}
