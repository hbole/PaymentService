package org.example.paymentservice.paymentgateway;

public interface IPaymentGateway {
    String getPaymentLink(Long amount, Long orderId, String name, String phoneNumber);
}
