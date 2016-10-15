package com.training.hedgehogproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by sony on 10/12/2016.
 */

@SpringBootApplication
public class HedgehogProblemSpringBootApplication {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(HedgehogProblemSpringBootApplication.class, args);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

}
