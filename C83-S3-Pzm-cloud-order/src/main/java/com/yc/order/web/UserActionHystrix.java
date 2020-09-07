package com.yc.order.web;

import org.springframework.stereotype.Component;

@Component//此Action并不是直接给用户访问的，它是一个替代方案
public class UserActionHystrix implements IUserAction{

	@Override
	public String user() {
		return "声明式的user服务接口降级回复信息";
	}

}
