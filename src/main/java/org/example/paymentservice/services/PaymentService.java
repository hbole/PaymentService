package org.example.paymentservice.services;

import org.example.paymentservice.paymentgateway.IPaymentGateway;
import org.example.paymentservice.paymentgateway.PaymentGatewayType;
import org.example.paymentservice.strategies.PaymentGatewayStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    private PaymentGatewayStrategy paymentGatewayStrategy;

    public PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    @Override
    public String getPaymentLink(Long amount, Long orderId, String name, String phoneNumber, PaymentGatewayType paymentGatewayType) {
        IPaymentGateway paymentGateway = paymentGatewayStrategy.getPaymentGateway(paymentGatewayType);
        return paymentGateway.getPaymentLink(amount, orderId, name, phoneNumber);
    }
}
