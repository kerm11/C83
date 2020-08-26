package com.yc.C83S3Pzmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3Pzmblog.bean.Article;


public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	// <ResultMap> == @Results
	@Results(id="rmAm", value={ 
		@Result(id = true, column = "id", property = "id"), // 缓存性能优化用到
		@Result(column = "categoryid", property = "categoryid"), // 缓存性能优化用到
		@Result(
				column = "categoryid", 
				property = "category",
				one=@One(select="com.yc.C83S3Pzmblog.dao.CategoryMapper.selectById"))
		})
	public List<Article> selectByNew();

	@Select("select * from article where id=#{id}")
	@ResultMap("rmAm")
	public Article selectById(int id);
	
	@Select("select  * from article ORDER BY readCnt desc,agreeCnt desc  limit 0,5")
	public List<Article> selectByHot();

	@Insert("insert into article values (#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
	public int insert(Article a);
}
