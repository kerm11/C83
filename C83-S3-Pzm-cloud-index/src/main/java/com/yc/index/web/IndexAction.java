package com.yc.index.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAction {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
}