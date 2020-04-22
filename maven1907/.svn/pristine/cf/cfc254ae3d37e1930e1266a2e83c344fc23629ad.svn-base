package com.ry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.dto.GoodsDto;
import com.ry.dto.SGood;
import com.ry.dto.slidegoodsDto;
import com.ry.pojo.BCart;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BMessageWithBLOBs;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.SGoodstype;
import com.ry.service.BFloorgoodsService;
import com.ry.service.BcartService;
import com.ry.service.BmessageService;
import com.ry.service.GoodsService;
import com.ry.service.GoodstypeService;
import com.ry.service.OrdersService;
import com.ry.utils.LhPage;
@Controller
@RequestMapping("/webHome")
public class WebHomeController {
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodstypeService GoodstypeService;
	
	@Autowired
	private GoodsService GoodsService;
	
	@Autowired
	private BFloorgoodsService BFloorgoodsService;
	
	@Autowired
	private BmessageService BmessageService;
	
	@Autowired
	private BcartService BcartService;
	
	@Autowired
	private OrdersService orderService;
	

	@RequestMapping("index")
	public ModelAndView webIndex(HttpSession session){
		ModelAndView mav = new ModelAndView("web/index");
		//获取商品分类的一级菜单
		List<SGoodstype> selectAllOne = GoodstypeService.selectAllOne();
		
		//获取轮播图
		List<slidegoodsDto> slidegoods = GoodsService.selectSlidegoods();
		
		//获取今日推荐
		List<BFloorgoods> BFloorgoods = BFloorgoodsService.selectBFloorgoods();
		
		//获取闪购商品
		List<BTjgoodsDto> sgGoods = GoodsService.selectActGoods(0);
		//获取一个随机数
		int a = (int)Math.floor((Math.random()*sgGoods.size()));
		//获取团购商品
		List<BTjgoodsDto> tgGoods = GoodsService.selectActGoods(1);
		
		int b = (int)Math.floor((Math.random()*tgGoods.size()));
		//获取活动商品
		List<BTjgoodsDto> hdGoods = GoodsService.selectActGoods(2);
		//获取商品列表
		 List<SGood> allgoods =  GoodstypeService.selectTwoClass(null);
		 
		 //获取新闻头条
		 List<BMessageWithBLOBs> bm = BmessageService.selectAllBmessge();
		 BCustomer cus = (BCustomer)session.getAttribute("customer");
		 Integer num=0;
		 if(cus!=null&&cus.getId()!=null){
		 //获取购物车数量
		  num = BcartService.selectCartCount(cus.getId());
		 }
		
		
		mav.addObject("classOne", selectAllOne);
		mav.addObject("slidegoods", slidegoods);
		mav.addObject("BFloorgoods", BFloorgoods);
		mav.addObject("sgGoods", sgGoods.get(0));
		mav.addObject("tgGoods", tgGoods.get(b));
		mav.addObject("hdGoods", hdGoods);
		mav.addObject("allgoods", allgoods);
		mav.addObject("bmdto", bm);
		session.setAttribute("num", num);
		return mav;
	}
	
	
	/**查询二级商品菜单及商品
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("goodsCategory")
	public List<SGood> goodsCategory(Integer id){
		List<SGood> dto = GoodstypeService.selectTwoClass(id);
		return dto;
	}
	
	
	

	
	/**轮播图跳转
	 * @param id
	 * @return
	 */
	@RequestMapping("/info/{id}")
	public String aa(@PathVariable Integer id){
		return "redirect:../../webgoodsxq/data.action?id="+id;
	}
	
	
	
	/**添加购物车
	 * @param bc
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("bcatrt")
	public Integer bcatrt(BCart bc,HttpSession session){
		 BCustomer cus = (BCustomer)session.getAttribute("customer");
		 Integer num = 0;
		 //获取购物车数量
		 num = BcartService.selectCartCount(cus.getId());
		 bc.setCusid(cus.getId());
		 //获取添加时间
		 Date time = new Date();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String format2 = format.format(time);
		 bc.setCreatedate(format2);
		 bc.setNum(1);
		 //查询商品包装信息
		 List<BOrderdetail> bod = orderService.selectGoodsDetail(bc.getGoodsid());
		 if(bod!=null){
		 for (BOrderdetail bOrderdetail : bod) {
			 bc.setTasteid(bOrderdetail.getTastedid());
			 bc.setPackageid(bOrderdetail.getPackageid());
		}}
		 //插入商品到购物车
		boolean b = BcartService.insertGoods(bc);
		if(b){
			num+=1;
		}
	return num;
	}	
	
	
	
	
	
	
	
	
	/**
	 * @param typeid
	 * @param goodsid
	 * @param goodsname
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("toList")
	public ModelAndView toList(HttpSession session,Integer sflag,Integer pid,String tiaojian,Integer goodsid,Integer flag,Integer kg,String dw,Integer typeid,String goodsname,@RequestParam(required=true,defaultValue="1") Integer pageNumber,@RequestParam(required=true,defaultValue="10") Integer pageSize){
		ModelAndView mav = new ModelAndView("web/list");
		
		if(pid!=null||(pid==null&&flag!=null&&flag==0)){
		//查询头部信息
		List<SGood> lig =  GoodstypeService.selcetTop(pid);
		mav.addObject("top", lig);
		}
		//查询商品信息
		if(pid!=null){
			Map map = new HashMap();
			map.put("flag1", flag);
			map.put("zhongl", kg);
			map.put("dangw", dw);
			if(typeid==null){
				map.put("typeid", pid);
			}else{
			map.put("typeid", typeid);
		}
			PageInfo<SGood> page = GoodstypeService.selectBytypeid(map,pageNumber,pageSize);
			LhPage pa = new LhPage(page);
			mav.addObject("page", pa);
			mav.addObject("flag", flag);
			mav.addObject("typeid", typeid);
			mav.addObject("goodsid", goodsid);
				//if(flag!=null&&0==flag){
					session.setAttribute("tid", pid);
					mav.addObject("tid", pid);	
				//}
			}else{
		//根据名字模糊查询
		PageInfo<GoodsDto> page = GoodsService.selectByGoodsName(goodsname,pageNumber,pageSize);
		LhPage pa = new LhPage(page);
		mav.addObject("page", pa);
		}
		if((sflag!=null&&sflag==3&&!"".equals(tiaojian)&&tiaojian!=null)||(sflag!=null&&sflag==3&&typeid==null&&pid==null&&!"".equals(tiaojian)&&tiaojian!=null)){
			PageInfo<BGoodsWithBLOBs> bloBs = goodsService.selectByTiaojian(tiaojian,pageNumber,pageSize);
			LhPage page = new LhPage(bloBs);
			mav.addObject("page", page);
		}
		return mav;
	}
	
	
	}
