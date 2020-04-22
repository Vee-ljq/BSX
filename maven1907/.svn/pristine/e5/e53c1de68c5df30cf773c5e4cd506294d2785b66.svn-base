package com.ry.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import com.ry.dto.BGoodsViewDto;

import com.ry.dto.AddressDto;
import com.ry.dto.BTjgoodsDto;
import com.ry.dto.GoodsDto;

import com.ry.pojo.BCustomer;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsKey;

import com.ry.dto.SGood;
import com.ry.dto.slidegoodsDto;

import com.ry.pojo.BGoodsWithBLOBs;

import com.ry.pojo.BGoodspic;

import com.ry.pojo.BOrderdetail;

import com.ry.pojo.BTjgoodsKey;
import com.ry.pojo.BTjgoodsWithBLOBs;

public interface GoodsService {
	
	/**查询所有商品
	 * @return
	 */
	PageInfo<GoodsDto> selectAllOrderType(GoodsDto sg, Integer pageNumber,
			Integer pageSize);

	/**根据id查询商品信息
	 * @param sg
	 * @return
	 */
	GoodsDto selectById(Integer id);


	/**更新价格
	 * @param sg
	 * @return
	 */
	boolean updataByPrice(BGoodsWithBLOBs goods);


	/**更新状态
	 * @param sg
	 * @return
	 */
	boolean updataByTjgoods(BTjgoodsWithBLOBs tjgoods);

	/**删除活动表信息
	 * @param id
	 * @return
	 */
	int deleteById(BTjgoodsKey id);

	/**上下架
	 * @param btgoods
	 * @return
	 */
	boolean updateByIdOnStatus(BTjgoodsWithBLOBs btgoods);

	/**批量下架
	 * @param ids
	 */
	boolean updateByIds(Integer[] ids);
	/**
	 * 通过商品的id来查询商品的整条信息
	 * @param key
	 * @return
	 */
	BGoodsWithBLOBs selectByGoodsId(BGoodsKey key);
	/**
	 * 查询所有的商品编号和名称
	 * @return
	 */
	List<BGoods> selectAllGoodsId();
	/**
	 * 多图片上传的时候保存成功
	 * @param bGoodspic
	 * @return
	 */
	boolean saveDuoPic(BGoodspic bGoodspic);
	/**
	 * 通过商品的id来查询该商品的所有图片
	 * @param id
	 * @return
	 */
	List<BGoodspic> selectAllPicByGoodsId(Integer id);

	/**首页轮播图
	 * @return
	 */
	List<slidegoodsDto> selectSlidegoods();

	/**返回团购闪购等活动商品信息
	 * @param status
	 * @return
	 */
	List<BTjgoodsDto> selectActGoods(Integer type);

	/**查询所有无活动商品
	 * @return
	 */
	 List<SGood> selectAllGoods();
	 
	 /**
	  * 从详情页点立即提交
	  * 
	  * */
	//查询商品信息
	 GoodsDto selectGoodsById(Integer goodsid);
	//查询用户信息
	BCustomer selectCust(Integer custid);
	
	//通过custid来查询的地址信息
	List<AddressDto> selectAddrByCusid(Integer custid);
	/**
	 * 通过在搜索框中输入选择条件之后，筛选商品
	 * @param tiaojian
	 * @return
	 */
	PageInfo<BGoodsWithBLOBs> selectByTiaojian(String tiaojian,Integer pageNum,Integer pageSize);


	/**根据名字模糊查询
	 * @param goodsname
	 * @return
	 */
	 PageInfo<GoodsDto> selectByGoodsName(String goodsname, Integer pageNumber,
			 Integer pageSize);


}
