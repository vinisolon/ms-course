package com.vinisolon.hrpayroll.services;

import com.vinisolon.hrpayroll.entities.Payment;
import com.vinisolon.hrpayroll.entities.Worker;
import com.vinisolon.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient feign;

    public Payment getPayment(Long workerId, Integer days) {
        Worker obj = feign.findById(workerId).getBody();
        return new Payment(obj.getName(), obj.getDailyIncome(), days);
    }

}
