package com.ry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ry.dto.CollectionDto;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrderdetail;
import com.ry.service.CollectionService;
@Controller
@RequestMapping("webCollection")
public class CollectionController {

	@Autowired
	private CollectionService CollectionService;
	
	/**收藏跳转
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("toCollection")
	public String toCollection(HttpSession session,HttpServletRequest request){
		//获取用户id
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		//如果用户id为空跳转登陆
		if(customer==null){
			return "redirect:../web/login.action";
		}
		//根据用户id查询收藏夹信息
		List<CollectionDto> bclist = CollectionService.selectAllCollection(customer.getId());
		request.setAttribute("bclist", bclist);
		return "web/collection";
		

	}
	
	
	
	
}
