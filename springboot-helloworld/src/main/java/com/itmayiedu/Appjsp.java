package com.itmayiedu;

import com.itmayiedu.datasource.DBConfig1;
import com.itmayiedu.datasource.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
@EnableScheduling
@EnableAsync
@MapperScan(basePackages ={"com.itmayiedu.mapper"})
public class Appjsp {

    public static void main(String[] args) {
        SpringApplication.run(Appjsp.class, args);
    }
}
