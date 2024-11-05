package org.example.paymentservice.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Component
public class RazorpayPaymentGateway implements IPaymentGateway {
    private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String getPaymentLink(
            Double amount,
            Long orderId,
            String name,
            String phoneNumber
    ) {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",true);
            paymentLinkRequest.put("first_min_partial_amount",100);
            paymentLinkRequest.put("expire_by", 1730885199);
            paymentLinkRequest.put("reference_id", orderId);
            paymentLinkRequest.put("description","Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name", name);
            customer.put("contact", phoneNumber);
            customer.put("email","gaurav.kumar@example.com");
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
            JSONObject notes = new JSONObject();
            notes.put("policy_name","Jeevan Bima");
            paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = this.razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url").toString();
        } catch (RazorpayException razorpayException) {
            throw new RuntimeException(razorpayException.getMessage());
        }
    }
}
