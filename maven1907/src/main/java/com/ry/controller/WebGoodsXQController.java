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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BGoodsViewDto;
import com.ry.dto.CommentDto;
import com.ry.mapper.SPackagetypeMapper;
import com.ry.pojo.AreaData;
import com.ry.pojo.BComment;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BGoodsKey;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BGoodspic;
import com.ry.pojo.BGoodsview;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.SPackagetype;
import com.ry.pojo.STastetype;
import com.ry.service.BCommentService;
import com.ry.service.FootsService;
import com.ry.service.GoodsService;
import com.ry.service.OrdersService;
import com.ry.service.WebOrdersService;
import com.ry.utils.LhPage;
import com.ry.utils.NowDate;
@Controller
@RequestMapping("webgoodsxq")
public class WebGoodsXQController {
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
	
	
	@RequestMapping("data")
	public ModelAndView goodsxqPage(BGoodsKey key,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize,HttpServletRequest request,HttpSession session){
		ModelAndView mav = new ModelAndView("web/introduction");
		//通过商品id来查询整个商品信息
		BGoodsWithBLOBs bloBs = serGoodsService.selectByGoodsId(key);
		//查询所有的省
		List<AreaData> selectAllProvince = service.selectAllProvince();
		//通过订单明细表中查询该商品的销售数量
		List<BOrderdetail> bOrderdetails = service.selectDetailByGoodsid(key.getId());
		//将销售数量相加
		Integer goodsCount = 0;
		for (BOrderdetail bOrderdetail : bOrderdetails) {
			if(bOrderdetail.getNum()!=null&&!bOrderdetail.getNum().equals("")){
				goodsCount = goodsCount+Integer.parseInt(bOrderdetail.getNum());
			}
		}
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
		//查看当前商品的累计评价
		Integer GoodsComments = bCommentService.selectByComment(key.getId());
		//查询所有的口味
		List<STastetype> sTastetypes = webOrdersService.selectAllTase();
		//查询所有的包装
		List<SPackagetype> sPackagetypes = webOrdersService.selectAllPackage();
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
		//wzm插入该商品的id到足迹表
		//获取ip地址
		String ip = request.getRemoteAddr();//返回发出请求的IP地址
		BGoodsview bGoodsview=new BGoodsview();
		bGoodsview.setGoodsid(key.getId());
		bGoodsview.setIpaddr(ip);
		//从session中获取用户id
		BCustomer attribute = (BCustomer) session.getAttribute("customer");
		Integer id = attribute.getId();
		bGoodsview.setCuid(id);
		//浏览商品的时间
				NowDate now=new NowDate();
				String nowDay = now.nowDay();
				
		bGoodsview.setBrowsingtime(nowDay);
		footsService.insertfoot(bGoodsview);
		
		
		mav.addObject("provinces", selectAllProvince);
		mav.addObject("goods", bloBs);
		mav.addObject("goodsCount", goodsCount);
		mav.addObject("monthCount", monthCount);
		mav.addObject("GoodsComments", GoodsComments);
		mav.addObject("taste", sTastetypes);
		mav.addObject("package1", sPackagetypes);
		mav.addObject("goodspic", bGoodspics);
		mav.addObject("commentCount", commentCount);
		mav.addObject("bestComment", bestComment);
		mav.addObject("midComment", midComment);
		mav.addObject("badComment", badComment);
		mav.addObject("page", page);
		mav.addObject("bGoodsViewDtos", bGoodsViewDtos);
		return mav;
	}
	@ResponseBody
	@RequestMapping("proTocityToxian")
	public List<AreaData> proTocityToxian(Integer id){
		//通过省或市的id来获取下面所有的二级
		List<AreaData> selectByProcinceidToCity = service.selectByProcinceidToCity(id);
		return selectByProcinceidToCity;
	}
}
