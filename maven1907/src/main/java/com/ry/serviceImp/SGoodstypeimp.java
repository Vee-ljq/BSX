package com.ry.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.dto.GoodsDto;
import com.ry.dto.OrdersDto;
import com.ry.dto.SGood;
import com.ry.mapper.BGoodsMapper;
import com.ry.mapper.BGoodstaste2Mapper;
import com.ry.mapper.BGoodstasteMapper;
import com.ry.mapper.BTjgoodsMapper;
import com.ry.mapper.SGoodstypeMapper;
import com.ry.mapper.SUserMapper;
import com.ry.pojo.BGoods;

import com.ry.pojo.BGoodsKey;
import com.ry.pojo.BGoodsWithBLOBs;

import com.ry.pojo.BGoodsExample;
import com.ry.pojo.BGoodstaste;
import com.ry.pojo.BGoodstaste2;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.SGoodstype;
import com.ry.pojo.SGoodstypeExample;
import com.ry.pojo.SGoodstypeExample.Criteria;
import com.ry.pojo.SUser;
import com.ry.pojo.ViewAddr;
import com.ry.service.GoodstypeService;
import com.ry.utils.NowDate;



@Service

public class SGoodstypeimp implements GoodstypeService{
@Autowired
SGoodstypeMapper mapper;

@Autowired
BGoodsMapper mapper2;
@Autowired
SUserMapper mapper3;

@Autowired
BGoodsMapper goodsmapper;
@Autowired
BTjgoodsMapper tjmapper;
@Autowired
BGoodstasteMapper tastemapper;
@Autowired
BGoodstaste2Mapper packagemapper;
		//查询分页
	@Override
	public PageInfo<SGood> selectGoodselect(SGood goods, Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SGood> selectlb = mapper.selectlb(goods);
		return new PageInfo<SGood>(selectlb);
	}





	@Override
	public boolean deleteGoods(int a) {
		boolean flg=false;
		BGoodsKey key = new BGoodsKey();
		key.setId(a);
		int deleteByPrimaryKey = mapper2.deleteByPrimaryKey(key );
		
		if(deleteByPrimaryKey>0){
			flg=true;
		}
		return flg;
	}




	@Override
	public boolean deleteids(int[] ids) {
		boolean flg=false;
		int deleteByIds = mapper2.deleteByIds(ids);
		if(deleteByIds>0){
			flg=true;
		}
		return flg;
	}




	//添加一级商品列表
	@Override
	public boolean insertGoods(SGoodstype name) {
		boolean flg=false;
		int insert = mapper.insertSelective(name);
		if (insert>0) {
			flg=true;
		}
		return flg;
	}



//遍历一级菜单
	@Override
	public List<SGoodstype> selectids() {
		List<SGoodstype> selectyj = mapper.selectyj();
		return selectyj;
	}



//添加二级菜单
	@Override
	public boolean inserterji(SGoodstype goodstype) {
			boolean flg=false;
			int insertSelective = mapper.insertSelective(goodstype);
			if(insertSelective>0){
				flg=true;
			}
		return flg;
	}



//遍历二级列表
	@Override
	public List<SGoodstype> selecterji(int id) {
		SGoodstypeExample example=new SGoodstypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(id);
		List<SGoodstype> ll = mapper.selectByExample(example);
		return ll;
	}



//添加三级菜单
	@Override
	public boolean insertsjlb(BGoodsWithBLOBs record,int id, String name) {
		boolean flg=false;
		record.setTypeid(id);
		record.setGoodsname(name);
		int insertSelective = mapper2.insertSelective(record);
		if(insertSelective>0){
			
			flg=true;
		}
		
		return flg;

	}





//显示所有闪购商品
	@Override
	public PageInfo<BTjgoodsDto> selectAllQuickGoods(BTjgoodsDto tjDto,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<BTjgoodsDto> list=mapper.selectAllQuickGoods(tjDto);
		
		return new PageInfo<BTjgoodsDto>(list);
	}



	//查询储数据
	@Override
	public SGood selectbl(int a) {
		SGood selectbl = mapper.selectbl(a);
		return selectbl;
	}




	@Override
	public boolean ubdatebj(BGoodsWithBLOBs record) {
		boolean flg=false;
		
		int ff= mapper2.updateByPrimaryKeySelective(record);
		if(ff>0){
			return true;
		}
		return flg;
	}




	@Override
	public List<SUser> selectUser() {
		List<SUser> selectByExample = mapper3.selectByExample(null);
		return selectByExample;
	}




	
	
		



	@Override
	public List<SGoodstype> selectAllOne() {
		SGoodstypeExample example = new SGoodstypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(0);
		createCriteria.andStatusEqualTo(1);
		List<SGoodstype> selectByExample = mapper.selectByExample(example );
		return selectByExample;
	}




	@Override
	public boolean insertGoodsType(SGoodstype sGoodstype) {
		int insertSelective = mapper.insertSelective(sGoodstype);
		if(insertSelective==1){
			return true;
		}else{
			return false;
		}
		
	}




	@Override
	public SGoodstype selectBygoodstypeId(Integer id) {
		SGoodstype selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}




	@Override
	public boolean updategoodtype(SGoodstype sGoodstype) {
		int updateByPrimaryKeySelective = mapper.updateByPrimaryKeySelective(sGoodstype);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
		
	}



	 //添加闪购商品时显示所有的商品列表
	@Override
	public PageInfo<BGoods> selectAllGoods(BGoods goods,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BGoods> list=null;
	  if(goods==null){
		 list = goodsmapper.selectByExample(null);
		  
		  
	  }else{
	BGoodsExample example=new BGoodsExample();
	com.ry.pojo.BGoodsExample.Criteria cre = example.createCriteria();
   if(goods.getGoodsname()!=null && !"".equals(goods.getGoodsname())){
	cre.andGoodsnameLike("%"+goods.getGoodsname()+"%");
	
	
    }
   if(goods.getGoodsno()!=null && !"".equals(goods.getGoodsno())){
	   
	   cre.andGoodsnoEqualTo(goods.getGoodsno());
   }
	 list = goodsmapper.selectByExample(example);
		
	  }
	
	PageInfo<BGoods> pageInfo=new PageInfo<BGoods>(list);
   return pageInfo;

 
	
	}
	





	@Override

	public int updateStatus(BTjgoodsDto goods) {
		int i=tjmapper.updateTjGoods(goods);
		return i;
	}
	

	public PageInfo<SGoodstype> selectAllOneGoodsType(Integer id,
			SGoodstype sGoodstype, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		SGoodstypeExample example = new SGoodstypeExample();
		Criteria createCriteria = example.createCriteria();
		if(sGoodstype.getTypename()!=null){
			createCriteria.andTypenameLike("%"+sGoodstype.getTypename()+"%");
		}
		if(id!=null){
			createCriteria.andPidEqualTo(id);
		}else{
			createCriteria.andPidEqualTo(0);
		}
		createCriteria.andStatusEqualTo(1);
		example.setOrderByClause("id desc");
		List<SGoodstype> selectByExample = mapper.selectByExample(example );
		PageInfo<SGoodstype> pageInfo = new PageInfo(selectByExample);
		return pageInfo;

	}



@Override
	public boolean updateByStatus(SGoodstype sGoodstype) {
		int updateByPrimaryKeySelective = mapper.updateByPrimaryKeySelective(sGoodstype);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
}

	@Override
	public int insertTjgoods(BTjgoodsDto tjgoodsdto) {
		int num=tjmapper.insertQuickPro(tjgoodsdto);	
		BGoodsWithBLOBs good=new BGoodsWithBLOBs();
		good.setId(tjgoodsdto.getGoodsid());
		good.setPrice(tjgoodsdto.getGoods().getPrice());
		goodsmapper.updateByPrimaryKeySelective(good);
		return num;
	}
	@Override
	public BTjgoodsDto selectQuickGoods(BTjgoodsDto tjgooddto) {
		
		List<BTjgoodsDto> tjgoods = mapper.selectTjgoodsdto(tjgooddto);
		BTjgoodsDto tjgood=tjgoods.get(0);
		return tjgood;
	}




	@Override
	public int updateTjgoods(BTjgoodsDto tjgoodsdto) {
		int statue=0;
		int num=tjmapper.updateTjGoodsEnddate(tjgoodsdto);
		/*BGoods goods=new BGoods();
		tjgoodsdto.getGoods().getPrice();*/
		int num1=tjmapper.updateTjGoodsPri(tjgoodsdto);
		if(num==1 && num1==1){
			statue=1;
			
		}
		return statue;
	}

@Override
public List<SGood> selectTwoClass(Integer id) {
	System.out.println(id);
	List<SGood> dto= 	mapper.selectTwoClass(id);
	return dto;
}





@Override
public PageInfo<SGood> selectBytypeid(Map map, Integer pageNumber,
		Integer pageSize) {
	PageHelper.startPage(pageNumber, pageSize);
	List<SGood> se = mapper.selectBytypeid(map);
	
	return new PageInfo<SGood>(se);
}
	@Override
	public BTjgoodsDto selectQuickGoodsByGoodsid(BTjgoodsDto bjdto) {
		bjdto=tjmapper.selectQuickGoodsByGoodsid(bjdto);
		return bjdto;




	}



@Override
public List<SGood> selcetTop(Integer attribute) {
	Map map = new HashMap();
	if(attribute==null){
		return mapper.selectBytypeid(map);
	}else{
		
		map.put("typeid", attribute);
		map.put("flag","0");
		return mapper.selectBytypeid(map);
	}
}



	//显示所有省份列表
	@Override
	public List<ViewAddr> selectAllProvence() {
		List<ViewAddr> prolist=goodsmapper.selectAllProvence();
		return prolist;
	}
















	//通过省份id查询出所属的所有城市
	@Override
	public List<ViewAddr> selectAllCityByProid(Integer provenceid) {
		List<ViewAddr> citylist=goodsmapper.selectAllCityBuProid(provenceid);
		return citylist;
	}




	//通过城市id查询出所有的县
	@Override
	public List<ViewAddr> selectAllXianByCityid(Integer cityid) {
		List<ViewAddr> xianlist=goodsmapper.selectAllXianByCityid(cityid);
		return xianlist;
	}




	//月销量
	@Override
	public int countMonthOrder(Integer goodsid) {
	
		OrdersDto orderdto=new OrdersDto();
		orderdto.setCreatedate(NowDate.thisMonth());
		BOrderdetail orderdetail1=new BOrderdetail();
		orderdetail1.setGoodsid(goodsid);
		orderdto.setOrderdetail1(orderdetail1);
		
		int monthnum=goodsmapper.countMonthOrder(orderdto);
		return monthnum;
	}




	//累计销量
	@Override
	public int countAllOrderNum(Integer goodsid) {
		int allordernum=goodsmapper.countAllOrderNum(goodsid);
		return allordernum;
	}




	//累计评价数量
	@Override
	public int countAllCommentNum(Integer goodsid) {
		int countcomment=goodsmapper.countAllCommentNum(goodsid);
		return countcomment;
	}




	//显示该商品所有的口味
	@Override
	public  List<BGoodstaste> selectTasteByGoodsid(Integer goodsid) {
		List<BGoodstaste> tastes=tastemapper.selectTasteByGoodsid(goodsid);
		return tastes;
	}
	//显示所有商品包装
	@Override
	public List<BGoodstaste2> selectPackageByGoodsid(Integer goodsid) {
		List<BGoodstaste2> packages=packagemapper.selectPackageByGoodsid(goodsid);
		return packages;
	}





	}







	





	


 

	




