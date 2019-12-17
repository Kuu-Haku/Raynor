package com.kuuhaku.raynor;

import com.kuuhaku.raynor.mqttclient.Server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.kuuhaku.raynor.dao")
public class RaynorApplication{


    public static void main(String[] args) {
        SpringApplication.run(RaynorApplication.class, args);
    }
}
