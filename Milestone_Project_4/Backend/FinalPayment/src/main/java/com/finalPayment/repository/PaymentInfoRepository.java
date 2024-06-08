package com.finalPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalPayment.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}

