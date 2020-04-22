package com.ry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.github.pagehelper.PageInfo;
import com.ry.dto.OrgDto;
import com.ry.pojo.SOrganization;
import com.ry.service.OrgService;
import com.ry.service.UserService;
import com.ry.utils.LhPage;
@Controller
@RequestMapping("/org")
public class OrgController {

	@Autowired
	private OrgService service;
	@Autowired
	private UserService userService;
	/**
	 * 跳转到列表页
	 * @param org
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/data")
	public ModelAndView toData(SOrganization org,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		ModelAndView mav = new ModelAndView("org/data");
		PageInfo<OrgDto> selectByPage = service.selectByPage(org, pageNum, pageSize);
		LhPage page = new LhPage(selectByPage);
		mav.addObject("page",page);
		mav.addObject("org", org);
		return mav;
	}
	/**
	 * 新增或编辑的跳转
	 * @param org
	 * @return id为空则为新增
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(SOrganization org){
		ModelAndView mav = new ModelAndView("org/edit");
		if(org!=null&&org.getId()!=null){
			org = service.selectById(org.getId());
		}
		mav.addObject("org", org);
		mav.addObject("parents", service.selectParantOrgs());
		mav.addObject("user", userService.selectByRealName());
		return mav;
		
	}
	/**
	 * 保存
	 * @param org
	 * @return
	 */
	@RequestMapping("save")
	public String saveOrg(SOrganization org){
		boolean savaOrUpdateOrg = service.savaOrUpdateOrg(org);
		return ("redirect:data.action");
	}
	/**
	 * 单件删除
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delteOrg(Integer id){
		service.deleteById(id);
		return ("redirect:data.action");
	}
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("deletes")
	public String deleteOrgs(Integer[] ids){
		service.deleteByIds(ids);
		return ("redirect:data.action");
	}
}
