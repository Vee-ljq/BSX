package com.ry.service;

import java.util.List;
import com.ry.dto.BGoodsViewDto;
import com.ry.pojo.BGoodsview;

public interface FootsService {
	
	/**
	 * 点击商品时传递商品id和客户id
	 * 获取商品id，ip地址，客户id
	 * @param bGoods
	 * @return
	 */
	
	boolean getBGoodsId(BGoodsview bGoodsview);

	/**
	 * 查询浏览商品
	 * 
	 * @return
	 */
		List<BGoodsViewDto> selectGoodsView(BGoodsViewDto bg);
		/**
		 * 查看当前用户的足迹商品
		 * @return
		 */
	List<BGoodsViewDto> selectCuidGoodsView();

	List<BGoodsViewDto> selectByTime(BGoodsViewDto bg);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	boolean deleteById(Integer id);
	/**
	 * 增加足迹
	 */
	boolean insertfoot(BGoodsview bfoot);
}
