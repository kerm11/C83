package com.yc.C83S3Pzmblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.C83S3Pzmblog.dao")
public class C83S3PzmBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PzmBlogApplication.class, args);
	}

}
