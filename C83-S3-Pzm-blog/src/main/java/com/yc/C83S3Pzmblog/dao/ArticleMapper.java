package com.yc.C83S3Pzmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.C83S3Pzmblog.bean.Article;

public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	public List<Article> selectByNew();

	@Select("select * from article where id=#{id}")
	public Article selectById(int id);
}
