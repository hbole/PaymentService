package org.example.paymentservice.paymentgateway;

public interface IPaymentGateway {
    String getPaymentLink(Double amount, Long orderId, String name, String phoneNumber);
}
