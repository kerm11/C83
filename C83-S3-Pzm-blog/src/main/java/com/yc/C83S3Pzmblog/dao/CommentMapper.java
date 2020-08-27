package com.yc.C83S3Pzmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3Pzmblog.bean.Comment;

public interface CommentMapper {
	
	
	@Insert("insert into comment values (null,"
			+ "#{articleid},#{content},#{createby},now())")
	public int insert(Comment comm);

	@Select("select * from comment where articleid=#{articleid}")
	@Results(id="rmCm", value={ 
			@Result(id = true, column = "id", property = "id"), // 缓存性能优化用到
			@Result(column = "createby", property = "createby"), 
			@Result(
					column = "createby", 
					property = "user",
					one=@One(select="com.yc.C83S3Pzmblog.dao.UserMapper.selectById"))
			})
	public List<Comment> selectByArticle(int articleid);
}
