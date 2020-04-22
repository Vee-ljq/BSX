package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.AddressDto;
import com.ry.dto.OrdersDto;
import com.ry.mapper.BOrdermainMapper;
import com.ry.mapper.SPackagetypeMapper;
import com.ry.mapper.STastetypeMapper;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BCustomer;

import com.ry.pojo.SPackagetype;
import com.ry.pojo.SPackagetypeExample;
import com.ry.pojo.STastetype;
import com.ry.pojo.STastetypeExample;
import com.ry.pojo.STastetypeExample.Criteria;

import com.ry.pojo.BOrdermain;

import com.ry.service.WebOrdersService;

@Service("webOrdersService")
public class WebOrdersServiceImp implements WebOrdersService {
	@Autowired
	private BOrdermainMapper ordermainMapper;
	
	@Autowired
	private STastetypeMapper sTastetypeMapper;
	
	@Autowired
	private SPackagetypeMapper sPackagetypeMapper;

	//所有订单信息
	@Override
	public List<OrdersDto> selectAllOrders(BOrdermain ordermain) {
		List<OrdersDto> allOrders = ordermainMapper.selectAllOrders(ordermain);
		return allOrders;
	}

	@Override
	public List<STastetype> selectAllTase() {
		STastetypeExample example = new STastetypeExample();
		Criteria createCriteria = example.createCriteria();
		List<STastetype> selectByExample = sTastetypeMapper.selectByExample(example );
		return selectByExample;
	}

	@Override
	public List<SPackagetype> selectAllPackage() {
		SPackagetypeExample example = new SPackagetypeExample();
		com.ry.pojo.SPackagetypeExample.Criteria createCriteria = example.createCriteria();
		List<SPackagetype> selectByExample = sPackagetypeMapper.selectByExample(example );
		return selectByExample;
	}


	//删除订单
	//删除订单
	//删除订单及确认收货
	@Override
	public void updateOrderStatus(BOrdermain ordermain) {
		ordermainMapper.updateByPrimaryKeySelective(ordermain);
	}

	//订单详情
	@Override
	public OrdersDto selectAddress(Integer orderid) {
		OrdersDto ordersDto = ordermainMapper.selectAddress(orderid);
		return ordersDto;
	}
	
	
	
}
