package com.tensqure.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class BaseAppication {
    public static void main(String[] args) {
        SpringApplication.run(BaseAppication.class,args);
    }
    @Bean
    IdWorker getIdWorker(){
        return new IdWorker();
    }
}
