package com.ry.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.ry.dto.UserDto;
import com.ry.pojo.SUser;


public interface UserService {

	/**
	 * 模糊查询分页对象
	 * @param pageNum
	 * @param pageSize
	 * @param user
	 * @return
	 */
	PageInfo<UserDto> selectByPage(Integer pageNum, Integer pageSize, SUser user);
	/**
	 * 根据id插叙用户信息
	 * @param id
	 * @return
	 */
	SUser selectUserById(Integer id);
	/**
	 * 
	 * @param user
	 */
	void saveOrUpdate(SUser user);
	/**
	 * 单件删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(Integer[] ids);
	/**
	 * 查询所有的负责人
	 */
	List<SUser> selectByRealName();
	/**
	 * 验证用户名和密码是否合法
	 * @param user
	 * @return true合法 false 用户名或密码错误
	 */
	boolean checkLogin(SUser user);
	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 * @return
	 */
	SUser selectByUsernameAndPwd(SUser user);
	
}
