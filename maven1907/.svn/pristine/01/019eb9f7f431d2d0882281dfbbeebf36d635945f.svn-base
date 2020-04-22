package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.UserDto;
import com.ry.mapper.SUserMapper;
import com.ry.pojo.SUser;
import com.ry.pojo.SUserExample;
import com.ry.pojo.SUserExample.Criteria;
import com.ry.service.UserService;
import com.ry.utils.LhPage;
import com.ry.utils.MD5Utils;
@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private SUserMapper mapper;
	public PageInfo<UserDto> selectByPage(Integer pageNum, Integer pageSize,
			SUser user) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserDto> selectByPage = mapper.selectByPage(user);
		
		return new PageInfo<UserDto>(selectByPage);
	}
	public SUser selectUserById(Integer id) {
		SUser user = mapper.selectByPrimaryKey(id);
		return user;
	}
	public void saveOrUpdate(SUser user) {
		if(user!=null&&user.getId()!=null){
			mapper.updateByPrimaryKeySelective(user);
		}else{
			mapper.insert(user);
		}
		
	}
	public void deleteById(Integer id) {
		mapper.deleteByPrimaryKey(id);
		
	}
	public void deleteByIds(Integer[] ids) {
		for (Integer integer : ids) {
			mapper.deleteByPrimaryKey(integer);
		}
		
	}
	public List<SUser> selectByRealName() {
		List<SUser> selectByExample = mapper.selectByExample(null);
		return selectByExample;
	}
	public boolean checkLogin(SUser user) {
		boolean status = false;
		SUserExample example = new SUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andLoginaccountEqualTo(user.getLoginaccount());
		createCriteria.andPwdEqualTo(MD5Utils.string2MD5(user.getPwd()));
		List<SUser> selectByExample = mapper.selectByExample(example );
		if(selectByExample.size()==1){
			status=true;
		}
		return status;
	}
	public SUser selectByUsernameAndPwd(SUser user) {
		SUserExample example = new SUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andLoginaccountEqualTo(user.getLoginaccount());
		createCriteria.andPwdEqualTo(MD5Utils.string2MD5(user.getPwd()));
		List<SUser> users = mapper.selectByExample(example );
		return users.get(0);
	}

}
