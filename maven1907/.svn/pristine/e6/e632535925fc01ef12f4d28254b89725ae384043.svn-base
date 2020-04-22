package com.ry.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ry.pojo.BCustomer;
import com.ry.service.IndexWebService;
import com.ry.utils.IDCardUtils;
import com.ry.utils.MD5Utils;
import com.ry.utils.SmsUtils;

@Controller
/* @RequestMapping("/websafety") */
@RequestMapping("/web")
public class WebSafetyController {
	/*
	 * private static final String signName="百蔬鲜更换手机绑定"; private static final
	 * String templateCode="SMS_181545553";
	 */

	@Autowired
	private IndexWebService customerService;

	@RequestMapping("/setsafety")
	public ModelAndView tosafety() {
		return new ModelAndView("web/safety");

	}

	@RequestMapping("/editpassword")
	public ModelAndView toeditpassword() {
		return new ModelAndView("web/password");

	}

	@RequestMapping("/editsetpay")
	public ModelAndView toeditsetpay() {
		return new ModelAndView("web/setpay");

	}

	@RequestMapping("/editbindphone")
	public ModelAndView toeditbindphone() {
		return new ModelAndView("web/bindphone");

	}

	@RequestMapping("/editemail")
	public ModelAndView toeditemail() {
		return new ModelAndView("web/email");

	}

	@RequestMapping("/editidcard")
	public ModelAndView toeditidcard() {
		return new ModelAndView("web/idcard");
	}

	@RequestMapping("/editquestion")
	public ModelAndView toeditquestion() {
		return new ModelAndView("web/question");

	}

	@ResponseBody
	@RequestMapping("/checkoldpassword")
	public boolean checkoldpassword(HttpSession session, String pwd) {
		// ModelAndView mav = new ModelAndView("web/password");
		// String customer1 = JSONUtils.toJSONString(customer);
		// System.out.println(customer1);
		BCustomer customer1 = (BCustomer) session.getAttribute("customer");
		String pwd1 = customer1.getPwd();
		if (pwd1 != null && pwd1 != "" && pwd1.equals(MD5Utils.string2MD5(pwd))) {
			return true;
		}
		return false;
	}

	@RequestMapping("/checksamepassword")
	public String checktwopassword(BCustomer bCustomer, String twopassword,
			HttpSession session) {
		bCustomer = (BCustomer) session.getAttribute("customer");
		String pwd1 = MD5Utils.string2MD5(twopassword);
		bCustomer.setPwd(pwd1);
		boolean bl = customerService.updatePasswordById(bCustomer);
		if (bl) {
			return "web/index";
		}
		return "web/password";
	}

	/*
	 * @RequestMapping("checkoldcode") public String checkoldcode(HttpSession
	 * session){
	 * 
	 * 
	 * }
	 */

	@RequestMapping("/sendmessage")
	@ResponseBody
	public String sendFirstMes(Integer typeid, String oldphone, String oldcode1)
			throws ClientException {
		String str = "";
		if(typeid==1){
		SendSmsResponse sendSms = SmsUtils.sendSms(oldphone, "百蔬鲜更换手机绑定",
				"SMS_181545553");
		}else{
		String code1 = SmsUtils.randomcode;
		System.out.println(code1);
		if (oldcode1 != null && oldcode1 != "" && code1.equals(oldcode1)) {
			str = "1";
		} else {
			str = "0";
		}
		}
		return str;
		
	}
	@RequestMapping("/savechangephone")
	public String saveChangePhone(BCustomer bCustomer, String newphone,
			HttpSession session){
		bCustomer = (BCustomer) session.getAttribute("customer");
		bCustomer.setMobile(newphone);
		boolean bl = customerService.updatePhoneById(bCustomer);
		if (bl) {
			return "web/index";
		}
		return "web/bindphone";
		
	}
	@RequestMapping("checkidcard")
	public String checkidcard(String realname,String idcard,HttpSession session){
		System.out.println(realname+","+idcard);
		String url = "http://netocr.com/verapi/veridenNo.do";
		String key = "YTC1BWFhUxPe5azivBFn2C";
		String secret = "d03c02270bae44a7a341f5c710d63767";
		String resultback =  IDCardUtils.doPost(url, key, secret, realname, idcard, "3001", "json");
	    System.out.println(resultback);
		String str = "";
		String st ="";
		ObjectMapper ma = new ObjectMapper();
		try {
		Map map = ma.readValue(resultback, Map.class);
		System.out.println(map);
		System.out.println(map.get("policeCheckInfo"));
		List list = (List)map.get("policeCheckInfo");
		Map t = (Map)list.get(0);
		List list2 =(List) t.get("veritem");
		Map t2 = (Map)list2.get(3);
		st=t2.get("content").toString();
		System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    BCustomer bCustomer = (BCustomer) session.getAttribute("customer");
	   // boolean bl =  resultback.contains(st);
	     if("姓名及身份证号一致".equals(st)){
	    	 
	    	 bCustomer.setIdcard(idcard);
	    	 customerService.updatePhoneById(bCustomer); 
	    	 str = "redirect:information.action";
	     }else{
	    	str = "redirect:idcard.action";
	     }
		return str;
	}

	@RequestMapping("/turntosuccess")
	public String turntoview(Integer turnid){
		String address = "";
		if(turnid==1){
			address ="redirect:web/information";
		}else{
			address = "redirect:web/idcard";
		}
		return address;
		
	}
	
}
