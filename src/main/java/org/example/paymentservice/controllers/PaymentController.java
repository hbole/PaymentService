package org.example.paymentservice.controllers;

import org.example.paymentservice.dtos.InitiatePaymentDTO;
import org.example.paymentservice.services.IPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> initiatePayment(@RequestBody InitiatePaymentDTO initiatePaymentDTO) {
        String paymentLink = paymentService.getPaymentLink(
                initiatePaymentDTO.getAmount(),
                initiatePaymentDTO.getOrderId(),
                initiatePaymentDTO.getName(),
                initiatePaymentDTO.getPhoneNumber(),
                initiatePaymentDTO.getPaymentGatewayType()
        );

        return new ResponseEntity<>(paymentLink, HttpStatus.CREATED);
    }
}
