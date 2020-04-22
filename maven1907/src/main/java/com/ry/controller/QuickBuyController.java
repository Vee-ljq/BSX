package com.ry.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.pojo.BGoods;
import com.ry.pojo.BTjgoods;
import com.ry.service.GoodstypeService;
import com.ry.service.IndexWebService;
import com.ry.utils.LhPage;

@Controller
@RequestMapping("/quickbuy")
public class QuickBuyController {
	
@Autowired
private GoodstypeService goodsService;


/*public ModelAndView addQuickProduct(@RequestParam(name="tx")MultipartFile[] tx,HttpServletRequest request) throws IllegalStateException, IOException{

for (MultipartFile multipartFile : tx) {
	String filename_old=multipartFile.getOriginalFilename();
	String path=request.getRealPath("/");
	path=path+"/upload/"+UUID.randomUUID().toString()+filename_old.substring(filename_old.lastIndexOf("."),filename_old.length());
	//执行文件上传
	multipartFile.transferTo(new File(path));
}	
return new ModelAndView("quickbuy/quickbuy");

}*/	
//查询闪购商品列表
@RequestMapping("data")
public ModelAndView toShow(BTjgoodsDto tjDto,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
ModelAndView mav=new ModelAndView("quickbuy/data");
    PageInfo<BTjgoodsDto> pageInfo= goodsService.selectAllQuickGoods(tjDto,pageNum,pageSize);
    LhPage page=new LhPage(pageInfo);
    mav.addObject("page", page);
    mav.addObject("tjDto",tjDto);
	return  mav;
}
//跳到添加闪购商品页面
@RequestMapping("edit")	
public  ModelAndView toEdit(BGoods goods,@RequestParam(defaultValue="1",required=true)Integer pageNum,@RequestParam(defaultValue="2",required=true)Integer pageSize){
	ModelAndView mav=new ModelAndView("quickbuy/data1");
   PageInfo<BGoods> goodslist=goodsService.selectAllGoods(goods,pageNum,pageSize);
 LhPage page=new LhPage(goodslist);
mav.addObject("page", page);
mav.addObject("goods", goods);
return mav;

}
//添加截止日期
@RequestMapping("addEnddate")
public ModelAndView addEnddate(Integer id){
	ModelAndView mav=new ModelAndView("quickbuy/endDate");
	mav.addObject("id", id);
	return mav;
}

//修改截止日期
@RequestMapping("editEnddate")
public ModelAndView editEnddate(Integer id,Integer goodid){
	
	//id为dto的id
	ModelAndView mav=new ModelAndView("quickbuy/endDate");
	BTjgoodsDto tjgooddto=new BTjgoodsDto();
	tjgooddto.setId(id);
	BGoods goods=new BGoods();
	goods.setId(goodid);
	tjgooddto.setGoods(goods);
	BTjgoodsDto goodsdto = goodsService.selectQuickGoods(tjgooddto);
	mav.addObject("goodsdto", goodsdto);
	mav.addObject("id", goodid);
	return mav;
}
//设置闪购商品的启用或禁用状态
@RequestMapping("editStatus")
 @ResponseBody
public boolean editStatus(BTjgoodsDto goods){
	boolean flag = false;
	int num = goodsService.updateStatus(goods);
	if(num==1){
		flag=true;
	}
	return flag;
}

@RequestMapping("save")
public String toSave(BTjgoodsDto tjgoodsdto,Integer goodsid,String price,String enddate){
	BGoods goods=new BGoods();
	goods.setPrice(price);
	goods.setId(goodsid);
	tjgoodsdto.setGoods(goods);
	tjgoodsdto.setEnddate(enddate);
	int num1=0;
	int num2=0;
	if(tjgoodsdto.getId()!=null){
		 num1=goodsService.updateTjgoods(tjgoodsdto);
		
	}else{
		 num2=goodsService.insertTjgoods(tjgoodsdto);	
	}
	
	if(num1==0 && num2==0){
		
		return "forward:edit.action";
	}else{
		return "forward:data.action";
	}
	
	
}
//显示到webupload页面，数据库resource表中的url为quickbuy/addquick.action
	@RequestMapping("/addquick")
    public ModelAndView addQuickProduct(){
	return new ModelAndView("webupload");
}	
//显示点击添加闪购商品时出来的good列表
	/*@RequestMapping("/goodsdata")
	public ModelAndView toShowGoods(BGoods goods){
		goodsService.selectAllGoods(pageNum, pageSize)
		ModelAndView mav=new ModelAndView("quickbuy/data1");
		
		return mav;	
	}*/
	
//webloader单文件上传	
	@RequestMapping("/file")
	@ResponseBody
  public Map toShow(MultipartFile file,HttpServletRequest request) throws IOException{
	    String originalFilename = file.getOriginalFilename();
		String path=request.getRealPath("/");
		String uuId=UUID.randomUUID().toString();
		String newFilename=uuId+originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
		path=path+"/upload/"+newFilename;
		//path存入数据库中
		/*service.updateCust(customer)*/
		file.transferTo(new File(path));
	    Map  map=new HashMap();
	    map.put("id", uuId);
	    map.put("name", newFilename);
		return map;
	}
}
