package com.ry.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.BCustomer;

public interface IndexWebService {

	//判断密码是否正确
	BCustomer pwd(BCustomer customer);
	
	//查询用户所有信息
//	BCustomer selectCustomer(BCustomer customer);
	//更改用户信息
	boolean updateCust(BCustomer customer);
	//查询所有用户的信息
	List<BCustomer> selectCustomerAll();
	//分页加模糊查询
	PageInfo<BCustomer> selectByPage(BCustomer org,Integer pageNum, Integer pageSize);

	BCustomer selectById(Integer id);

	boolean saveOrUpdate(BCustomer org);

	boolean  updatePasswordById(BCustomer bCustomer);

	boolean updatePhoneById(BCustomer bCustomer);

	int selectcount();

	int selectcounts();
	
}

