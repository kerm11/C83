package com.yc.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.damai.po.DmUser;

@RestController
@RequestMapping("user")
/**
 * @SessionAttributes
 * names 用于监控数据模型中出现指定名字的对象
 * types	用于监控数据模型中出现指定类型的对象
 */
@SessionAttributes(names = "loginedUser",types = Date.class)
public class TestAction {

	
	@RequestMapping( path= "?/query", produces = "text/html;charset=UTF-8")
	//  user/a/add      user/b/add
	public String query() {
		return "邹蔓!!";
	}
	
	@RequestMapping("*/add")
//  user/a/add      user/abc/add
	public String add() {
		return "add!!";
	}
	
	@RequestMapping("**/mod")
//  user/a/add      user/a/b/add    user/add      usera/b/c/add
	public String mod() {
		return "mod!!";
	}
	
	@RequestMapping("**/head")
	public String head(@RequestHeader() String accept,
			@RequestHeader(value="connection",required = true) String conn) {
		return accept +"<br>" +conn;
	}
	
	@RequestMapping("**/cookie")
	/**
	 *  document.cookie="user=zhangsan" 浏览器添加cookie
	 */
	public String cookie(@CookieValue String user,
			@CookieValue int age,@RequestHeader String cookie) {
		return user +"<br>" +age  +"<br>" +cookie ;
	}
	
	/**
	 * 请求对象，响应，会话
	 * 添加sevlet 依赖
	 * 应用上下文对象不能注入
	 */
	@RequestMapping("**/serlvet")
	public String serlvet(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			InputStream in, //请求输入流
			OutputStream out) {//响应输出流
		return ""+ request+"<br>" +response  +"<br>" + session
				+in+"<br>" +out;
	}
	/**
	 *  地址参数：get请求的参数格式
	 *  标准URL中的参数格式：login?user=root&pwd=123
	 *  地址参数 user/root/123/login
	 */
	@RequestMapping("user/{user}/{pwd}/login")
	public String login(@PathVariable("user") String user,
			@PathVariable String pwd){
		return user+"<br>" +pwd;
	}
	/**
	 * 会话对象的注入
	 * SpringMVC 数据模型（Map) Model 请求过程中用于临时保存数据的对象
	 * @SessionAttribute  从会话中获取一个指定的对象，加在方法参数上
	 * 
	 * @RestController与@SessionAttributes 有冲突
	 * 要在@RestController标注的类中给会话添加属性，要通过注入会话对象的方法
	 * 
	 * @SessionAttributes 将指定对象设置到会话中，加在类上  age没有加在  @SessionAttributes
	 */
	@RequestMapping("{user}/{pwd}/login.do")
	public String logindo(@PathVariable("user") String user,
			@PathVariable String pwd,Model model,
			HttpSession session){ //该方法中没有用到 Model
		DmUser du = new DmUser();
		du.setEname(user);
		du.setPassword(pwd);
		//将用户对象添加到数据模型中
//		model.addAttribute("loginedUser",du);
//		model.addAttribute("now",new Date());
//		model.addAttribute("age",100);
		session.setAttribute("loginedUser",du);
		session.setAttribute("now",new Date());
		//session.setAttribute("age",100);
		return du.toString();
	}
	
	/**
	 * 验证会话中值
	 */
	@RequestMapping("testLogin")
	public String testLogin(
			@SessionAttribute("loginedUser") DmUser du,
			@SessionAttribute("now") Date date,
			@SessionAttribute(value="age",required = false ) Integer age) {
		return du+"<br>" +date +"<br>" +age;
	}
}
