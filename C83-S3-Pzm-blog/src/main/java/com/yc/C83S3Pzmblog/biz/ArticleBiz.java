package com.yc.C83S3Pzmblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3Pzmblog.bean.Article;
import com.yc.C83S3Pzmblog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Resource
	private ArticleMapper aMapper;
	
	public int create(Article art) {
		
		return aMapper.insert(art);
	}
}
