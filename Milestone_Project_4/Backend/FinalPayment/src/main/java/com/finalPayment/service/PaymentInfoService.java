package com.finalPayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalPayment.entity.PaymentInfo;
import com.finalPayment.repository.PaymentInfoRepository;

@Service
public class PaymentInfoService {
    @Autowired
    private PaymentInfoRepository repository;

    public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo) {
        return repository.save(paymentInfo);
    }
}
