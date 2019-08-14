package com.example.day2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication()
public class Day2Application {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Day2Application.class, args);

        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
        System.out.println(context.getBeanDefinitionCount());

    }

}
