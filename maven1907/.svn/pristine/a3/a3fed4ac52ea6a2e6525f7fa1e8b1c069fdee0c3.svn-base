package com.ry.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.mapper.BGoodsMapper;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodspic;
import com.ry.pojo.SUser;
import com.ry.service.GoodsService;
import com.ry.service.UserService;

@Controller
@RequestMapping("duopic")
public class DuoPicUploadController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;

	@RequestMapping("data")
	public ModelAndView uploadDuoPic(){
		ModelAndView mav = new ModelAndView("duoPic/duoPic");
		//查询出商品的id和姓名
		List<BGoods> bGoods = goodsService.selectAllGoodsId();
		//查询所有的发布人
		List<SUser> selectByRealName = userService.selectByRealName();
		mav.addObject("goods", bGoods);
		mav.addObject("users", selectByRealName);
		return mav;
	}
	@RequestMapping("saveDuoPic")
	public String saveDuoPic(BGoodspic bGoodspic){
		boolean flag = goodsService.saveDuoPic(bGoodspic);
		return "redirect:data.action";
	}
}
