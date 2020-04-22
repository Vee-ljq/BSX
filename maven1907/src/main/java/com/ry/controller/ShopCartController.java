package com.ry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.ry.dto.BcartGoodsDto;
import com.ry.pojo.BCart;
import com.ry.pojo.BCollection;
import com.ry.pojo.BCustomer;
import com.ry.pojo.SPackagetype;
import com.ry.pojo.STastetype;
import com.ry.service.BcartService;
import com.ry.service.CollectionService;
import com.ry.service.WebOrdersService;

@Controller
@RequestMapping("webshopcart")
public class ShopCartController {
	@Autowired
	private BcartService bcartService;

	@Autowired
	private WebOrdersService webOrdersService;
	@Autowired
	private CollectionService collectionService;
	
	
	@RequestMapping("enter")
	public ModelAndView enterShopCart(String type,BCart bCart,HttpSession session){
		
		ModelAndView mav = new ModelAndView("web/shopcart");
		//现将此商品加入购物车 在展示购物车中其他的商品信息
		
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		bCart.setCusid(customer.getId());
		//说明是从购物车删除或者是移入收藏夹然后再次跳回到购物车
		if(!type.equals("1")){
			
			//给购物车传一个当时的系统时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			String format = sdf.format(date);
			bCart.setCreatedate(format);

	
	//从购物车中查询出信息
	//商品的id  用户的id  数量 创建时间 口味id 包装id
	//判断用户在购物车中有没有一样的商品，如果有那么就只增加数量就可以
	//先判断有没有一样的商品
	BCart bb = bcartService.selectWetherSame(bCart);
	if(bb!=null){
		//如果从购物车过来，如果数据库中已经有该属性的商品，直接删掉原来的，然后添加到查询出来的那个id
		if(bCart.getId()!=null){
			boolean deleteflag = bcartService.deleteCartById(bCart.getId());
		}
		//如果bb不为空，说明数据库中已经存在该商品
		//获取该购物车的id，增加数量，更新时间
		bb.setNum(bb.getNum()+bCart.getNum());
		bb.setCreatedate(format);
		//然后将这条数据更新到数据库中
		boolean same = bcartService.updateCartBySame(bb);
		if(same){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
	}else{
		//如果bb为空，那么数据库中不存在该商品，直接插入就可以
		if(bCart.getId()!=null){
			boolean flag = bcartService.updateCartById(bCart);
		}else{
			boolean flag = bcartService.insertShop(bCart);
			if(flag==true){
				System.out.println("插入成功");
			}else{
				System.out.println("插入失败");
			}
		}
		
	}
		}
		
		//然后将一样商品的购物车id的数量增加对应的数字,且时间变成最新的
		List<BcartGoodsDto> bcartGoodsDtos = bcartService.selectShopCartByCusid(customer.getId());
		//查询所有的口味
		List<STastetype> sTastetypes = webOrdersService.selectAllTase();
		//查询所有的包装
		List<SPackagetype> sPackagetypes = webOrdersService.selectAllPackage();
		mav.addObject("bcartGoods", bcartGoodsDtos);
		mav.addObject("taste", sTastetypes);
		mav.addObject("spackage", sPackagetypes);
		mav.addObject("goodsid", bCart.getGoodsid());
		return mav;
	}
	
	@RequestMapping("delete")
	public String deleteOneCart(Integer id){
		bcartService.deleteCartById(id);
		return "redirect:enter.action?type=1";
	}
	@RequestMapping("deleteAll")
	public String deleteAllCart(Integer[] ids){
		for (Integer integer : ids) {
			bcartService.deleteCartById(integer);
		}
		return "redirect:enter.action?type=1";
	}
	@RequestMapping("shoucangOne")
	public String shoucangOne(BCollection collection){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String format = sdf.format(date);
		collection.setCreatedate(format);
		boolean flag = collectionService.insertShoucang(collection);
		return "redirect:enter.action?type=1";
	}
	@RequestMapping("shoucangAll")
	public String shoucangAll(Integer[] goodsid,HttpSession session){
		for (Integer integer : goodsid) {
			BCollection collection = new BCollection();
			collection.setGoodsid(integer);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			String format = sdf.format(date);
			collection.setCreatedate(format);
			BCustomer customer = (BCustomer)session.getAttribute("customer");
			collection.setCusid(customer.getId());
			boolean flag = collectionService.insertShoucang(collection);
		}
		return "redirect:enter.action?type=1";
	}
}
