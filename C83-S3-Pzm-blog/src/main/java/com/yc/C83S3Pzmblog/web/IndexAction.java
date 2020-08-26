package com.yc.C83S3Pzmblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.C83S3Pzmblog.bean.Article;
import com.yc.C83S3Pzmblog.dao.ArticleMapper;
import com.yc.C83S3Pzmblog.dao.CategoryMapper;

@Controller
public class IndexAction {
	
	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;
	
	@GetMapping({"/","/index.html"})
	public String index( Model m,@RequestParam(defaultValue = "1") int page) {
	
		//在执行查询前，设置分页参数
		//注意：必须在查询方法执行前，调用分页参数设置
		PageHelper.startPage(page, 5);
		m.addAttribute("alist",amapper.selectByNew());
		m.addAttribute("clist", cmapper.selectByCategory());
		m.addAttribute("hlist", amapper.selectByHot());
		return "index";
	}

	

}
