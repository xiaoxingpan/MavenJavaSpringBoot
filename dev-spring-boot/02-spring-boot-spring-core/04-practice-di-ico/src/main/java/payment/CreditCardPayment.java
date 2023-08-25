package payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.") ;
    }
}
