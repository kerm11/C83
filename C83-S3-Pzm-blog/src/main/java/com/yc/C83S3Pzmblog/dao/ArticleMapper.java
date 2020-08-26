package com.yc.C83S3Pzmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3Pzmblog.bean.Article;


public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	public List<Article> selectByNew();

	@Select("select * from article where id=#{id}")
	public Article selectById(int id);
	
	@Select("select  * from article ORDER BY readCnt desc,agreeCnt desc  limit 0,5")
	public List<Article> selectByHot();

	@Insert("insert into article values (#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
	public int insert(Article a);
}
