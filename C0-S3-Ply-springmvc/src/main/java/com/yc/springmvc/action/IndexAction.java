package com.yc.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexAction {

	/**
	 * 	打开首页
	 */
	@RequestMapping({ "/", "index" })
	public String index(@RequestParam(defaultValue = "") String order) {
		return "index" + order;
	}
	
	@RequestMapping({"taobao/page","*Taobao","page/**/taobao"})
	public String toTaobao() {
		return "taobao";
	}
	
	@RequestMapping(path="toPage",params="flag")
	public String taoabo1() {
		return "taobao";
	}
	
	@RequestMapping(path="toPage",params="type=1")
	public String taoabo2() {
		return "taobao";
	}
	
	@RequestMapping({"toBaidu","baidu/page"})
	public String toBaidu() {
		return "baidu";
	}
	
	@RequestMapping(path="toPage",params={"type!=1","!flag"})
	public String baidu1() {
		return "baidu";
	}
	
	
	
	
	
	
}
