package com.finalPayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalPayment.entity.PaymentInfo;
import com.finalPayment.service.PaymentInfoService;

@RestController
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/payment")
    public ResponseEntity<PaymentInfo> savePaymentInfo(@RequestBody PaymentInfo paymentInfo) {
        return new ResponseEntity<>(service.savePaymentInfo(paymentInfo), HttpStatus.CREATED);
    }
}
