package com.yc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class ServerApplication implements WebMvcConfigurer{


		public static void main(String[] args) {
			SpringApplication.run(ServerApplication.class, args);
		}


}
