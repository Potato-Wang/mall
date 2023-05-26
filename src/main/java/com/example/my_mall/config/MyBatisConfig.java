package com.example.my_mall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
    *MyBatis配置类，用于扫描目标路径，将生成的mapper交给spring管理
 */
@Configuration
//
@MapperScan
public class MyBatisConfig {
}
