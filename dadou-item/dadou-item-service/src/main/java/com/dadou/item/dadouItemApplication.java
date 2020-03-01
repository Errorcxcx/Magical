package com.dadou.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.dadou.item.mapper")
public class dadouItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(dadouItemApplication.class,args);

    }
}
