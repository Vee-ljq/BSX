package com.ry.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.AddressDto;
import com.ry.mapper.BAddressMapper;
import com.ry.mapper.ViewAddrMapper;
import com.ry.pojo.BAddress;
import com.ry.pojo.BAddressExample;
import com.ry.pojo.BAddressExample.Criteria;
import com.ry.pojo.ViewAddr;
import com.ry.service.AddressService;
@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired 
	private ViewAddrMapper mapper;
	
	@Autowired
	private BAddressMapper BAddressMapper;

	@Override //省
	public List<ViewAddr> selectByprovice(){
		return mapper.selectByprovice();
	}

	@Override
	public List<ViewAddr> selectBycity(Integer id) {
		return mapper.selectBycity(id);
	}

	@Override
	public List<ViewAddr> selectByCode(Integer id) {
		return mapper.selectByCode(id);
	}

	@Override
	public boolean saveBAddress(BAddress addr) {
		if(BAddressMapper.updateByPrimaryKeySelective(addr)==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<AddressDto> selectAddressByCusid(Map map) {
		List<AddressDto> addressDtos = BAddressMapper.selectAddressByCusid(map);
		return addressDtos;
	}

	@Override
	public boolean updateAddressById(BAddress address) {
		int updateByPrimaryKeySelective = BAddressMapper.updateByPrimaryKeySelective(address);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean insertAddress(BAddress address) {
		int insertSelective = BAddressMapper.insertSelective(address);
		if(insertSelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean deleteById(Integer id) {
		int deleteByPrimaryKey = BAddressMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean updateByMoren(BAddress address) {
		int updateByPrimaryKeySelective = BAddressMapper.updateByPrimaryKeySelective(address);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
	
	}

	@Override
	public boolean updateOtherNotMoren(BAddress address) {
		BAddressMapper.updateOtherMoren(address);
		return true;
	}

}
