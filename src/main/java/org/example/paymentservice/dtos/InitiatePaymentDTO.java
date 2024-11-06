package org.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.paymentservice.paymentgateway.PaymentGatewayType;

@Getter
@Setter
public class InitiatePaymentDTO {
    private Long amount;
    private Long orderId;
    private String name;
    private String phoneNumber;
    private PaymentGatewayType paymentGatewayType;
}
