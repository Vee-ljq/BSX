package com.ry.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.UserStatisticsDto;
import com.ry.mapper.BCustomerMapper;
import com.ry.pojo.BCustomer;
import com.ry.service.RegisterService;
@Service
public class RegisterServiceimp implements RegisterService{
@Autowired
private BCustomerMapper mapper;
	@Override
	public boolean zc(BCustomer customer) {
		boolean flg=false;
			int insertSelective = mapper.insertSelective(customer);
			if(insertSelective>0){
				flg=true;
			}
		return flg;
	}
	@Override
	public List selectAllCount() {
		List<UserStatisticsDto> list = mapper.selectAllCount();
		List li = new ArrayList();
		for (UserStatisticsDto bCustomer : list) {
			List l = new ArrayList();
			l.add("\""+bCustomer.getRegdate()+"\"");
			l.add(bCustomer.getSum());
			li.add(l);
		}
		return li;
	}
	@Override
	public boolean selectyz(BCustomer customer) {
		boolean flg=false;
		int selectyz = mapper.selectyz(customer);
		if(selectyz>0){
			flg=true;
		}
		return flg;
	}
	
	@Override
	public boolean selectsj(BCustomer customer) {
		boolean flg=false;
		int selectsj = mapper.selectsj(customer);
		if(selectsj>0){
			flg=true;
		}
		return flg;
	}
	@Override
	public boolean insertall(BCustomer customer) {
		boolean flg=false;
		int insertSelective = mapper.insertSelective(customer);
		if(insertSelective>0){
			flg=true;
		}
		return flg;
	}
	
	

}
