package com.vinisolon.hrpayroll.services;

import com.vinisolon.hrpayroll.entities.Payment;
import com.vinisolon.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}") // Pega o valor desse atributo no application.properties
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());
        String url = workerHost + "/workers/{id}";
        Worker obj = restTemplate.getForObject(url, Worker.class, uriVariables);
        return new Payment(obj.getName(), obj.getDailyIncome(), days);
    }

}
