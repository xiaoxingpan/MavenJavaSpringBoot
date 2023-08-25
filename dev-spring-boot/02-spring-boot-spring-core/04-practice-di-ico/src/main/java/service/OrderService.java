package service;

import payment.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentMethod myPaymentMethod;

    @Autowired

    public OrderService(PaymentMethod myPaymentMethod) {
        this.myPaymentMethod = myPaymentMethod;
    }
    public void placeOrder(double amount) {
        System.out.println("Placing order...");
        myPaymentMethod.pay(amount);
        System.out.println("Order placed successfully!");
    }
    // any method name can be used

   }
