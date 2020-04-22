package com.ry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.Kd;
import com.ry.service.ExpressService;
import com.ry.utils.LhPage;
@Controller
@RequestMapping("/expressdelivery")
public class ExpressController {
	@Autowired
	private ExpressService expressservice;
	@RequestMapping("/data")
	public ModelAndView toResource(Kd org,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize ){
		PageInfo<Kd> selectByPage = expressservice.selectByPage(org, pageNum, pageSize);
		ModelAndView mav=new ModelAndView("expressdelivery/data");
		LhPage page = new LhPage(selectByPage);
		mav.addObject("page", page);
		mav.addObject("org", org);
		return mav;
	}
	/**
	 * 新增或编辑的跳转
	 * @param org
	 * @return id为空则为新增
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(Kd org){
		ModelAndView mav = new ModelAndView("expressdelivery/edit2");
		/**
		 * 如果有id为编辑，没有id为增加
		 */
		if(org!=null&&org.getId()!=null){
			org = expressservice.selectById(org.getId());
		}
		mav.addObject("org", org);
		
		return mav;
		
	}
	/**
	 * 点击保存,跳转到首页2
	 * @param org
	 * @return
	 */
	@RequestMapping("save")
	public String save(Kd org){
		
		boolean savaOrUpdate=expressservice.saveOrUpdate(org);
		
		
		return ("redirect:data.action");
	}
	/**
	 * 删除单个快递
	 * @param org
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Kd org){
		
		boolean deleteById=expressservice.deleteById(org);
		
		
		return ("redirect:data.action");
		
	}
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("deletes")
	public String deletesByIds(Integer[] ids){
		boolean deleteByIds = expressservice.deleteByIds(ids);
		
		
		
		return ("redirect:data.action");
	}

}
