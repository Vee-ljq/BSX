package com.ry.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BTjgoodsWithBLOBs;
import com.ry.service.STHgoodsService;
import com.ry.utils.LhPage;

import com.ry.pojo.SGoodstype;

import com.ry.pojo.SUser;

import java.util.List;


@Controller
@RequestMapping("goods")
public class STHgoodsController {

	@Autowired
	private STHgoodsService stHgoodsService;
	
	//查询活动
	@RequestMapping("/activitiesData")
	public ModelAndView activitiesManage(BTjgoodsDto bTjgoodsDto,@RequestParam(required=true,defaultValue="1") Integer pageNumber,@RequestParam(required=true,defaultValue="2") Integer pageSize){
		ModelAndView mav = new ModelAndView("goodsFabu/activities_data");
		PageInfo<BTjgoodsDto> goodsInfo = stHgoodsService.selectactivitiesByPage(bTjgoodsDto,pageNumber,pageSize);
		LhPage activitiesPage = new LhPage(goodsInfo);
		mav.addObject("activitiesPage", activitiesPage);
		mav.addObject("type", bTjgoodsDto.getContexttopic());
		return mav;
	}
	
	//点击编辑活动,展示活动信息，用于添加或修改活动，有id为修改，没id为添加
	@RequestMapping("/activitiesEdit")
	public ModelAndView activitiesEdit(Integer id){
		ModelAndView mav = new ModelAndView("goodsFabu/activities_edit");
		BTjgoodsDto bTjgoodsDto = null;
		if(id!=null){
			bTjgoodsDto = stHgoodsService.selectActivitiesInfoById(id);
			mav.addObject("goodsInfo", bTjgoodsDto);
		}	
		return mav;
		
	}
	
	//添加或修改活动
	@RequestMapping("/AddOrupdateActivities")
	public String AddOrupdateActivities(BTjgoodsWithBLOBs bTjgoodsWithBLOBs){
		stHgoodsService.AddOrupdateActivities(bTjgoodsWithBLOBs);
		return "redirect:activitiesData.action";
	}
	

	@RequestMapping("fabu")
	public ModelAndView goodsfabu(){
		ModelAndView mav = new ModelAndView("goodsFabu/goodsFabu1");		
		List<SGoodstype> goodstypes = stHgoodsService.selectGoodsType();
		
		List<SUser> users = stHgoodsService.selectAllUser();
		mav.addObject("goodstypes", goodstypes);
		mav.addObject("users", users);
		return mav;
	}
	@ResponseBody
	@RequestMapping("erjimenu")
	public List<SGoodstype> erjiMenu(Integer id){
		
		List<SGoodstype> sGoodstypes = stHgoodsService.selectByYiid(id);
		System.out.println("1111");
		return sGoodstypes;
	}
	@RequestMapping("saveGoods")
	public String saveGoods(BGoodsWithBLOBs bGoods){
		boolean flag = stHgoodsService.insertGoods(bGoods);
	
		return "redirect:fabu.action";
		
		
	}
	
}
