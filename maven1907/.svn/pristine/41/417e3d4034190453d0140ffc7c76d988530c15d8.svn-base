package com.ry.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BFloorgoodsDto;
import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsKey;

public interface BFloorgoodsService {

	PageInfo<BFloorgoodsDto> selectbfByPage(BGoods bgoods,Integer pageNum,Integer pageSize);
	
	//根据goodsid查找商品信息
	 BFloorgoodsDto selectEditOrAdd(Integer id);

	
	
	 List<BFloorgoodsDto> selectgoodsno();

	 boolean  updateBykey(BFloorgoodsDto bfgoodsDto);
	 boolean updateBygoodsno(BFloorgoodsDto bfgoodsDto);
	 // 在bfloorgoods中添加今日推荐商品
	 boolean  insertShangjia(BFloorgoodsDto bfgoodsDto);
	// 从bfloorgoods中删除今日推荐商品
	boolean deleteshangjia(BFloorgoodsDto dto);

	/**查询今日推荐
	 * @return
	 */
	List<com.ry.pojo.BFloorgoods> selectBFloorgoods();
}
