package com.vinisolon.hrpayroll.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vinisolon.hrpayroll.entities.Payment;
import com.vinisolon.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment obj = service.getPayment(workerId, days);
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment obj = new Payment("AlternativeMethod", 100.0, days);
        return ResponseEntity.ok(obj);
    }

}
