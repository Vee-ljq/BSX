package com.ry.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.GoodsDto;
import com.ry.dto.SGood;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BTjgoodsKey;
import com.ry.pojo.BTjgoodsWithBLOBs;
import com.ry.pojo.SGoodstype;
import com.ry.pojo.SUser;
import com.ry.service.GoodsService;
import com.ry.service.GoodstypeService;
import com.ry.utils.LhPage;
@Controller
@RequestMapping("/goodstype")
public class GoodstypeController {

	@Autowired
	private GoodstypeService goodstypeService;
	@Autowired
	GoodstypeService service;
	@RequestMapping("data")
	public ModelAndView tianj(SGood sg,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=true,defaultValue="3") Integer pageSize){
		PageInfo<SGood> selectGoodselect = service.selectGoodselect(sg, pageNum, pageSize);
		ModelAndView mav= new ModelAndView("goodstype/data");
		LhPage page = new LhPage(selectGoodselect);
		mav.addObject("page", page);
		mav.addObject("org", sg);
		return mav;
	}
	
	//单个删除
	@RequestMapping("delete1")
	public String tianj(BGoods sg){
		service.deleteGoods(sg.getId());
		return ("redirect:data.action");
	}
	
	//批量删除
	@RequestMapping("deletes1")
	public String qlsc(int [] ids){
		boolean deleteids = service.deleteids(ids);
		return ("redirect:data.action");
	}
	
	//跳转添加一级商品
	@RequestMapping("tjsp")
	public ModelAndView tjsp(){
		return new ModelAndView("goodstype/edit3");
	}
	//添加一级商品
		@RequestMapping("tjsplx")
		public String tjsp(SGoodstype sGoodstype){
			sGoodstype.setPid(0);
			boolean delet= service.insertGoods(sGoodstype);
			
			return ("redirect:data.action");
		}
	//跳转添加二级商品并遍历一级菜单
		@RequestMapping("tjej")
		public ModelAndView tjej(){
			ModelAndView mav=new ModelAndView("goodstype/edit4");
			List<SGoodstype> selectids = service.selectids();
			mav.addObject("selectids", selectids);
			return mav;
		}
	//添加二级商品
		@RequestMapping("tjejlx")
		public String tjej1(SGoodstype goodstype){
			goodstype.setPid(goodstype.getId());
			goodstype.setId(0);
			service.inserterji(goodstype);
			return ("redirect:data.action");
		}
		//添加三级商品
		@RequestMapping("tjsj")
		public ModelAndView tjsj(){
			ModelAndView mav=new ModelAndView("goodstype/edit5");
			List<SGoodstype> selectids = service.selectids();
			List<SUser> selectUser = service.selectUser();
			mav.addObject("user", selectUser);
			mav.addObject("selectids", selectids);
			return mav;
		}
		//异步遍历二级菜单
		@ResponseBody
		@RequestMapping("blerji")
		public List<SGoodstype> blerji(int id){
			List<SGoodstype> list=service.selecterji(id);
			return list;
		}
		
		//添加三级菜单
		@RequestMapping("tjsjcd")
		public String tjsjcd(BGoodsWithBLOBs record,int erjiid,String sjname){
			service.insertsjlb(record,erjiid, sjname);
			return ("forward:data.action");
		}
		
		
		//修改商品列表
		@RequestMapping("xgsp")
		public ModelAndView xgsp(int bj){
			ModelAndView mav=new ModelAndView("goodstype/edit2");
			List<SGoodstype> selectids = service.selectids();
			SGood selectbl = service.selectbl(bj);
			List<SUser> selectUser = service.selectUser();
			mav.addObject("user", selectUser);
			mav.addObject("xg", selectbl);
			mav.addObject("selectids", selectids);
			mav.addObject("id", bj);
			return mav;
		}
		@ResponseBody
		@RequestMapping("blerji1")
		public List<SGoodstype> blerji1(int id){
			List<SGoodstype> list=service.selecterji(id);
			return list;
		}
		
		
		@RequestMapping("selecttj")
		public String selecttj(BGoodsWithBLOBs record,int id,int erjiid){
			record.setId(id);
			record.setTypeid(erjiid);
			service.ubdatebj(record);
			return ("forward:data.action");
		}
		
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("Onetwo")
	public ModelAndView selectOnetwo(Integer id,HttpServletRequest request,SGoodstype sGoodstype,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		ModelAndView mav = new ModelAndView("goodsFabu/goodsOneTwo");
		if(request.getParameter("id")!=null&&!request.getParameter("id").equals("")){
			id = Integer.parseInt(request.getParameter("id"));
		}
		mav.addObject("id", id);
		
		PageInfo<SGoodstype> goodstypes = goodstypeService.selectAllOneGoodsType(id,sGoodstype,pageNum,pageSize);
		LhPage page = new LhPage(goodstypes);
		mav.addObject("page", page);
		if(sGoodstype.getTypename()!=null){
			mav.addObject("typename", sGoodstype.getTypename());
		}
		return mav;
	}
	
	@RequestMapping("fabu")
	public ModelAndView goodsfabu(){
		return new ModelAndView("goodsFabu/goodsFabu1");
		}

	@RequestMapping("tianjia")
	public ModelAndView save(SGoodstype sGoodstype){
		ModelAndView mav = new ModelAndView("goodsFabu/goodsOnetwoedit");
		List<SGoodstype> sGoodstypes = goodstypeService.selectAllOne();
		mav.addObject("goodstype", sGoodstypes);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**查询无活动商品和团购商品
	 * @param sg
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("toGroupPurchase")
	public ModelAndView toGroupPurchase(GoodsDto sg,@RequestParam(required=true,defaultValue="1") Integer pageNumber,@RequestParam(required=true,defaultValue="3") Integer pageSize){
		ModelAndView mav=null;
		if(sg.getType()!=null&&sg.getType()==1){
		 mav = new ModelAndView("goodsFabu/lookgroupPurchase");
		}else{
		 mav = new ModelAndView("goodsFabu/groupPurchase1");
		}
		//查询订单
		PageInfo<GoodsDto> goodsType= goodsService.selectAllOrderType(sg,pageNumber,pageSize);
		LhPage lh = new LhPage(goodsType);
		mav.addObject("typePage", lh);
		mav.addObject("name", sg);
		return mav;
	}
	
	/**发布团购跳转页
	 * @param id
	 * @return
	 */
	@RequestMapping("publishingGroup")
	public ModelAndView publishingGroup(Integer id){
		ModelAndView mav = new ModelAndView("goodsFabu/publishingGroup");
		GoodsDto dto = goodsService.selectById(id);
		mav.addObject("dto", dto);
		return mav;
		
	}
	
	/**团购发布保存
	 * @param goods
	 * @param tjgoods
	 * @param bjid
	 * @return
	 */
	@RequestMapping("saveGroup")
	public String saveGroup(BGoodsWithBLOBs goods,BTjgoodsWithBLOBs tjgoods,Integer bjid){
		
		//更新价格
		boolean a = goodsService.updataByPrice(goods);
		//更新活动状态和截止时间
		tjgoods.setId(bjid);
		boolean b = goodsService.updataByTjgoods(tjgoods);
		
		return "redirect:toGroupPurchase.action?type=1";
	}

	/**删除活动信息
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteGroup")
	public String deleteGroup(BTjgoodsKey id){
		System.out.println("删除"+id);
		//删除数据
		int i = goodsService.deleteById(id);
		if(i==1){
			return "redirect:toGroupPurchase.action?type=1";
		}
		return null;
		
	}
	/**
	 * 批量下架
	 * @param ids
	 * @return
	 */
	@RequestMapping("StandsUpAndDown")
	public String StandsUpAndDown(Integer[] ids){
		System.out.println(ids.toString());
		boolean updateByIds = goodsService.updateByIds(ids);
		if(updateByIds){
		return ("redirect:toGroupPurchase.action?type=1");
		}
		return null;
	}
	
	/**上下架修改
	 * @param btgoods
	 * @return
	 */
	@ResponseBody
	@RequestMapping("StandUpAndDown")
	public boolean StandUpAndDown(BTjgoodsWithBLOBs btgoods){
		System.out.println(btgoods.getStatus()+"status"+btgoods.getId()+"id");
		boolean b = goodsService.updateByIdOnStatus(btgoods);
		return b;
	}
	
	
	
	
	@RequestMapping("savegoodstype")
	public String savegoodstype(SGoodstype sGoodstype){
		boolean flag = goodstypeService.insertGoodsType(sGoodstype);
		return "redirect:Onetwo.action";
	}
	@RequestMapping("editgoodstype")
	public ModelAndView editgoodstype(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("goodsFabu/goodsOnetwoeditedit");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer yijiid = 0;
		if(!request.getParameter("yijiid").equals("")){
			yijiid = Integer.parseInt(request.getParameter("yijiid"));
		}
		SGoodstype goodstype = goodstypeService.selectBygoodstypeId(id);
		mav.addObject("goodstype", goodstype);
		mav.addObject("yijiid", yijiid);
		return mav;
	}
	@RequestMapping("updategoodstype")
	public String updategoodstype(SGoodstype sGoodstype,Integer yijiid){
		boolean flag = goodstypeService.updategoodtype(sGoodstype);
		return "redirect:Onetwo.action?id="+yijiid;
	}
	@RequestMapping("delete")
	public String deletegoodstype(SGoodstype sGoodstype,Integer yiji){
		boolean flag = goodstypeService.updateByStatus(sGoodstype);
		if(yiji!=null){
			return "redirect:Onetwo.action?id="+yiji;
		}else{
			return "redirect:Onetwo.action";
		}
	}
	@RequestMapping("deletes")
	public String deletesgoodstype(Integer[] ids,Integer id){
		for (Integer integer : ids) {
			SGoodstype sGoodstype = new SGoodstype();
			sGoodstype.setId(integer);
			sGoodstype.setStatus(0);
			goodstypeService.updateByStatus(sGoodstype);
		}
		if(id!=null){
			return "redirect:Onetwo.action?id="+id;
		}else{
			return "redirect:Onetwo.action";
		}
	}

}
