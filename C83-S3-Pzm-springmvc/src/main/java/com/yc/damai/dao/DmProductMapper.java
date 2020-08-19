package com.yc.damai.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.damai.po.DmProduct;

public interface DmProductMapper {
	
	/**
	 * @select注解会默认使用resultType的映射行为
	 * @return
	 */
	@Select("select * from dm_product")
//	@Results 替代<resultMap>@Result替代<result>
	@Results(id="rmdp",value= {
			@Result(column = "id",property="id",id=true),
			@Result(column = "market_price",property="marketPrice"),
			@Result(column = "shop_price",property="shopPrice"),
			@Result(column = "is_hot",property="isHot")
	})
	List<DmProduct> selectAll();
	@Select("select * from dm_product where id=#{id}")
	//@ResultMap替代<select>标签resultMap属性
	@ResultMap("rmdp")
	DmProduct  selectById(int id);
	
	@Select("select * from dm_product where is_hot=1")
	List<DmProduct> selectForHot();
	
	List<DmProduct> selectByObj(DmProduct dp);
	/**
	 * 根据枚举的分类id进行查询
	 * 
	 * @param cids 存放分类id的数组0~N
	 * @return
	 * mybatis  不能识别参数的名称
	 * @param 用于定义参数名称
	 */
	List<DmProduct> selectByCids(@Param("cids") int[] cids);
	int insert(DmProduct dp);
	
	int update(DmProduct dp);
	
	int delete(int id);
}
