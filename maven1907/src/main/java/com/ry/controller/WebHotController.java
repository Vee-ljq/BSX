package com.ry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BGoodsViewDto;
import com.ry.dto.BTjgoodsDto;
import com.ry.dto.CommentDto;
import com.ry.pojo.AreaData;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsKey;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BGoodspic;
import com.ry.pojo.BGoodstaste;
import com.ry.pojo.BGoodstaste2;
import com.ry.pojo.BGoodsview;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.SPackagetype;
import com.ry.pojo.STastetype;
import com.ry.pojo.ViewAddr;
import com.ry.service.BCommentService;
import com.ry.service.FootsService;
import com.ry.service.GoodsService;
import com.ry.service.GoodstypeService;
import com.ry.service.OrdersService;
import com.ry.service.WebOrdersService;
import com.ry.utils.LhPage;
import com.ry.utils.NowDate;

@Controller
@RequestMapping("/webHot")
public class WebHotController {

	@Autowired
	private GoodsService serGoodsService;
	@Autowired
	private OrdersService service;
	@Autowired
	private BCommentService bCommentService;
	@Autowired
	private WebOrdersService webOrdersService;
	@Autowired
	private FootsService footsService;
@Autowired
private GoodstypeService goodtypeService;
	
@RequestMapping("/toHot/{goodsid}")	

	public ModelAndView toHot(@PathVariable Integer goodsid,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize,HttpServletRequest request,HttpSession session){
	ModelAndView mav=new ModelAndView("web/hot");
	//通过商品id查询TjGoodsDto
	BTjgoodsDto bjdto=new BTjgoodsDto();
	BGoods good=new BGoods();
	good.setId(goodsid);
	bjdto.setGoods(good);
	bjdto =goodtypeService.selectQuickGoodsByGoodsid(bjdto);
	//查询所有省份信息
	List<ViewAddr> allpro = goodtypeService.selectAllProvence();
	//月销量
	int monthnum=goodtypeService.countMonthOrder(goodsid);
	
	//累计销量
	int allordernum=goodtypeService.countAllOrderNum(goodsid);
	//累计评价数量
	int countcomment=goodtypeService.countAllCommentNum(goodsid);
	//显示该商品所有的口味
	 List<BGoodstaste>  tastes =goodtypeService.selectTasteByGoodsid(goodsid);
	//显示所有商品包装
	 List<BGoodstaste2> packages=goodtypeService.selectPackageByGoodsid(goodsid);
	
	mav.addObject("bjdto", bjdto);
	mav.addObject("allpro", allpro);
	mav.addObject("monthnum", monthnum);
	mav.addObject("allordernum", allordernum);
	mav.addObject("goodsid", goodsid);
	mav.addObject("countcomment", countcomment);
	mav.addObject("tastes", tastes);
	mav.addObject("packages", packages);
	
	
	//通过商品id来查询整个商品信息
	BGoodsKey key=new BGoodsKey();
	key.setId(goodsid);
			BGoodsWithBLOBs bloBs = serGoodsService.selectByGoodsId(key);
			
			
			//获取当前的系统时间，然后截取年和月
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			String format = sdf.format(date);
			String substring = format.substring(0, 7);
			//拿截取好的时间格式去数据库中查询
			//将截取好的时间和商品id放进map中进行查询
			Map map = new HashMap();
			map.put("goodsid", key.getId());
			map.put("substring", substring);
			//查询出本月的当前订单
			List<BOrderdetail> orderdetails = service.selectByGoodsidAndSubstring(map);
			Integer monthCount = 0;
			for (BOrderdetail bOrderdetail : orderdetails) {
				if(bOrderdetail.getNum()!=null&&!bOrderdetail.getNum().equals("")){
					monthCount = monthCount+Integer.parseInt(bOrderdetail.getNum());
				}
			}
			
			
			
			//查询当前商品的所有图片
			List<BGoodspic> bGoodspics = serGoodsService.selectAllPicByGoodsId(key.getId());
			//查看所有评价的数量
			Integer commentCount = bCommentService.selectAllComment(key.getId());
			//查看所有好评的数量
			Map map2= new HashMap();
			map2.put("goodsid", key.getId());
			map2.put("levelid", 0);
			Integer bestComment = bCommentService.selectBestComment(map2);
			//查看所有差评的数量
			Map map3= new HashMap();
			map3.put("goodsid", key.getId());
			map3.put("levelid", 1);
			Integer midComment = bCommentService.selectMidComment(map3);
			//查看所有中评的数量
			Map map4= new HashMap();
			map4.put("goodsid", key.getId());
			map4.put("levelid", 2);
			Integer badComment = bCommentService.selectBadComment(map4);
			//查询所有的评价
			PageInfo<CommentDto> commentDtos = bCommentService.selectAllCommentContent(key.getId(),pageNum,pageSize);
			LhPage page = new LhPage(commentDtos);
			//查看当前用户的展示之前的足迹商品
			List<BGoodsViewDto> bGoodsViewDtos =  footsService.selectCuidGoodsView();
			
			
			
			
			mav.addObject("goods", bloBs);	
			mav.addObject("monthCount", monthCount);
			mav.addObject("goodspic", bGoodspics);
			mav.addObject("commentCount", commentCount);
			mav.addObject("bestComment", bestComment);
			mav.addObject("midComment", midComment);
			mav.addObject("badComment", badComment);
			mav.addObject("page", page);
			mav.addObject("bGoodsViewDtos", bGoodsViewDtos);
	
	return mav;
}
@RequestMapping("showcity")
@ResponseBody
public List<ViewAddr> showCity(Integer provenceid){
	List<ViewAddr> citylist=goodtypeService.selectAllCityByProid(provenceid);
	return citylist;
	
}
@RequestMapping("showXian")
@ResponseBody

public List<ViewAddr> showXian(Integer cityid){
	List<ViewAddr> xianlist=goodtypeService.selectAllXianByCityid(cityid);
	return xianlist;
}

}
