package org.example.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripe/webhook")
public class StripWebhookController {

    @PostMapping
    public void respondToEvent(@RequestBody String stripeJsonEvent) {
        System.out.println(stripeJsonEvent);
    }
}
