package com.payment.service.paymentgateways.impl;

import com.payment.service.paymentgateways.PaymentGateway;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway {

    private final RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(final RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(String email, String phoneNumber, String orderId, Double amount){
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1735025961);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for order no" + orderId);
        JSONObject customer = new JSONObject();
        customer.put("name","uday krishna");
        customer.put("contact",phoneNumber);
        customer.put("email",email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("Notes","Payment for your Product Service order");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink paymentLink = null;
        try {
            paymentLink = razorpayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        return paymentLink.get("short_url").toString();
    }
}
