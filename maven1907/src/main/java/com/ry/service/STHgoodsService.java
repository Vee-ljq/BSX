package com.ry.service;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.pojo.BGoods;
import com.ry.pojo.BTjgoodsWithBLOBs;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.SGoodstype;
import com.ry.pojo.SUser;

public interface STHgoodsService {
	/**
	 * 商品发布的时候需要商品的类型
	 * @return
	 */
	List<SGoodstype> selectGoodsType();

	/**
	 * 二级联动，获取以及菜单的id，查询下面所有的二级
	 * @param yijiid
	 * @return
	 */
	List<SGoodstype> selectByYiid(Integer yijiid);
	
	/**
	 * 查询所有的发布人
	 * @return
	 */
		List<SUser> selectAllUser();
	/**
	 * 保存商品发布
	 * @param bGoods
	 * @return
	 */
	boolean insertGoods(BGoodsWithBLOBs bGoods);


	/**
	 * 查询参加活动的商品信息
	 * @param bTjgoodsDto
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<BTjgoodsDto> selectactivitiesByPage(BTjgoodsDto bTjgoodsDto,
			Integer pageNum, Integer pageSize);


	/**
	 * 显示对应活动的相关信息，用来修改 
	 * @param id
	 */
	BTjgoodsDto selectActivitiesInfoById(Integer id);

	/**
	 * 修改活动
	 * @param bTjgoodsDto
	 */
	void AddOrupdateActivities(BTjgoodsWithBLOBs bTjgoodsWithBLOBs);

}
