package com.example.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectV1Application {
    private static Logger logger = LoggerFactory.getLogger(ProjectV1Application.class);
    public static void main(String[] args) {
        SpringApplication.run(ProjectV1Application.class, args);
        logger.warn("Application Starting.......");
        logger.debug("Application Starting......");
        logger.error("Application Starting......");
        logger.info("Application {} is starting...", "ProjectV1");
        System.out.println("Application start running ........");
        System.out.println("Admin And Developed by : Abdessamad bencheraik");
    }
}
