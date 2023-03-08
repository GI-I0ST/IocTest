package com.ghost.iocsecondtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.stream.Stream;

@SpringBootApplication
public class IocSecondTestApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(IocSecondTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GenericApplicationContext context = new GenericApplicationContext(applicationContext);
        context.registerBean(SecondService.class);
        context.registerBean(FirstService.class);
        context.refresh();

        // Registered beans are in GenericApplicationContext and not printed here
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        FirstService firstService = context.getBean(FirstService.class);
        firstService.printStr();
    }
}
