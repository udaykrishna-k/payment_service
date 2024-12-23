package com.payment.service.services.impl;

import com.payment.service.paymentgateways.PaymentGateway;
import com.payment.service.services.PaymentService;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentService implements PaymentService {


    private final PaymentGateway paymentGateway;

    public RazorpayPaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String generatePaymentLink(String email, String phoneNumber, String orderId, Double amount) {
        return paymentGateway.generatePaymentLink(email, phoneNumber, orderId, amount);
    }
}
