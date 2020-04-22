package com.ry.service;

import java.util.List;
import java.util.Map;

import com.ry.dto.LeftListDto;
import com.ry.dto.TreeNodeDto;
import com.ry.pojo.TreeNode;

public interface ResourceService {

	/**
	 * 查询所有的资源信息
	 * @return
	 */
	List selectAllResource();

	/**
	 * 查询所有主菜单以及子菜单
	 * @return
	 */
	List<TreeNodeDto> selectByTree();

	List<TreeNode> selectResource(Integer id);
	
	void saveOrDelete(Integer roleId,Integer resourceId);
	/**
	 * 根据roleid加载角色所拥有的全部权限，封装结果按照navs.json的样子
	 * @param roleid
	 * @return
	 */
	List<Map> selectResourceByRoleId(Integer roleid);
	
	List<LeftListDto> selectByLeftList(Integer roleId);
}
