package com.ghost.iocthirdtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.stream.Stream;

@SpringBootApplication
public class IocThirdTestApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(IocThirdTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GenericApplicationContext context = new GenericApplicationContext(applicationContext);
        context.refresh();
        context.registerBean(SecondService.class);
        context.registerBean(FirstService.class, context.getBean(SecondService.class));

        // Registered beans are in GenericApplicationContext and not printed here
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        FirstService firstService = context.getBean(FirstService.class);
        firstService.printStr();
    }
}
