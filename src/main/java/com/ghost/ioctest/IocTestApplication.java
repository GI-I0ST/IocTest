package com.ghost.ioctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

@SpringBootApplication
public class IocTestApplication implements CommandLineRunner {
    @Autowired
    ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(IocTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
