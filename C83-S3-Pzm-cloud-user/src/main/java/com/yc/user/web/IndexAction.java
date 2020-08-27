package com.yc.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAction {

	@RequestMapping("user")
	public String index() {
		return "user";
	}
}