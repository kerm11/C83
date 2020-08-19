package com.yc.springmvc.web;


import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.po.DmUser;
import com.yc.damai.po.Result;

@RestController
//@RequestMapping("demo")
public class ValidAction {
	
	/**
	 * 	1.在被校验的对象前加@Valid 注解
	 * 2.在被校验的对象后（紧跟）添加一个Errors对象
	 */
	@RequestMapping("reg1.do")
	public Result reg(@Valid  DmUser du,Errors errors) {
		/**
		 * errors.hasErrors()  判断是否有错误
		 * errors.hasFieldError() 判断是否有字段错误
		 * 错误分成：1.对象级错误，2.字段级错误，3全局错误
		 */
		if(errors.hasErrors()) {
			return new Result(0,"验证错误",errors.getAllErrors());
		}else {
			return new Result(1,"OK");
		}
		
	}

}
