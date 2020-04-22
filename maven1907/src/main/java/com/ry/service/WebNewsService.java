package com.ry.service;

import java.util.List;

import com.ry.dto.BTjgoodsDto;

public interface WebNewsService {

	/**
	 * 查询活动信息
	 * @return
	 */
	List<BTjgoodsDto> selectactivities();

	/**
	 * 根据id查询对应活动的信息
	 * @param activitiesId
	 * @return
	 */
	BTjgoodsDto selectactivityById(Integer activitiesId);

}
