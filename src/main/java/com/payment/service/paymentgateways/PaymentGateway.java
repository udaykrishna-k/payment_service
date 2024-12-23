package com.payment.service.paymentgateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generatePaymentLink(String email, String phoneNumber, String orderId, Double amount);
}
