package com.yc.C83S3Pzmblog.web;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.C83S3Pzmblog.bean.Article;
import com.yc.C83S3Pzmblog.util.Utils;



@RestController
public class ArticleAction {

	/*
	 * @GetMapping("toAddArticle") public String toAddArticle() { return
	 * "addArticle"; }
	 */
	
	@GetMapping("toAddArticle")
	public ModelAndView toAddArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
		return mav;
	}
	
	@PostMapping("addArticle.do")
	public ModelAndView addArticle(@Valid Article article , Errors errors ,ModelAndView mav) {
		//ModelAndView = Model + View
		if (errors.hasErrors()) {
			mav.addObject("errors",Utils.asMap(errors));
			mav.addObject("article", article);
			mav.setViewName("addArticle");
		}else {
			mav.setViewName("article");
		}
		return mav;
	}
}
