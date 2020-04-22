package com.ry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.BMessage;
import com.ry.pojo.BMessageKey;
import com.ry.pojo.BMessageWithBLOBs;
import com.ry.service.RZWnewService;
import com.ry.utils.LhPage;

@Controller
@RequestMapping("webrzw")
public class RZWnewController {
	@Autowired
	private RZWnewService reRzWnewService;
	@RequestMapping("ruan")
	public ModelAndView enterRuan(BMessageWithBLOBs bloBs,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		ModelAndView mav = new ModelAndView("ruanying/addruanying");
		PageInfo<BMessageWithBLOBs> pageInfo = reRzWnewService.selectById(bloBs,pageNum,pageSize);
		LhPage page = new LhPage(pageInfo);
		mav.addObject("page", page);
		mav.addObject("bb", bloBs);
		return mav;
	}
	
	@RequestMapping("rzwedit")
	public ModelAndView rzwedit(BMessageKey key){
		ModelAndView mav = new ModelAndView("ruanying/ruanying");
		BMessageWithBLOBs bloBs = reRzWnewService.selectByPrimarykey(key);
		mav.addObject("bb", bloBs);
		return mav;
	}
	
	@RequestMapping("rzwsave")
	public String rzwsave(BMessageWithBLOBs bloBs){
		boolean flag = reRzWnewService.updaterzw(bloBs);
		return "redirect:ruan.action";
	}
	
	@RequestMapping("enterRuanying")
	public ModelAndView enterRuanying(String type){
		ModelAndView mav = new ModelAndView("web/rzwblog");
		Integer id = null;
		BMessageWithBLOBs message = new BMessageWithBLOBs();
		if(type.equals("0")){
			//展示软赢科技的相关信息
			id = 1;
			BMessageKey key = new BMessageKey();
			key.setId(id);
			message = reRzWnewService.selectRuanying(key);
		}else if(type.equals("1")){
			//展示支付宝的相关信息
			id = 2;
			BMessageKey key = new BMessageKey();
			key.setId(id);
			message = reRzWnewService.selectRuanying(key);
		}else{
			//展示物流的相关信息
			id = 3;
			BMessageKey key = new BMessageKey();
			key.setId(id);
			message = reRzWnewService.selectRuanying(key);
		}
		mav.addObject("message", message);
		return mav;
	}
}
