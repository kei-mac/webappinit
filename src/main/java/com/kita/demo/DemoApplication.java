package com.kita.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kita.demo.service.DemoFileActionService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DemoFileActionService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.addData();
    }
}
