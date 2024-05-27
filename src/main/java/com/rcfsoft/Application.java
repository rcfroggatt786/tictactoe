package com.rcfsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        logger.trace("Starting the Tic Tac Toe application...");
        System.out.println("STARTING SPRING");
        SpringApplication.run(Application.class, args);
        System.out.println("APPLICATION STARTED");
        //sleep(100000);
        logger.trace("Tic Tac Toe application started.");
    }
}