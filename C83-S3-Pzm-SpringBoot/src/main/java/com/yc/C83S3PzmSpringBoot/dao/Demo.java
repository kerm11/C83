package com.yc.C83S3PzmSpringBoot.dao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Demo {
	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("msg", "hello world");
		return "index";
	}

}
