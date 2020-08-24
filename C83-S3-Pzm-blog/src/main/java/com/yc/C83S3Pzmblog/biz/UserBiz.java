package com.yc.C83S3Pzmblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3Pzmblog.bean.User;
import com.yc.C83S3Pzmblog.dao.UserMapper;

@Service
public class UserBiz {

	@Resource
	private UserMapper uMapper;
	
	public void register(User user) throws BizExcepetion {
		//可以忽略字段验证
		//同名验证
		if(uMapper.countByAccount(user.getAccount())>0) {
			throw new BizExcepetion("该用户已经存在");
		}
		uMapper.insert(user);		
	}
	
	public User login(User user) throws BizExcepetion {
		//可以忽略字段验证
		//同名验证
		User dbUser = uMapper.selectByLogin(user);
		if(dbUser == null) {
			throw new BizExcepetion("用户名或密码错误");
		}
		return dbUser;	
	}
}
