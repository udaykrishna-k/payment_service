package com.payment.service.services;

public interface PaymentService {
    String generatePaymentLink(String email, String phoneNumber, String orderId, Double amount);
}
