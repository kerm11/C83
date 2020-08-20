package com.yc.C83S3PzmSpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.damai.po.DmProduct;

public interface ProductMapper {

	@Select("select * from dm_product")
	List<DmProduct> selectAll();
}
