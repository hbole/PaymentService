package org.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDTO {
    private Double amount;
    private Long orderId;
    private String name;
    private String phoneNumber;
}
