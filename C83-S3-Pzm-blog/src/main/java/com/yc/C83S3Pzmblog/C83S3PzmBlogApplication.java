package com.yc.C83S3Pzmblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.C83S3Pzmblog.web.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.yc.C83S3Pzmblog.dao")
public class C83S3PzmBlogApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(C83S3PzmBlogApplication.class, args);
	}

	/**
	 * 	拦截器注册方法
	 * 	参数: 拦截器注册器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		
		InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
		// 互联网项目 ==> 拦截少数资源
		// 企业内部管理系统 ==> 拦截多数资源
		ir.addPathPatterns("/toAddArticle", "/addArticle.do");
	}

	
	
}
