package com.ry.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.dto.OrdersDto;
import com.ry.pojo.Kd;
import com.ry.service.KdService;
import com.ry.utils.KdniaoTrackQueryAPI;
@Controller
@RequestMapping("goodskd")
public class KuaiDiNiaoContrullor {
	@Autowired
	private KdService service;
	//物流的相关信息
	@ResponseBody
	  @RequestMapping("selectwuliu")
	  public String selectwl(String wlno,String logisticsum){
	 KdniaoTrackQueryAPI kd=new KdniaoTrackQueryAPI();
	 String orderTracesByJson=null;
	 try {
	  orderTracesByJson = kd.getOrderTracesByJson(logisticsum, wlno);
	  
	 } catch (Exception e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	 }
	  return  orderTracesByJson;
	   
	  }
	/**
	 * 跳转到物流页面
	 * @return
	 */
	@RequestMapping("towuliu")
	public String towuliu(OrdersDto ordersdto,HttpServletRequest request){
		Integer wlid = ordersdto.getWlid();
		Kd selectByid = service.selectByid(wlid);
		String wlno = ordersdto.getWlno();
		request.setAttribute("kd", selectByid);
		request.setAttribute("wlno", wlno);
		return "web/logistics";
	}
	
}
