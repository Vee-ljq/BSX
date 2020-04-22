package com.ry.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.OrdersDto;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.BOrdermain;
import com.ry.service.WebOrdersService;

@Controller
@RequestMapping("/web")
public class WebOrdersController {
	@Autowired
	private WebOrdersService ordersManageService;
	
	//所有订单信息
	@RequestMapping("allOrderData")
	public ModelAndView allOrderData(HttpSession session){
		ModelAndView mav = new ModelAndView("web/order"); 
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		BOrdermain ordermain = new BOrdermain();
		ordermain.setCusid(customer.getId());
		//所有订单		
		ordermain.setStatus(null);
		List<OrdersDto> allOrders= ordersManageService.selectAllOrders(ordermain);
		mav.addObject("allOrders", allOrders);
		//待付款
		ordermain.setStatus(0);
		List<OrdersDto> noPay = ordersManageService.selectAllOrders(ordermain);		
		mav.addObject("noPay", noPay);
		//待发货
		ordermain.setStatus(1);
		List<OrdersDto> noDelivery= ordersManageService.selectAllOrders(ordermain);
		mav.addObject("noDelivery", noDelivery);
		//待签收
		ordermain.setStatus(2);
		List<OrdersDto> noSignfor= ordersManageService.selectAllOrders(ordermain);
		mav.addObject("noSignfor", noSignfor);
		//待评价
		ordermain.setStatus(3);
		List<OrdersDto> noEvaluate= ordersManageService.selectAllOrders(ordermain);
		mav.addObject("noEvaluate", noEvaluate);
		return mav;
	}
	
	//删除订单及确认收货
	@RequestMapping("updateOrderStatus")
	public String updateOrderStatus(Integer orderid,Integer status){
		BOrdermain ordermain = new BOrdermain();
		ordermain.setId(orderid);
		ordermain.setStatus(status);
		ordersManageService.updateOrderStatus(ordermain);
		return "redirect:allOrderData.action";
	}
	
	//订单详情
	@RequestMapping("orderInfo")
	public ModelAndView orderInfo(HttpSession session,Integer orderid,Integer status){	
		BCustomer customer = (BCustomer) session.getAttribute("customer");
		ModelAndView mav = new ModelAndView("web/orderinfo");
		OrdersDto ordersAddress = ordersManageService.selectAddress(orderid);  //收货地址
		mav.addObject("ordersAddress", ordersAddress); 
		
		BOrdermain ordermain = new BOrdermain();
		ordermain.setCusid(customer.getId());    //顾客id
		ordermain.setId(orderid);                //订单id
		ordermain.setStatus(status);             //状态
		List<OrdersDto> order = ordersManageService.selectAllOrders(ordermain);
		mav.addObject("order", order);
		return mav;
	}
	//跳转到待评价页面
	@RequestMapping("tocommentlist")
	public ModelAndView tocommentlist(HttpSession session,Integer orderid,Integer status){
		BCustomer customer = (BCustomer) session.getAttribute("customer");
		ModelAndView mav = new ModelAndView("web/commentlist");
		BOrdermain ordermain = new BOrdermain();
		ordermain.setCusid(customer.getId());    //顾客id
		ordermain.setId(orderid);                //订单id
		ordermain.setStatus(status);
		List<BOrderdetail> orderdetaila =null;
		List<OrdersDto> order = ordersManageService.selectAllOrders(ordermain);
		for (OrdersDto ordersDto : order) {
			orderdetaila = ordersDto.getOrderdetail();
		int num = orderdetaila.size();
			for (BOrderdetail bOrderdetail : orderdetaila) {
				System.out.println(bOrderdetail.getGoods().getGoodsname()
			);
		}
		}
		mav.addObject("orderaa", order);
		session.setAttribute("order", order.get(0));
		mav.addObject("orderdetaila", orderdetaila);
		return mav;
	}
	
	

	
}
