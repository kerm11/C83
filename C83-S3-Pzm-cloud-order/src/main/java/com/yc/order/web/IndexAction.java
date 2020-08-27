package com.yc.order.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAction {

	@RequestMapping("order")
	public String index() {
		return "order";
	}
}
