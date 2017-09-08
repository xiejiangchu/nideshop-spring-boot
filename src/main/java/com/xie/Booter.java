package com.xie;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by xie on 16/11/23.
 */
@ComponentScan
@EnableAutoConfiguration
@EnableCaching
@MapperScan("com.xie.mapper")
public class Booter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Booter.class);

    public static void main(String[] args) {
        SpringApplication.run(Booter.class, args);
    }
}
