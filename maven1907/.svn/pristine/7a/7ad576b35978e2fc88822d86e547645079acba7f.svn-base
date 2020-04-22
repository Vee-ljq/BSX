package com.ry.service;

import java.util.List;

import com.ry.dto.AddressDto;
import com.ry.dto.OrdersDto;
import com.ry.pojo.BOrdermain;
import com.ry.pojo.SPackagetype;
import com.ry.pojo.STastetype;

public interface WebOrdersService {

	/**
	 * 所有订单信息
	 * @return
	 */
	List<OrdersDto> selectAllOrders(BOrdermain ordermain);
	/**
	 * 查询所有的口味
	 * @return
	 */
	List<STastetype> selectAllTase();
	/**
	 * 查询所有的包装
	 * @return
	 */
	List<SPackagetype> selectAllPackage();

	/**
	 * 删除订单及确认收货
	 * @param orderid
	 */
	void updateOrderStatus(BOrdermain ordermain);

	/**
	 * 查询订单详情的收货地址
	 * @param orderid
	 * @return
	 */
	OrdersDto selectAddress(Integer orderid);
	
}
