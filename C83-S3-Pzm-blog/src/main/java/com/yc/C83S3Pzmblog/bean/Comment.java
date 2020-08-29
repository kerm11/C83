package com.yc.C83S3Pzmblog.bean;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private Integer articleid;
	private String content;
	private Integer createby;
	//请求参数格式化注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //JSON转换的格式化注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

 //   @DateTimeFormat(iso=ISO.DATE)
    private Date date;
	
    
    public Date getDate() {
 		return date;
 	}

 	public void setDate(Date date) {
 		this.date = date;
 		//将date值同步到createtime
 		this.createtime = new Timestamp(date.getTime());
 	}
	
	private Timestamp createtime;
	
	private Article article; // 关联文章   一对一管理
	private User user; 		 // 发表人, 关联 User  一对一管理

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Integer getCreateby() {
		return createby;
	}
	public void setCreateby(Integer createby) {
		this.createby = createby;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	

}
