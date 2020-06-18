package com.imooc.web1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ImportResource(locations = "classpath*:mapper/**.xml")
public class Web1Application {

    private static final Logger logger = LoggerFactory.getLogger(Web1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Web1Application.class, args);

        logger.info("webstart");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
