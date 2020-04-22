package com.ry.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ry.dto.OrgDto;
import com.ry.pojo.SOrganization;
import com.ry.pojo.SUser;

public interface OrgService {
	/**
	 * 分页查询组织架构
	 * @param org
	 * @param pageNum
	 * @param pageSize
	 * @return 查询无结果返回null
	 */
	PageInfo<OrgDto>  selectByPage(SOrganization org,Integer pageNum,Integer pageSize);
/**
 * 新增或编辑的保存
 * @param org
 * @return true 代表保存成功 false 失败
 */
	boolean savaOrUpdateOrg(SOrganization org);
	
	/**
	 * 通过id查询对象
	 * @param id
	 * @return 无查询结果返回null 
	 */
	SOrganization selectById(Integer id);
	/**
	 * 通过id删除对象
	 * @param id
	 * @return true 删除成功 false 失败
	 */
	boolean deleteById(Integer id);
	/**
	 * 批量删除
	 * @param ids
	 * @return true 删除成功 false 失败
	 */
	boolean deleteByIds(Integer[] ids);
	/**
	 * 用于返回pid=0的组织机构信息
	 * @return List
	 */
	List<SOrganization> selectParantOrgs();
	/**
	 * 查询所有的组织机构
	 * @return
	 */
	List<SOrganization> selectAllPid();
	
}
