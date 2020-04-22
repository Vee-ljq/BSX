package com.ry.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.BTjgoodsDto;
import com.ry.dto.OrdersDto;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrdermain;
import com.ry.service.WebNewsService;
import com.ry.service.WebOrdersService;

@Controller
@RequestMapping("/web")
public class WebNewsController {
	@Autowired
	private WebNewsService newsActivitiesService;
	@Autowired
	private WebOrdersService ordersService;
	
	//活动基本信息
	@RequestMapping("/newsData")
	public ModelAndView newsData(HttpSession session){
		BCustomer customer = (BCustomer) session.getAttribute("customer");
		BOrdermain ordermain = new BOrdermain();
		ordermain.setCusid(customer.getId());
		ModelAndView mav = new ModelAndView("web/news");
		//活动基本信息
		List<BTjgoodsDto> activities = newsActivitiesService.selectactivities();
		//物流助手
		List<OrdersDto> allOrders = ordersService.selectAllOrders(ordermain);
		mav.addObject("activities", activities);
		mav.addObject("allOrders", allOrders);
		return mav;
	}
	
	//活动详情
	@RequestMapping("/activitiesInfo")
	public ModelAndView activitiesInfo(Integer activitiesId){
		ModelAndView mav = new ModelAndView("web/blog");
		BTjgoodsDto activityInfo = newsActivitiesService.selectactivityById(activitiesId);
		mav.addObject("activityInfo", activityInfo);
		return mav;
	}
	
}
