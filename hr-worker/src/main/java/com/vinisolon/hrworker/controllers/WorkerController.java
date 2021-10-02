package com.vinisolon.hrworker.controllers;

import com.vinisolon.hrworker.entities.Worker;
import com.vinisolon.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope // Anotação do actuator
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static final Logger log = LoggerFactory.getLogger(Worker.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    // Recupera as configurações do servidor de configurações
    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        log.info("Configuration: " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        log.info("Port: " + env.getProperty("local.server.port"));
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

}
