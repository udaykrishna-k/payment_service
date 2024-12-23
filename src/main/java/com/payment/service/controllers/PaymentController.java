package com.payment.service.controllers;

import com.payment.service.dtos.InitializePaymentDto;
import com.payment.service.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String generatePaymentLink(@RequestBody InitializePaymentDto paymentDto){
        return paymentService.generatePaymentLink(paymentDto.getEmail(), paymentDto.getPhoneNumber(), paymentDto.getOrderId(), paymentDto.getAmount());
    }
}
