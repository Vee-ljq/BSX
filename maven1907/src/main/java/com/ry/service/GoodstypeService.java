package com.ry.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.dto.GoodsDto;
import com.ry.dto.SGood;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BGoodstaste;
import com.ry.pojo.BGoodstaste2;
import com.ry.pojo.SGoodstype;
import com.ry.pojo.SUser;
import com.ry.pojo.ViewAddr;


public interface GoodstypeService {
	//查询 分页
	PageInfo<SGood> selectGoodselect(SGood bgoods,Integer pageNum,Integer pageSize);
	//删除
	boolean deleteGoods(int a);
	//批量删除
	boolean deleteids(int [] ids);


	/**
	 * 查询所有的一级商品类型
	 * @return
	 */
	PageInfo<SGoodstype> selectAllOneGoodsType(Integer id,SGoodstype sGoodstype,Integer pageNum,Integer pageSize);

	


	/**
	 * 查询所有的以及商品类别
	 * @return
	 */
	List<SGoodstype> selectAllOne();


	/**
	 * 看添加的一级或二级目录
	 * @param sGoodstype
	 * @return
	 */
	boolean insertGoodsType(SGoodstype sGoodstype);

	/**
	 * 通过商品类别的id来查询整条信息
	 * @param id
	 * @return
	 */

	SGoodstype selectBygoodstypeId(Integer id);

	 boolean updateByStatus(SGoodstype sGoodstype);
	/**
	 * 编辑商品类型
	 * @param sGoodstype
	 * @return
	 */
	 
	//显示所有闪购商品
		PageInfo<BTjgoodsDto> selectAllQuickGoods(BTjgoodsDto tjDto,Integer pageNum,Integer pageSize);

	    //添加闪购商品时显示所有的商品列表
		PageInfo<BGoods> selectAllGoods(BGoods goods,Integer pageNum,Integer pageSize);
        //点击
		int updateStatus(BTjgoodsDto goods);

	boolean updategoodtype(SGoodstype sGoodstype);

    
	int insertTjgoods(BTjgoodsDto tjgoodsdto);


	BTjgoodsDto selectQuickGoods(BTjgoodsDto tjgooddto);


	int updateTjgoods(BTjgoodsDto tjgoodsdto);


	/**
	 * 删除时编辑类型的状态为0，为下架
	 * @param sGoodstype
	 * @return
	 */
	


	
	//添加一级商品列表
	boolean insertGoods(SGoodstype goodstype);
	//查询一级商品
	List<SGoodstype> selectids();
	//添加二级商品列表
	boolean inserterji(SGoodstype goodstype);
	//遍历二级商品列表
	List<SGoodstype> selecterji(int id); 
	//添加三级商品列表
	boolean insertsjlb(BGoodsWithBLOBs record,int id,String name);
	
	SGood selectbl(int a);
	
	//编辑保存
	boolean ubdatebj(BGoodsWithBLOBs record);
	
	//遍历用户
	List<SUser> selectUser();

	//通过商品id来查BTjgoodsDto
	BTjgoodsDto selectQuickGoodsByGoodsid(BTjgoodsDto bjdto);
	//显示所有省份列表
	List<ViewAddr>  selectAllProvence();
	//通过省份id查询出所属的所有城市
	List<ViewAddr> selectAllCityByProid(Integer provenceid);
	//通过城市id查询出所有的县
	List<ViewAddr> selectAllXianByCityid(Integer cityid);
	//月销量
	int countMonthOrder(Integer goodsid);
	//累计销量
	int countAllOrderNum(Integer goodsid);
	//累计评价数量
	int countAllCommentNum(Integer goodsid);

	/**查询商品分类的二级菜单和商品
	 * @param id
	 * @return
	 */
	List<SGood> selectTwoClass(Integer id);
	/**查询二级菜单及商品
	 * @param typeid
	 * @return
	 */
	PageInfo<SGood> selectBytypeid(Map map, Integer pageNumber,
			Integer pageSize);
	/**查询头部信息
	 * @param attribute
	 * @return
	 */
	List<SGood> selcetTop(Integer attribute);
	//显示该商品所有的口味
	List<BGoodstaste> selectTasteByGoodsid(Integer goodsid);
	//显示所有商品包装
	List<BGoodstaste2> selectPackageByGoodsid(Integer goodsid);
	
	
	

}