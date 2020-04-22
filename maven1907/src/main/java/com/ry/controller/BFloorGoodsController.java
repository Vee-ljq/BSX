package com.ry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BFloorgoodsDto;
import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoods;
import com.ry.service.BFloorgoodsService;
import com.ry.utils.LhPage;

@Controller
@RequestMapping("floor")
public class BFloorGoodsController {

	@Autowired
	private BFloorgoodsService service;

	@RequestMapping("data")
	public ModelAndView todata(BGoods bgoods,
			@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = "2") Integer pageSize) {
		ModelAndView mav = new ModelAndView("floor/data");
		PageInfo<BFloorgoodsDto> selectpage = service.selectbfByPage(bgoods,
				pageNum, pageSize);
		LhPage page = new LhPage(selectpage);
		mav.addObject("page", page);
		mav.addObject("bfgoods", bgoods);
		return mav;
	}

	@RequestMapping("edit")
	@ResponseBody
	public ModelAndView toEdit(BFloorgoodsDto bfgoods) {
		ModelAndView mav = new ModelAndView("floor/edit");
		/*
		 * if(bfgoods!=null && bfgoods.getId()!=null){
		 * bfgoods=service.selectEditOrAdd(bfgoods.getId());
		 * System.out.println(bfgoods);
		 * 
		 * }else{
		 */
		List<BFloorgoodsDto> goods = service.selectgoodsno();
		for (BFloorgoodsDto good : goods) {
			System.out.println(good.getbGoods().getGoodsno());
		}
		mav.addObject("goods", goods);
		mav.addObject("bfgoods", bfgoods);

		/*
		 * boolean bl = service.updateBykey(bfgoods); if(bl){
		 * System.out.println("成功"); }else{ System.out.println("失败"); }
		 */
		return mav;
	}

	@RequestMapping("savefloor")
	@ResponseBody
	public String tosave(BFloorgoodsDto dto) {

		boolean bl = false;
		if (dto.getGoodsid() != null && dto.getFlag() != null) {
			if (dto.getFlag() == 0) {
				bl = service.insertShangjia(dto);
			} else {
				bl = service.deleteshangjia(dto);
			}
			if (bl == true) {
				return "redirect:data.action";
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
}
