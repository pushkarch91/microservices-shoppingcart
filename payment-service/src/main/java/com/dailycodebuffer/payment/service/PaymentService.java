package com.dailycodebuffer.payment.service;

import com.dailycodebuffer.payment.model.PaymentRequest;
import com.dailycodebuffer.payment.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
