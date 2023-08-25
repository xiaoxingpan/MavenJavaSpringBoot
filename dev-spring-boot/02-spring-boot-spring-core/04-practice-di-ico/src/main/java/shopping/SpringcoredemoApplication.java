package shopping;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import payment.CreditCardPayment;
import payment.PaymentMethod;
import service.OrderService;

@SpringBootApplication
public class SpringcoredemoApplication {
	@Bean
	public PaymentMethod paymentMethod() {
		return new CreditCardPayment();
		// return new PaypalPayment();
	}
	@Bean
	public OrderService orderService() {
		return new OrderService(paymentMethod());
	}

	public static void main(String[] args) {
		// Initialize Spring IoC container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringcoredemoApplication.class);

		// Get OrderService bean from the container
		OrderService orderService = context.getBean(OrderService.class);

		// Place an order with a payment method
		orderService.placeOrder(2345.5);

		// Close the Spring context
		context.close();
	}

}

