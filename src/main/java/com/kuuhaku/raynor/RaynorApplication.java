package com.kuuhaku.raynor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kuuhaku.raynor.dao")
public class RaynorApplication{


    public static void main(String[] args) {
        SpringApplication.run(RaynorApplication.class, args);
    }
}
