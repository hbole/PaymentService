package org.example.paymentservice.strategies;

import org.example.paymentservice.paymentgateway.IPaymentGateway;
import org.example.paymentservice.paymentgateway.RazorpayPaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayStrategy {
    private final RazorpayPaymentGateway razorpayPaymentGateway;

    public PaymentGatewayStrategy(RazorpayPaymentGateway razorpayPaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public IPaymentGateway getPaymentGateway() {
        return this.razorpayPaymentGateway;
    }
}
