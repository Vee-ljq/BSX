package com.ry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Constant.Common;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ry.dto.LeftListDto;
import com.ry.dto.TreeNodeDto;
import com.ry.pojo.SResource;
import com.ry.pojo.SUser;
import com.ry.pojo.TreeNode;
import com.ry.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	@Autowired
	private ResourceService service;
	@RequestMapping("/data")
	public ModelAndView toResource(){
		return new ModelAndView("resource/data");
	}
	@ResponseBody
	@RequestMapping("resourceAll")
	public List getResourceAll(){
		List result = new ArrayList();
		result = service.selectByTree();
		return result;
	}
	@RequestMapping("toResource")
	public ModelAndView toRoleResource(Integer roleId) throws JsonProcessingException{
		ModelAndView mav = new ModelAndView("resource/data");
		List<TreeNode> result = service.selectResource(roleId);
		String jsonString =new ObjectMapper().writeValueAsString(result);
		mav.addObject("result", jsonString);
		mav.addObject("roleId", roleId);
		return mav;
	}
	@RequestMapping("save")
	@ResponseBody
	public boolean saveOrUpdateRoleResource(Integer roleId, Integer resourceId){
		//Map map = new HashMap();
		boolean flag = true;
		try{
			service.saveOrDelete(roleId, resourceId);
			//map.put("status", true);
		}catch (Exception e) {
			e.printStackTrace();
			//map.put("status", false);
			flag = false;
		}
		return flag;
	}
	
	@ResponseBody
	@RequestMapping("leftlist")
	public List<LeftListDto> selectByLeftList(HttpSession session){
		SUser user = (SUser)session.getAttribute(Common.CURRENT_USER);
		List<LeftListDto> selectByLeftList = service.selectByLeftList(user.getRoleid());
		return selectByLeftList;
	
	}
}
