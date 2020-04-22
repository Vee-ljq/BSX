package com.ry.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.NoPayDto;
import com.ry.mapper.AreaDataMapper;
import com.ry.mapper.BAddressMapper;
import com.ry.mapper.BCustomerMapper;
import com.ry.mapper.BOrderdetailMapper;
import com.ry.mapper.BOrdermainMapper;
import com.ry.pojo.AreaData;
import com.ry.pojo.AreaDataExample;
import com.ry.pojo.BAddress;
import com.ry.pojo.BAddressExample;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.BOrderdetailExample;
import com.ry.pojo.BOrderdetailExample.Criteria;
import com.ry.pojo.BOrdermain;
import com.ry.pojo.BOrdermainExample;
import com.ry.dto.OrdersDto;
import com.ry.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImp implements OrdersService {
	@Autowired
	private BOrdermainMapper ordermainMapper;
	@Autowired
	private BOrderdetailMapper orderdetailMapper;
	
	@Autowired
	private AreaDataMapper mapper;
	
	@Autowired
	private BAddressMapper BAddressMapper;
	
	@Autowired
	private BCustomerMapper customerMapper;
	
	@Autowired
	private BAddressMapper addressMapper;
	
	@Autowired
	private BOrderdetailMapper BOrderdetail;

	@Override
	public PageInfo<OrdersDto> selelctOrders(OrdersDto orderDto,
			Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrdersDto> list=ordermainMapper.selectByPageToday(orderDto);
		PageInfo<OrdersDto> pageInfo=new PageInfo<OrdersDto>(list);
		return pageInfo;
	}


	@Override
	public PageInfo selectByCusId(String nickname,Integer PageNum,Integer PageSize) {
		PageHelper.startPage(PageNum,PageSize);
		List<NoPayDto> selectByCusId = ordermainMapper.selectByCusId(nickname);
		PageInfo pageInfo = new PageInfo(selectByCusId);
		return pageInfo;
	}
	@Override
	public NoPayDto selectByOrderId(NoPayDto noPayDto) {
		NoPayDto selectByOrderId = ordermainMapper.selectByOrderId(noPayDto);
		return selectByOrderId;
	}


	/**
	 * 分页查询所有订单
	 */
	@Override
	public PageInfo<OrdersDto> selectByPage(OrdersDto orders,
			Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<OrdersDto> signforOrders = ordermainMapper.selectSignforByPage(orders);

		return new PageInfo<OrdersDto>(signforOrders);
	}
	@Override
	public List<AreaData> selectAllProvince() {
		AreaDataExample example = new AreaDataExample();
		com.ry.pojo.AreaDataExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andParentidEqualTo(0);
		List<AreaData> selectByExample = mapper.selectByExample(example);
		return selectByExample;
	}
	@Override
	public List<AreaData> selectByProid(Integer id) {
		AreaDataExample example = new AreaDataExample();
		com.ry.pojo.AreaDataExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andParentidEqualTo(id);
		List<AreaData> selectByExample = mapper.selectByExample(example );
		return selectByExample;
	}

	/**
	 * 确认收货
	 */
	@Override
	public void updateSignforOrder(Integer ordersId) {
		
		ordermainMapper.updateStatusById(ordersId);
		
	}


	@Override
	public PageInfo<OrdersDto> selectByNoEvaluated(BOrdermain orders,
			Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<OrdersDto> list = ordermainMapper.selectByStatus(orders);
		return new PageInfo<OrdersDto>(list);
	}
	@Override
	public List<AreaData> selectByProcinceidToCity(Integer codeid) {
		AreaDataExample example = new AreaDataExample();
		com.ry.pojo.AreaDataExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andParentidEqualTo(codeid);
		List<AreaData> selectByExample = mapper.selectByExample(example );
		return selectByExample;
	}


	@Override
	public OrdersDto selectBydetailId(BOrderdetail detail) {
		return ordermainMapper.selectBydetailId(detail);
	}


	@Override
	public PageInfo<OrdersDto> selectToShipmentsPage(BOrdermain orders,
			Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<OrdersDto> list = ordermainMapper.selectByStatus(orders);
		return new PageInfo<OrdersDto>(list);
	}


	@Override
	public boolean saveShipmentsById(BOrdermain orders) {
	
		if(ordermainMapper.updateByPrimaryKeySelective(orders)==1){
			return true;
		};
		
		return false;
	}



	@Override
	public boolean updateCustomer(BCustomer bcustomer) {
	
		int num  = customerMapper.updateByPrimaryKeySelective(bcustomer);
		if(num==1){
			return true;
		}else{
			return false;
		}
		
	}


	@Override
	public boolean updateAddress(NoPayDto nopDto) {
		BAddress address = new BAddress();
		address.setProviceid(nopDto.getAreadata1().getCodeid());
		address.setCityid(nopDto.getAreadata2().getCodeid());
		address.setAreaid(nopDto.getAreadata3().getCodeid());
		address.setAddress(nopDto.getBaddress().getAddress());
		BAddressExample example = new BAddressExample();
		com.ry.pojo.BAddressExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(nopDto.getAddressid());
		int updateByExampleSelective = addressMapper.updateByExampleSelective(address, example );
		if(updateByExampleSelective==1){
			return true;
		}else{
			return false;
		
		}
	}


	@Override
	public List<BOrderdetail> selectDetailByGoodsid(Integer id) {
		BOrderdetailExample example = new BOrderdetailExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andGoodsidEqualTo(id);
		List<BOrderdetail> selectByExample = orderdetailMapper.selectByExample(example );
		return selectByExample;
	}
	@Override
	public List<BOrderdetail> selectByGoodsidAndSubstring(Map map) {
		List<BOrderdetail> orderdetails = orderdetailMapper.selectByGoodsidAndSubstring(map);
		return orderdetails;
	}


	@Override
	public List<BOrderdetail> selectGoodsDetail(Integer goodsid) {
		BOrderdetailExample example = new BOrderdetailExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andGoodsidEqualTo(goodsid);
		List<BOrderdetail> selectByExample = BOrderdetail.selectByExample(example);
		return null;
	}

	//点击设为默认地址
	@Override
	public int updateDefaultAdd(Integer defaultid) {
		int asDef=addressMapper.updateAsDefautlAdd(defaultid);
		int notasDef=addressMapper.updateNotAsDefautlAdd(defaultid);
		if(asDef>0&&notasDef>0){
			return 1;
		}
		return 0;
	}


	@Override
	public int insertOrderDto(OrdersDto orddto ,Integer type) {
		//返回插入主表后的id
		ordermainMapper.insertSelective(orddto);
		int mainid=orddto.getId();
		//从立即支付跳转
		if(type!=2){
			com.ry.pojo.BOrderdetail det = orddto.getOrderdetail1();
			det.setMainid(mainid);
		    orderdetailMapper.insertSelective(det);
		}
		//点击购物车的结算
		else{
			 List<com.ry.pojo.BOrderdetail> list = orddto.getOrderdetail();
			for (BOrderdetail bOrderdetail : list) {
				bOrderdetail.setMainid(mainid);
				orderdetailMapper.insertSelective(bOrderdetail);
			}
		}
		//更新明细totalPrice
		orderdetailMapper.updateDetailTotalPriById(mainid);
		//更新主表的totalcount
		ordermainMapper.updateMainTotalPriById(mainid);
		return mainid;
	}

	
	//获得当前订单主表中最大的id
	@Override
	public int selectMaxId() {
		int maxid=ordermainMapper.selectMaxId();
		return maxid;
	}


	@Override
	public void updateOrderMain(OrdersDto orddto) {
		BOrdermain record=orddto;
		BOrdermainExample example=new BOrdermainExample();
		com.ry.pojo.BOrdermainExample.Criteria cri = example.createCriteria();
		cri.andOrdernoEqualTo(orddto.getOrderno());
		ordermainMapper.updateByExampleSelective(record, example);
		
	}
}


