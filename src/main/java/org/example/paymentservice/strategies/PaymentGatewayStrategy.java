package org.example.paymentservice.strategies;

import org.example.paymentservice.paymentgateway.IPaymentGateway;
import org.example.paymentservice.paymentgateway.PaymentGatewayType;
import org.example.paymentservice.paymentgateway.RazorpayPaymentGateway;
import org.example.paymentservice.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayStrategy {
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayStrategy(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public IPaymentGateway getPaymentGateway(PaymentGatewayType paymentGateway) {
        switch (paymentGateway) {
            case Razorpay:
                return this.razorpayPaymentGateway;
            default:
                return stripePaymentGateway;
        }
    }
}
