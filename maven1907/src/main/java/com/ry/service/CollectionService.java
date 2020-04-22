package com.ry.service;

import java.util.List;

import com.ry.dto.CollectionDto;
import com.ry.pojo.BCollection;

public interface CollectionService {

	/**根据用户id查询收藏夹
	 * @param id
	 * @return
	 */
	List<CollectionDto> selectAllCollection(Integer id);
	/**
	 * 将单个商品移入收藏夹
	 * @param collection
	 * @return
	 */
	boolean insertShoucang(BCollection collection);

}
