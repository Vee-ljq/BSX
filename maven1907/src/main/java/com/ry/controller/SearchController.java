package com.ry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.service.GoodsService;
import com.ry.utils.LhPage;

@Controller
@RequestMapping("websearch")
public class SearchController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("enter")
	public String entersearch(String tiaojian,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		PageInfo<BGoodsWithBLOBs> bloBs = goodsService.selectByTiaojian(tiaojian,pageNum,pageSize);
		//LhPage page = new LhPage(bloBs);
		return "redirect:../webHome/toList.action?page="+bloBs;
	}
}
