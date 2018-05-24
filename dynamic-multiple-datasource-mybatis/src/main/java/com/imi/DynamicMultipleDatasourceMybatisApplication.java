package com.imi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * spring boot 结合 mybatis 实现多数据源切换
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DynamicMultipleDatasourceMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicMultipleDatasourceMybatisApplication.class, args);
	}
}
