package ru.bor.spring_test_l2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bor.spring_test_l2.config.Config;
import ru.bor.spring_test_l2.service.ConsoleMarket;

public class RunApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
              Config.class
        );
        ConsoleMarket market = context.getBean("consoleMarket",ConsoleMarket.class);
        market.start();

    }
}
