package com.ry.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ry.dto.OrdersDto;

import com.ry.dto.NoPayDto;
import com.ry.pojo.AreaData;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.BOrdermain;

import com.ry.dto.OrdersDto;


public interface OrdersService {


	PageInfo selectByCusId(String nickname,Integer PageNum,Integer PageSize);
	NoPayDto selectByOrderId(NoPayDto noPayDto);

	/**
	 * 分页查询所有订单
	 * @param orders
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PageInfo<OrdersDto> selectByPage(OrdersDto orders,Integer pageNumber,Integer pageSize);
	//查询所有的省
	List<AreaData> selectAllProvince();
	//通过省的id查询下面所有的市
	List<AreaData> selectByProid(Integer id);


	/**
	 * 确认收货
	 * @param ordersId
	 */
	void updateSignforOrder(Integer ordersId);


//今日新增订单
	PageInfo<OrdersDto> selelctOrders(OrdersDto orderDto, Integer pageNum,
			Integer pageSize);
	//通过省的id来来查询所有的市
	List<AreaData> selectByProcinceidToCity(Integer codeid);
	//修改客户的用户名以及手机号
	boolean updateCustomer(BCustomer bcustomer);
	//修改客户此订单中的地址
	boolean updateAddress(NoPayDto nopDto);
	
	
	/**待评价查询
	 * @param orders
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PageInfo<OrdersDto> selectByNoEvaluated(BOrdermain orders,
			Integer pageNumber, Integer pageSize);
	
	/**查询商品详情
	 * @param detail
	 * @return
	 */
	OrdersDto selectBydetailId(BOrderdetail detail);
	/**待发货
	 * @param orders
	 * @return
	 */
	
	PageInfo<OrdersDto> selectToShipmentsPage(BOrdermain orders,
			Integer pageNumber, Integer pageSize);
	/**发货修改
	 * @param orders
	 * @return
	 */
	boolean saveShipmentsById(BOrdermain orders);
	/**
	 * 通过商品的id来查询订单详情表中商品数量相加
	 * @param id
	 * @return
	 */
	List<BOrderdetail> selectDetailByGoodsid(Integer id);
	//将截取好的时间和商品id一起进行查询
	List<BOrderdetail> selectByGoodsidAndSubstring(Map map);
	/**查询商品包装信息
	 * @param goodsid
	 * @return
	 */
	List<BOrderdetail> selectGoodsDetail(Integer goodsid);
	//点击设为默认地址
	int updateDefaultAdd(Integer defaultid);
	//提交订单，保存
	int insertOrderDto(OrdersDto orddto,Integer type);
	//获得当前订单主表中最大的id
	int selectMaxId();
	//更新已付款等状态
	void updateOrderMain(OrdersDto orddto);
}
