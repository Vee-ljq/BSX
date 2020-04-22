package com.ry.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.BGoodsViewDto;
import com.ry.dto.GoodsDto;
import com.ry.service.FootsService;
import com.ry.service.GoodsService;
import com.ry.utils.NowDate;
/**
 * 商品浏览控制层
 * @author WZM
 *
 */
@Controller
@RequestMapping("webfoot")
public class FootprintContrullor {
	
	/**
	 * 点击我的足迹，到足迹页面
	 * 用户登陆时，获得用户id
	 * 从数据库中通过id查询商品的详细信息
	 * 
	 * 从httpservletrequest中获取ip地址
	 * 加上浏览商品时的时间
	 */
	/**
	 * 足迹的service
	 */
	@Autowired
	private FootsService service;
	//商品的service
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("foot")
	public ModelAndView selectGoodsById(BGoodsViewDto bg,HttpServletRequest request){
		//获取ip地址
		String ip = request.getRemoteAddr();//返回发出请求的IP地址
		bg.setIpaddr(ip);
		
		ModelAndView mav=new ModelAndView("web/foot");
		//浏览商品的时间
		NowDate now=new NowDate();
		String nowDay = now.nowDay();
		bg.setBrowsingtime(nowDay);
		
		List<BGoodsViewDto> selectByTime = service.selectByTime(bg);
		mav.addObject("times", selectByTime);
		mav.addObject("daya", now);
		
		//获取商品的详细信息
		List<BGoodsViewDto> selectByGoodsViewDtos = service.selectGoodsView(bg);
		mav.addObject("foots", selectByGoodsViewDtos);
		return mav;
	}
	@RequestMapping("deleteById")
	public String deleteById(Integer id){
		service.deleteById(id);
		
		
		return "forward:foot.action";
	}
	
	
	

}
