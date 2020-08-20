package com.yc.C83S3PzmSpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.C83S3PzmSpringBoot.dao")
public class C83S3PzmSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PzmSpringBootApplication.class, args);
	}

}
