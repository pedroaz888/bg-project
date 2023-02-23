package com.app.boardgames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;



@EnableSpringDataWebSupport
@EnableCaching
@SpringBootApplication
public class BoardgamesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardgamesApplication.class, args);
    }



}