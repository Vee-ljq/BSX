package com.ry.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.AddressDto;
import com.ry.pojo.AreaData;
import com.ry.pojo.BAddress;
import com.ry.pojo.BCustomer;
import com.ry.service.AddressService;
import com.ry.service.OrdersService;

@Controller
@RequestMapping("webaddress")
public class WebAddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrdersService service;

	@RequestMapping("enter")
	public ModelAndView enterAddress(HttpSession session){
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		ModelAndView mav = new ModelAndView("web/address");
		//查询所有的省
		List<AreaData> selectAllProvince = service.selectAllProvince();
		//将该用户的名称，手机号，地址都遍历出来
		Map map = new HashMap();
		map.put("addressid", null);
		map.put("id", customer.getId());
		List<AddressDto> addressDtos = addressService.selectAddressByCusid(map);
		mav.addObject("addresss", addressDtos);
		mav.addObject("selectAllProvince", selectAllProvince);
		return mav;
	}
	
	@RequestMapping("bianji")
	@ResponseBody
	public AddressDto  bianjiAddress(Integer addressid,HttpSession session){
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		Map map = new HashMap();
		map.put("addressid", addressid);
		map.put("id", customer.getId());
		List<AddressDto> selectAddressByCusid = addressService.selectAddressByCusid(map);
		return selectAddressByCusid.get(0);
	}
	
	@RequestMapping("saveOrInsert")
	public String saveOrInsert(BAddress address,HttpSession session){
		if(address.getId()!=null){
			//就是更新
			boolean flag = addressService.updateAddressById(address);
		}else{
			//插入
			BCustomer customer = (BCustomer)session.getAttribute("customer");
			address.setCusid(customer.getId());
			address.setIsdefault(0);
		   boolean flag = addressService.insertAddress(address);
		}
		return "redirect:enter.action";
	}
	
	@RequestMapping("deleteAddress")
	public String deleteAddress(Integer id){
		boolean flag = addressService.deleteById(id);
		return "redirect:enter.action";
	}
	
	@RequestMapping("updateByMoren")
	public String updateByMoren(BAddress address,String type){
		if(type.equals("1")){
			//说明是点击了设为默认
			address.setIsdefault(1);
			boolean flag = addressService.updateByMoren(address);
			//将其他的都设为不默认
			boolean flag1 = addressService.updateOtherNotMoren(address);
		}
		return "redirect:enter.action";
	}
}
