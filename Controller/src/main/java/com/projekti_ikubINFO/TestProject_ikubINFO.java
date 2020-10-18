package com.projekti_ikubINFO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.projekti_ikubINFO.*"})
@EntityScan(basePackages = {"com.projekti_ikubINFO.*"})
@EnableJpaRepositories(basePackages = {"com.projekti_ikubINFO.*"})
public class TestProject_ikubINFO {

    private static final Logger logger = LoggerFactory.getLogger(TestProject_ikubINFO.class);

    public static void main(String[] args) {
        SpringApplication.run(TestProject_ikubINFO.class);
        logger.debug("----Application Started----");
        logger.error("Message logged at ERROR level");
        logger.warn("Message logged at WARN level");
        logger.info("Message logged at INFO level");
    }
}
