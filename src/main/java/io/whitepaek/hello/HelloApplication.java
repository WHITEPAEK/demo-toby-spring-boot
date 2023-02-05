package io.whitepaek.hello;

import io.whitepaek.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        // Spring Container
        SpringApplication.run(HelloApplication.class, args);
    }

}
