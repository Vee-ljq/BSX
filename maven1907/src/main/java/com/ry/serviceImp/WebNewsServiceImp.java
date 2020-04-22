package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.BTjgoodsDto;
import com.ry.mapper.BTjgoodsMapper;
import com.ry.service.WebNewsService;

@Service("webNewsService")
public class WebNewsServiceImp implements WebNewsService {
	
	@Autowired
	private BTjgoodsMapper activitiesMapper;
	
	//查询活动信息
	@Override
	public List<BTjgoodsDto> selectactivities() {
		List<BTjgoodsDto> activities = activitiesMapper.selectactivities();
		return activities;
	}

	//根据id查询对应活动
	@Override
	public BTjgoodsDto selectactivityById(Integer activitiesId) {
		BTjgoodsDto activities = activitiesMapper.selectactivityById(activitiesId);
		return activities;
	}

}
