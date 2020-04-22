package com.ry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.SRole;
import com.ry.service.RoleService;
import com.ry.utils.LhPage;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@RequestMapping("data")
	public ModelAndView toData(SRole role,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		ModelAndView mav = new ModelAndView("role/data");
		PageInfo selectByPage = service.selectByPage(role,pageNum, pageSize);
		LhPage page = new LhPage(selectByPage);
		mav.addObject("page", page);
		mav.addObject("role", role);
		return mav;
	}
	
	@RequestMapping("edit")
	public ModelAndView saveOrUpdate(SRole role){
		ModelAndView mav = new ModelAndView("role/edit");
		if(role!=null&&role.getId()!=null){
			role = service.selectById(role.getId());
		}
		mav.addObject("role", role);
		return mav;
	}
	@RequestMapping("save")
	public String save(SRole role){
		service.updateRole(role);
		return ("redirect:data.action");
	}
	@RequestMapping("delete")
	public String deleteRole(Integer id ){
		service.deleteRole(id);
		return ("redirect:data.action");
	}
	@RequestMapping("deletes")
	public String deleteRoles(Integer[] ids ){
		for (Integer integer : ids) {
			service.deleteRole(integer);
		}
		return ("redirect:data.action");
	}
}
