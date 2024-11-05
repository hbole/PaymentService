package org.example.paymentservice.services;

public interface IPaymentService {
    public String getPaymentLink(Double amount, Long orderId, String name, String phoneNumber);
}
