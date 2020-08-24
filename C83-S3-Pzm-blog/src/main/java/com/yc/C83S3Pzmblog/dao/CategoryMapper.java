package com.yc.C83S3Pzmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;


import com.yc.C83S3Pzmblog.bean.Category;

public interface CategoryMapper {

	
	@Select("select  DISTINCT name from category")
	public List<Category> selectByCategory();
}
