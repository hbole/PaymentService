package org.example.paymentservice.services;

import org.example.paymentservice.paymentgateway.PaymentGatewayType;

public interface IPaymentService {
    public String getPaymentLink(Long amount, Long orderId, String name, String phoneNumber, PaymentGatewayType paymentGatewayType);
}
