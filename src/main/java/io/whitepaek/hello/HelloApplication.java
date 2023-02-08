package io.whitepaek.hello;

import io.whitepaek.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class HelloApplication {

    private final JdbcTemplate jdbcTemplate;

    public HelloApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        // Spring Container
        SpringApplication.run(HelloApplication.class, args);
    }

}
