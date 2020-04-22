package com.ry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ry.pojo.BCustomer;
import com.ry.service.RegisterService;
import com.ry.utils.MD5Utils;
import com.ry.utils.NewCode;
import com.ry.utils.NowDate;
import com.ry.utils.SmsUtils;
import com.ry.utils.SmsUtils1;

@Controller
@RequestMapping("web")
public class RegisterController {
	@Autowired
	private RegisterService service;
	
	@RequestMapping("register")
	public ModelAndView register(){
		return new ModelAndView("web/register");
	}
	
	@RequestMapping("log")
	public ModelAndView log(BCustomer customer){
		ModelAndView mav=null;
		customer.setPwd(MD5Utils.string2MD5(customer.getPwd()));
		boolean selectyz = service.selectyz(customer);
		if(selectyz){
			mav=new ModelAndView("web/register"); 
			mav.addObject("a1", 1);
		}else{
			service.zc(customer);
			mav=new ModelAndView("web/login"); 
		}
		return mav;
	}
	
	//获取验证码
	@RequestMapping("/checkYzm")
	@ResponseBody
	public String checkYzm(String mobile,HttpServletRequest request) {
		String flag = "0";
		String string="";
		String txd="欢迎注册百疏鲜蔬菜采供平台";
		
		String randomcode =NewCode.setNewcode();
		try {
			SendSmsResponse sendSms = SmsUtils1.sendSms(mobile,randomcode);
			System.out.println("controller"+randomcode);
			request.getSession().setAttribute("yz", randomcode);
			System.out.println(request.getSession().getAttribute("yz"));
			flag = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//判断注册是否成功
	@RequestMapping("selectsj")
	public ModelAndView insertsj(BCustomer customer,String brand,HttpSession session){
		
		ModelAndView mav=null;
		
		if(!brand.equals(session.getAttribute("yz"))){
			session.removeAttribute("yz");
			mav=new ModelAndView("web/register");
			mav.addObject("a1", 2);
		}else{
			boolean selectj = service.selectsj(customer);
			if(selectj){
				mav=new ModelAndView("web/register");
				mav.addObject("a1", 1);
			}else{
				mav=new ModelAndView("web/login");
				customer.setPwd(MD5Utils.string2MD5(customer.getPwd()));


				//service.selectall(customer);

				//增加注册时间
				NowDate nowDate=new NowDate();
				String nowDay = nowDate.nowDay();
				customer.setRegdate(nowDay);
				//service.selectall(customer);
				service.insertall(customer);

			}
		}
		return mav;
	}
	
	
}
