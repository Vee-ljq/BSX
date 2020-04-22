package com.ry.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.mapper.BOrdermainMapper;
import com.ry.service.IndexService;

@Service("indexService")
public class IndexServiceImp implements IndexService {
	
	@Autowired
	private BOrdermainMapper ordermainMapper;
	
	//待评价订单数
	@Override
	public Integer noEvaluationCount() {
		Integer num =ordermainMapper.noEvaluationCount();
		return num;
	}

	//今日订单数
	@Override
	public Integer nowAddOrders() {
		Integer num = ordermainMapper.nowAddOrders();
		return num;
	}
	
	//今日销售额
	@Override
	public String selecttodaymoney() {
		String total = ordermainMapper.selecttodaymoney();
		return total;
	}

}
