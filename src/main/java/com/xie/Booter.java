package com.xie;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by xie on 16/11/23.
 */
@ComponentScan
@EnableAutoConfiguration
@MapperScan("com.xie.mapper")
public class Booter implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Booter.class);

    public static void main(String[] args) {
        LOGGER.info("========                      微信商城服务启动 开始                     ========");
        SpringApplication.run(Booter.class, args);
        LOGGER.info("========                      微信商城服务启动 完成                     ========");
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("========                      微信商城服务启动中 ...                    ========");
    }
}
