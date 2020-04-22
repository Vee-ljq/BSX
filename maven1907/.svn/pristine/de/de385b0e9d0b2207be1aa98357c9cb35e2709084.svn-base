package com.ry.service;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.Kd;

public interface ExpressService {
	/**
	 * 分页查询组织架构
	 * @param org
	 * @param pageNum
	 * @param pageSize
	 * @return 查询无结果返回null
	 */
	PageInfo<Kd>  selectByPage(Kd org,Integer pageNum,Integer pageSize);
	/**
	 * 通过id查询是否有该用户
	 * 
	 * @param id
	 * @return
	 */
	Kd selectById(Integer id);
	boolean saveOrUpdate(Kd org);
	boolean deleteById(Kd org);
	boolean deleteByIds(Integer[] ids);
	

}
