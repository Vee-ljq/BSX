package com.ry.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.ry.dto.NoPayDto;
import com.ry.dto.OrdersDto;
import com.ry.pojo.AreaData;
import com.ry.pojo.BAddress;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.BOrdermain;
import com.ry.pojo.Kd;
import com.ry.pojo.ViewAddr;
import com.ry.service.AddressService;
import com.ry.service.IndexService;
import com.ry.service.KdService;
import com.ry.service.OrdersService;
import com.ry.utils.LhPage;
import com.ry.utils.NowDate;
@Controller
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	private OrdersService service;
	
	@Autowired
	private KdService kdservice;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private IndexService indexService;
	
	
	//分页显示待签收列表
	@RequestMapping("/signfor")
	public ModelAndView toSignFor(OrdersDto orders,@RequestParam(required=true,defaultValue="1") Integer pageNumber,@RequestParam(required=true,defaultValue="2") Integer pageSize){
		ModelAndView mav = new ModelAndView("orders/signfor_data");
		PageInfo<OrdersDto> signforOrders = service.selectByPage(orders, pageNumber, pageSize);
		LhPage signforpage =new LhPage(signforOrders);
		mav.addObject("signforpage",signforpage );
		mav.addObject("orders", orders);
		return mav;
		
	}
	
	//单个确认收货
	@RequestMapping("/updateSignforOrder")
	public String updateSignforOrder(Integer ordersId){
	service.updateSignforOrder(ordersId);
		return ("redirect:signfor.action");
	}
	

	/*
	 * 今日新增的订单
	 * **/	
	
	@RequestMapping("/data")
	public ModelAndView toOrderData(OrdersDto orderDto,@RequestParam(defaultValue="1",required=true)Integer pageNum,@RequestParam(defaultValue="2",required=true)Integer pageSize){
	 ModelAndView mav= new ModelAndView("orders/data");	
	 orderDto.setCreatedate(NowDate.nowDay());
	 PageInfo<OrdersDto>  pageInfo=service.selelctOrders(orderDto,pageNum,pageSize);
	 LhPage page=new LhPage(pageInfo);
	 mav.addObject("page", page);
	 mav.addObject("orderDto", orderDto);
	  return mav;
	}
	
	@RequestMapping("nopay")
	public ModelAndView SkipNoPay(BCustomer customer,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		ModelAndView mav =  new ModelAndView("orders/NoPay");
		PageInfo selectByCusId = service.selectByCusId(customer.getNickname(),pageNum, pageSize);
		LhPage page = new LhPage(selectByCusId);
		mav.addObject("page", page);
		mav.addObject("customer", customer);
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView edit(NoPayDto noPayDto){
		ModelAndView mav = new ModelAndView("orders/nopayedit");
		//编辑的时候要获取此订单的id
		NoPayDto nopaydto = service.selectByOrderId(noPayDto);
		//获取所有的省
		List<AreaData> province = service.selectAllProvince();
		//获取此所有的市
		List<AreaData> city = service.selectByProcinceidToCity(nopaydto.getAreadata1().getCodeid());
		//获取此市所有的县
		List<AreaData> xian =service.selectByProcinceidToCity(nopaydto.getAreadata2().getCodeid());
		//查询出的单个订单
		mav.addObject("nopaydto", nopaydto);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("xian", xian);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/procityxian")
	public List selectCity(Integer id){
		//通过省的id来查询下面的所有市
		List<AreaData> cityList = service.selectByProid(id);
		return cityList;
	}
	@RequestMapping("saveNoPay")
	public String savaNoPay(NoPayDto nopDto){
		boolean flag = service.updateCustomer(nopDto.getBcustomer());
		
		boolean flag1 = service.updateAddress(nopDto);
		if(flag&&flag1){
			return "redirect:nopay.action";
		}else{
			return "redirect:edit.action";
		}
		
	}
	
	
	//分页显示待评价列表
		@RequestMapping("/noEvaluation")
		public ModelAndView noEvaluated(BOrdermain orders,@RequestParam(required=true,defaultValue="1") Integer pageNumber,@RequestParam(required=true,defaultValue="2") Integer pageSize){
			ModelAndView mav = new ModelAndView("orders/NoEvaluation_data");
			PageInfo<OrdersDto> signforOrders = service.selectByNoEvaluated(orders, pageNumber, pageSize);
			LhPage noEvaluatedPage =new LhPage(signforOrders);
			mav.addObject("noEvaluatedPage",noEvaluatedPage);
			mav.addObject("list",noEvaluatedPage.getPage().getList());
			mav.addObject("orders", orders);
			return mav;
		}
		
		//详情修改页面跳转
		@RequestMapping("/detailEdit")
		public ModelAndView detailEdit(BOrderdetail detail,String flag){
			ModelAndView mav = new ModelAndView("orders/detailEdit");
			OrdersDto dto = service.selectBydetailId(detail);
			//修改时地址查询 省
			List<ViewAddr> addrlist = addressService.selectByprovice();
			//市
			List<ViewAddr> selectBycity = addressService.selectBycity(-1);
			//县
			List<ViewAddr> selectByCode = addressService.selectByCode(-1);
			mav.addObject("provice", addrlist);
			mav.addObject("city", selectBycity);
			mav.addObject("Code", selectByCode);
			mav.addObject("flag", flag);
			mav.addObject("detail", dto);
			return mav;
		}
		
		@ResponseBody
		@RequestMapping("/city")
		public List city(Integer id){
			//通过省的id来查询下面的所有市
			List<ViewAddr> selectBycity = addressService.selectBycity(id);
			return selectBycity;
		}
		
		/**
		 * @param id
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/code")
		public List code(Integer id){
			//通过市的id来查询下面的所有县
			List<ViewAddr> selectByCode = addressService.selectByCode(id);
			return selectByCode;
		}
		
		
		/**待发货查询
		 * @param orders
		 * @param pageNumber
		 * @param pageSize
		 * @return
		 */
		@RequestMapping("toShipments")
		public ModelAndView toShipments(BOrdermain orders,@RequestParam(required=true,defaultValue="1") Integer pageNumber,@RequestParam(required=true,defaultValue="2") Integer pageSize){
			ModelAndView mav = new ModelAndView("orders/NoShipments_data");
			PageInfo<OrdersDto> page = service.selectToShipmentsPage(orders, pageNumber, pageSize);
			LhPage toShipments =new LhPage(page);
			mav.addObject("toShipments",toShipments );
			mav.addObject("orders", orders);
			return mav;
		}
		
		
		
		/**发货跳转
		 * @return
		 */
		@RequestMapping("ordermainMapperEdit")
		public ModelAndView ordermainMapperEdit(Integer id){
			ModelAndView mav = new ModelAndView("orders/shipmentsEdit");
			//查询快递
			List<Kd> selectByKd = kdservice.selectByKd();
			mav.addObject("id", id);
			mav.addObject("kd", selectByKd);
			return mav;
		}
		
		/**发货提交
		 * @param orders
		 * @return
		 */
		@RequestMapping("saveShipments")
		public String saveShipments(BOrdermain orders,BAddress addr){
			addr.setId(orders.getAddressid());
			if(addr.getId()!=null){
			boolean flag01= addressService.saveBAddress(addr);
			if(flag01){
				return "redirect:toShipments.action?status=1";
				}
			}
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date da = new Date();
			String format = s.format(da);
			orders.setFhdate(format);
			boolean flag = service.saveShipmentsById(orders);
			
			if(flag){
				return "redirect:toShipments.action?status=1";
			}
			return null;
		}
		
		/**
		 * 待评价订单数
		 * @return
		 */
		@RequestMapping("Count")
		public ModelAndView Count(){
			ModelAndView mav = new ModelAndView("main"); 
			Integer noEvaluationNum = indexService.noEvaluationCount();
			mav.addObject("noEvaluationNum", noEvaluationNum);
			Integer nowAddOrdersNum = indexService.nowAddOrders();
			mav.addObject("nowAddOrdersNum", nowAddOrdersNum);
			return mav;
		}

		
}
