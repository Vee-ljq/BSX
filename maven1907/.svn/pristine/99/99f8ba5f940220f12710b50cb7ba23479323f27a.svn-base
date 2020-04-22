package com.ry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.pojo.BCustomer;
import com.ry.service.IndexWebService;

//个人信息控制层
@Controller
public class InformationWebController {
	
	@Autowired
	private IndexWebService service;
	
	@RequestMapping("web/information")
	public ModelAndView infor(HttpSession session){
		BCustomer customer = (BCustomer) session.getAttribute("customer");
		
		
//		BCustomer selectCustomer = service.selectCustomer(customer);
		
		ModelAndView mav=new ModelAndView("web/information");
		mav.addObject("cust", customer);
		
		
		return mav;
	}
	//点击保存
	@RequestMapping("web/save")
	public String save(BCustomer customer,HttpServletRequest request){
		
		//修改用户信息
		boolean updateCust = service.updateCust(customer);
		//session.setAttribute("cust", customer);
		request.setAttribute("cust", customer);
		request.getSession().setAttribute("customer", customer);
		return "web/information";
	}
	

}
