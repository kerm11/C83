package com.yc.C83S3PzmSpringBoot.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3PzmSpringBoot.dao.UserDao;
import com.yc.damai.po.DmUser;

/*
 *  李四开发UserBiz已经完成
 */
@Service
public class UserBiz {
	
	@Resource
	private UserDao udao;
	
	public DmUser login(String name,String pwd) throws BizException {
		
		DmUser user = udao.selectByLogin(name, pwd);
		if(user == null) {
			throw new BizException("用户名或密码错误");
		}
		
		return user;
		
	}
}
