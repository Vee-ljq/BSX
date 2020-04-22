package com.ry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BmessageDto;
import com.ry.mapper.BMessageMapper;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BMessageWithBLOBs;
import com.ry.pojo.SMessagetype;
import com.ry.service.BmessageService;
import com.ry.utils.LhPage;

@Controller
@RequestMapping("news")
public class NewsController {
	@Autowired
	BmessageService service;
	
	@RequestMapping("data")
	public ModelAndView data(BmessageDto bd,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=true, defaultValue="2") Integer pageSise){
		PageInfo<BmessageDto> selectall = service.selectall(bd, pageNum, pageSise);
		LhPage ll=new LhPage(selectall);
		ModelAndView mav=new ModelAndView("news/data");
		mav.addObject("page", ll);
		mav.addObject("bd", bd);
		return mav;
	}
	
	@RequestMapping("tjxelb")
	public ModelAndView	 tjxelb(){
	return new	ModelAndView("news/edit2");
	}
	
	@RequestMapping("tjlb")
	public String tjlb(SMessagetype smtt){
		service.insertlb(smtt);
		return ("redirect:data.action");
	}
	@RequestMapping("tjxwmr")
	public ModelAndView tjxwmr(){
		ModelAndView mav=new ModelAndView("news/edit3");
		List<SMessagetype> selectxw = service.selectxw();
		mav.addObject("xw", selectxw);
		return mav;
	}
	@RequestMapping("tjxws")
	public String tjxws(BMessageWithBLOBs bm,SMessagetype smt){
		smt.setId(bm.getTypeid());
		service.insertandupdadtaxw(bm, smt);
		return ("redirect:data.action");
	}
	//遍历编辑
	@RequestMapping("xgxw")
	public ModelAndView xgxw(int id){
		ModelAndView mav=new ModelAndView("news/edit4");
		List<SMessagetype> selectxw = service.selectxw();
		BmessageDto selectalls = service.selectalls(id);
		mav.addObject("xw", selectxw);
		mav.addObject("ss", selectalls);
		return mav;
	}
	//编辑添加
	@RequestMapping("xgbc")
	public String xgbc(BMessageWithBLOBs bm,SMessagetype smt,int tid){
		bm.setId(tid);
		smt.setId(bm.getTypeid());
		service.updatabiji(bm, smt);
		return ("redirect:data.action");
	}
	@RequestMapping("delete1")
	public String delete1(int id){
		service.deleteid(id);
		return ("redirect:data.action");
	}
	
	@RequestMapping("deletes11")
	public String deletes11(int [] ids){
		System.err.println(ids);
		service.deletes(ids);
		return "redirect:data.action";
	}
}
