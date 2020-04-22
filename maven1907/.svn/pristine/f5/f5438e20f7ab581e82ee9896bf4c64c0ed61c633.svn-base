package com.ry.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.BillDto;
import com.ry.mapper.BOrdermainMapper;
import com.ry.pojo.BOrdermain;
import com.ry.service.BillService;
@Service("billService")
public class BillServiceImpl implements BillService {

	@Autowired
	private BOrdermainMapper mapper;
	
	@Override
	public List<BillDto> selectAllGoods(Integer cusid) {
		List<BillDto> list = mapper.selectAllGoods(cusid);
		return list;
	}

	@Override
	public BillDto selectSum(Integer id) {
		BillDto i = mapper.selectSum(id);
		return i;
	}

	@Override
	public boolean deleteBillList(BOrdermain bord) {
		int updateByPrimaryKeySelective = mapper.updateByPrimaryKeySelective(bord);
		if(updateByPrimaryKeySelective==1){
			return true;
		}
		return false;
	}

	@Override
	public List<BillDto> selectGoodsByDate(Map map) {
		List<BillDto> list =  mapper.selectGoodsByDate(map);
		return list;
	}

}
