package com.ry.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.BGoodsViewDto;
import com.ry.dto.OrdersDto;
import com.ry.pojo.BGoodsview;
import com.ry.pojo.BOrderdetail;
import com.ry.service.RegisterService;
import com.ry.service.StatisticAnalysisService;

@Controller
@RequestMapping("statistic")
public class StatisticAnalysisController {
	
	@Autowired
	private RegisterService RegisterService;
	
	@Autowired
	private StatisticAnalysisService statisticService;

	/*用户注册统计分析*/
	@RequestMapping("userStatistics")
	public ModelAndView UserStatistics(){
		ModelAndView mav = new ModelAndView("echarts/UserStatistics");
		//查询用户统计信息
		List timeList= RegisterService.selectAllCount();
	    mav.addObject("date", timeList);
		return mav;
		
	}

	/*人均消费统计分析*/
	@RequestMapping("perCapitaConsumption")
	public ModelAndView  perCapitaConsumption(){
		ModelAndView mav = new ModelAndView("echarts/consumption");
		List<OrdersDto> rjConsumption = statisticService.perCapitaConsumption();
		
		//图例
		List<String> typenameList = new ArrayList<String>();
		for (OrdersDto ordersDto : rjConsumption) {
			for (BOrderdetail detail : ordersDto.getOrderdetail()) {
				String typeName = detail.getGoods().getGoodstype().getTypename();
				typenameList.add("'"+typeName+"'");
			}
		}
		
		//饼状图
		List<String> rj = new ArrayList<String>();
		for (OrdersDto ordersDto : rjConsumption) {
			for (BOrderdetail detail : ordersDto.getOrderdetail()) {
				String typeName = detail.getGoods().getGoodstype().getTypename();
				Float value = detail.getGoods().getGoodstype().getRj();
				rj.add("{value:"+value+",name:'"+typeName+"'}");
			}
		}
		
		mav.addObject("typenameList", typenameList);
		mav.addObject("rj", rj);
		return mav;
	}

	
	

	/*商品流量统计分析*/
	@RequestMapping("goodsFlow")
	public ModelAndView goodsFlow(){
		ModelAndView mav = new ModelAndView("echarts/goodsFlow");
		List<BGoodsViewDto> goodsFlow = statisticService.goodsFlow();
		
		//图例
		List<String> typenameList =new ArrayList<String>(); 
		for (BGoodsViewDto bGoodsViewDto : goodsFlow) {
			typenameList.add("'"+bGoodsViewDto.getsGoodstype().getTypename()+"'");
		}
		mav.addObject("typename", typenameList);
		
		//图例
		List<String> valueList =new ArrayList<String>(); 
		for (BGoodsViewDto bGoodsViewDto : goodsFlow) {
			String typeName = bGoodsViewDto.getsGoodstype().getTypename();
			Integer value = bGoodsViewDto.getsGoodstype().getGoodsFlow();
			valueList.add("{value:"+value+",name:'"+typeName+"'}");
		}
		mav.addObject("value", valueList);
		return mav;
	}
	/**
	 * 销售金额统计
	 * @return
	 */
	@RequestMapping("/salesamount")
	public ModelAndView tosaleamount(){
		ModelAndView mav = new ModelAndView("echarts/salesamount");
		List<OrdersDto> salesmoney = statisticService.salesmoney();
		List<String> xtypenameList = new ArrayList<String>();
		List ymoney = new ArrayList();
		for (OrdersDto ordersDto : salesmoney) {
			List<BOrderdetail> orderdetail = ordersDto.getOrderdetail();
			for (BOrderdetail bOrderdetail : orderdetail) {
				String typename = bOrderdetail.getGoods().getGoodstype().getTypename();
				Float value = bOrderdetail.getGoods().getGoodstype().getSalesmoney();
			   xtypenameList.add("'"+typename+"'");
			   ymoney.add(value);
			}
		}
		System.out.println(xtypenameList.toString());
		mav.addObject("xtypenameList", xtypenameList);
		mav.addObject("ymoney", ymoney);
		return mav;
	}
	


}
