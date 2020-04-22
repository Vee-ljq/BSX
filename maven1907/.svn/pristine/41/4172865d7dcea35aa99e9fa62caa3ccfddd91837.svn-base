package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.mapper.KdMapper;
import com.ry.pojo.Kd;
import com.ry.service.KdService;
@Service("kdService")
public class KdServiceImpl implements KdService {
	
	@Autowired
	private KdMapper mapper;

	@Override
	public List<Kd> selectByKd() {
		return mapper.selectByExample(null);
	}

	@Override
	public Kd selectByid(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
