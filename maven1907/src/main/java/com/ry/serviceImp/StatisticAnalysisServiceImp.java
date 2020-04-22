package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.BGoodsViewDto;
import com.ry.dto.OrdersDto;
import com.ry.mapper.BGoodsviewMapper;
import com.ry.mapper.BOrdermainMapper;
import com.ry.service.StatisticAnalysisService;

@Service("statisticAnalysisService")
public class StatisticAnalysisServiceImp implements StatisticAnalysisService {

	@Autowired
	private BOrdermainMapper ordermainMapper;
	
	@Autowired 
	private BGoodsviewMapper goodsviewMapper;
	
	//人均消费统计分析
	@Override
	public List<OrdersDto> perCapitaConsumption() {
		List<OrdersDto> rjConsumption = ordermainMapper.rjConsumption();
		return rjConsumption;
	}

	//商品流量统计分析
	@Override
	public List<BGoodsViewDto> goodsFlow() {
		List<BGoodsViewDto> goodsFlow = goodsviewMapper.goodsFlow();
		return goodsFlow;
	}

	@Override
	public List<OrdersDto> salesmoney() {
		List<OrdersDto> typemoney = ordermainMapper.salesmoney();
		return typemoney;
	}

}
