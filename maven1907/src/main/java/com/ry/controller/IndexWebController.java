package com.ry.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.pojo.BCustomer;
import com.ry.service.IndexWebService;
import com.ry.utils.MD5Utils;
@Controller
public class IndexWebController {
	@Autowired
	private IndexWebService service;
	@RequestMapping("web/login")
	public ModelAndView index(){
		return new ModelAndView("web/login");
	}
	@RequestMapping("web/index")
	public String selectlogin(BCustomer customer,HttpServletResponse response,HttpServletRequest request,HttpSession session){
		String miString=customer.getPwd();
		customer.setPwd(MD5Utils.string2MD5(customer.getPwd()));
		BCustomer cust = service.pwd(customer);
		if(cust!=null){
			String aString=request.getParameter("remember");
			if(aString!=null&&!"".equals(aString)){
			Cookie cookie=new Cookie("name",customer.getNickname());
			cookie.setMaxAge(7*24*60*60);
			cookie.setPath("/");
			response.addCookie(cookie);
			Cookie cookie1=new Cookie("pwd",miString);
			cookie1.setMaxAge(7*24*60*60);
			cookie1.setPath("/");
			response.addCookie(cookie1);
			}
			session.setAttribute("customer", cust);
			//如果用户昵称为空跳转到个人信息页面
			if(cust.getNickname()==null){
				return "redirect:../web/information.action";
			}
			return "redirect:../webHome/index.action";
//			return "web/index";
		}else {
			return "web/login";
		}
		
	}
	
}
