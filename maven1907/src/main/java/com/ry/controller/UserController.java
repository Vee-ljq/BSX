package com.ry.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Constant.Common;

import com.github.pagehelper.PageInfo;
import com.ry.dto.UserDto;
import com.ry.pojo.SUser;
import com.ry.service.OrgService;
import com.ry.service.RoleService;
import com.ry.service.UserService;
import com.ry.utils.LhPage;
import com.ry.utils.MD5Utils;
/**
 * 用户管理的相关请求
 * @author 孙大壮
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private OrgService orgService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/data")
	public ModelAndView toData(@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize,SUser user){
		ModelAndView maView = new ModelAndView("user/data");
		//封装分页数据
		PageInfo<UserDto> pageInfo = service.selectByPage(pageNum,pageSize,user);
		LhPage page = new LhPage(pageInfo);
		maView.addObject("page", page);
		maView.addObject("user",user );
		return maView;
	}
	@RequestMapping("edit")
	public ModelAndView toEdit(SUser user){
		ModelAndView mav = new ModelAndView("user/edit");
		if(user!=null&&user.getId()!=null){
			user = service.selectUserById(user.getId());
			mav.addObject("user", user);
		}
		//查询所有组织机构信息作为下拉框
		mav.addObject("orgs", orgService.selectAllPid());
		//查询所有角色信息作为下拉框
		mav.addObject("roles", roleService.selectAllId());
		return mav;
	}
	@RequestMapping("save")
	public String savaOrUpdate(SUser user){
		if(user.getPwd()!=null){
			user.setPwd(MD5Utils.string2MD5(user.getPwd()));
		}
		service.saveOrUpdate(user);
		return "redirect:data.action";
	}
	@RequestMapping("delete")
	public String delete(Integer id){
		service.deleteById(id);
		return "redirect:data.action";
	}
	
	@RequestMapping("deletes")
	public String deletes(Integer[] ids){
		service.deleteByIds(ids);
		return "redirect:data.action";
	}
}
