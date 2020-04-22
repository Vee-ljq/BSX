package com.ry.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.SRole;

public interface RoleService {
	/**
	 * 查询所有的角色
	 * @return
	 */
	List<SRole> selectAllId();

	/**
	 * 查询并分页所有的角色
	 */
	PageInfo selectByPage(SRole role,Integer pageNum,Integer pageSize);

	/**
	 * 更新角色
	 * @param role
	 */
	void updateRole(SRole role);



	/**
	 * 删除用户角色
	 * @param id
	 */
	void deleteRole(Integer id);
	/**
	 * 通过id查询对象
	 * @return
	 */
	SRole selectById(Integer id);
}
