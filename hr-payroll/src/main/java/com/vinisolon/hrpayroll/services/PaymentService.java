package com.vinisolon.hrpayroll.services;

import com.vinisolon.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("teste", 100.50, days);
    }

}
