package org.example.paymentservice.services;

import org.example.paymentservice.paymentgateway.IPaymentGateway;
import org.example.paymentservice.strategies.PaymentGatewayStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    private PaymentGatewayStrategy paymentGatewayStrategy;

    public PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    @Override
    public String getPaymentLink(Double amount, Long orderId, String name, String phoneNumber) {
        IPaymentGateway paymentGateway = paymentGatewayStrategy.getPaymentGateway();
        return paymentGateway.getPaymentLink(amount, orderId, name, phoneNumber);
    }
}
