package com.ry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.CommentDto2;
import com.ry.service.BCommentService2;

@Controller
@RequestMapping("web")
public class CommentWebController {
	@Autowired
	private BCommentService2 service;
	@RequestMapping("comment")
	public ModelAndView comment(){
	ModelAndView mav=new ModelAndView("web/comment");
		List<CommentDto2> selectall = service.selectall();
		mav.addObject("ss", selectall);
	return mav;
	}
	
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo(){
		
		return	new ModelAndView("web/userInfo");
	}
}
