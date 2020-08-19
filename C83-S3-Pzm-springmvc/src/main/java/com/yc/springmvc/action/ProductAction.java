package com.yc.springmvc.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.DmProductMapper;
import com.yc.damai.po.DmProduct;

@RestController("pAction")
public class ProductAction {

	private DmProductMapper pm;
	
	/**
	 * Model  ==>数据模型  ==>Map集合可以替代Model
	 *返回Model必须是 页面跳转方式才可以
	 *如果是Ajax通过参数注入的Map或Model里面会默认设置一个视图名
	 *		导致错误，ajax方式不能设置视图名
	 * @return
	 */
	@GetMapping(path="product.do",params = "op=query")
	public Map<String, Object>  query(DmProduct dp){
		Map<String, Object>  m=new HashMap<String, Object>();
		m.put("list", pm.selectForHot());
		return m;		
	}
	
	
}
