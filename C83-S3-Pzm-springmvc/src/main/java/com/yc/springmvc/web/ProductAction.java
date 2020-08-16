package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.po.DmCart;
import com.yc.damai.po.DmUser;

@RestController
public class ProductAction {
	/**
	 * path==value 互为同义词
	 * method  定义响应的请求类型 ，例如：GET,POST,DELETE...
	 * params   定义对参数的限定
	 * 					例如：a=100(限定请求里面必须有a的参数)
	 * 								a(限定请求里面必须有a的参数)
	 * headers   限定请求头域中的字段值，例如：Cookie
	 * consumes 消费：限定请求内容的类型
	 * produces  产品：限定返回内容的类型
	 * @return
	 */
	
	@RequestMapping(path = "product.do",params = "op=query", produces = "text/plain;charset=UTF-8")
	public String query() {
		return "邹蔓!!";
	}

	@RequestMapping(path = "product.do",params = "op=add")
	public String add() {
		return "add!!";
	}

	@RequestMapping(path = "product.do",params = "op=mod",method = RequestMethod.POST)
	public String mod() {
		return "mod!!";
	}
	//等价于@RequestMapping（method = RequestMethod.GET）
	@GetMapping(path = "product.do",params = "op=select")
	public String select() {
		return "select!!";
	}

	@GetMapping(path = "product.do",params = "op=mgr",headers = {"host=localhost","Cookie"})
	public String mgr() {
		return "mgr!!";
	}
	
	
	//////////////请求参数接收//////////////
	/**
	 * SpringMVC 对于简单请求参数：数字，字符串，布尔
	 * 可以直接将请求参数注入到方法参数中
	 * 必须满足
	 * 1.方法参数名 == 请求参数名
	 * 2.类型要兼容  int num ==>123
	 */

	@GetMapping("login.do")
	public String login(String user,String pwd) {
		return user+":"+pwd;
	}
	/**
	 * 如果对象接收请求参数，对象的属性名与请求参数名称映射
	 * 请求参数==>对象 装箱 ==>java 包装类 装箱
	 * 对于一些特殊类型对象（日期），需要用springmvc 转换器进行值得转换
	 */
	@GetMapping("/reg.do")
	public String login(DmUser user,DmCart dc) {
		return user.toString()+"<br>"+dc;
	}
	
	
	/**
	 * 使用InitBinder来处理Date类型的参数
	 * @param date
	 * @return
	 */
	//the parameter was converted in initBinder
//    @RequestMapping("date")
//    public String date(Date date){
//        System.out.println(date);
//        return "hello";
//    }
//    
//    //At the time of initialization,convert the type "String" to type "date"
//    @InitBinder
//    public void initBinder(ServletRequestDataBinder binder){
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
//                true));
//    }
	
	//要跳转到jsp动态页面地址
    //redirect 
//    @RequestMapping("/redirect")
//    public String redirect(){
//        return "pay";
//    }
    
	@GetMapping("pay.do")
	public String pay(
			@RequestParam(//此注解 定义在uid前，userid是从前台传过来的参数  相当于替代uid
					name="userid",//请求参数名 默认情况接收 uid money
					defaultValue="1",
					required = true //必须提供
				)
				String uid,Double money) {
		return uid +":"+money;
	}
	
	@GetMapping("findUser.do")
	public DmUser finDmUser() {
		DmUser du = new DmUser();
		du.setId(100);
		du.setCname("lisi");
		du.setPassword("123");
		return du;
	}
}
