package com.yc.C83S3Pzmblog.web;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.C83S3Pzmblog.bean.Result;
import com.yc.C83S3Pzmblog.bean.User;
import com.yc.C83S3Pzmblog.biz.BizExcepetion;
import com.yc.C83S3Pzmblog.biz.UserBiz;
import com.yc.C83S3Pzmblog.dao.CategoryMapper;
import com.yc.C83S3Pzmblog.util.Utils;

@Controller //默认控制器方法是执行页面跳转
public class UserAction {
	@Resource
	private UserBiz ubiz;
	@Resource
	private CategoryMapper cmapper;
	/**
	 * 注册：表单提交 ==>页面跳转
	 * @param user
	 */
	@PostMapping("reg.do")
	public String register(@Valid User user,Errors errors,Model m) {
		if(errors.hasErrors()) {
			m.addAttribute("errors", Utils.asMap(errors));
			m.addAttribute("user", user);
			
			return "reg";
		}		
		try {
			ubiz.register(user);
		} catch (BizExcepetion e) {
			e.printStackTrace();
			errors.rejectValue("account", "account", e.getMessage());
			m.addAttribute("errors",  Utils.asMap(errors));
			m.addAttribute("user", user);
	
			return "reg";
		}	
		//index请求转发方式跳转到index
		//使用响应重定向方式跳转
		return "redirect:/";		
	}
	
	@GetMapping("toreg")
	public String toreg(Model m) {
		m.addAttribute("clist", cmapper.selectByCategory());
		return "reg";
	}
	/**
	 * 登录 Ajax提交  ==>Vue
	 * @param user
	 */
	@PostMapping("login.do")
	//是在 Controller 使用==>方法返回视图名
	//表示该方法得返回得到JSON数据
	@ResponseBody 
	public Result login(@Valid User user,Errors errors,HttpSession session) {
		try {
			if (errors.hasFieldErrors("account")||errors.hasFieldErrors("pwd")) {
				//将错误结果转换成Map集合再返回
				return new Result(0,"验证错误", Utils.asMap(errors));
			}
			User dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			return new Result(1,"登录成功",dbuser);		
		} catch (BizExcepetion e) {
			e.printStackTrace();		
			return new Result(e.getMessage());
		}		
	}
	
	
	
}
