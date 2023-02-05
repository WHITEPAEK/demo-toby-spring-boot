package io.whitepaek.hello;

import io.whitepaek.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class HelloApplication {

    // 초기화 작업 혹은 컨테이너의 어떤 기능을 수행해서 확인할 때 자주 사용
    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name: " + name);
        };
    }

    public static void main(String[] args) {
        // Spring Container
        SpringApplication.run(HelloApplication.class, args);
    }

}
