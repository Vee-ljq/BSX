package com.ry.serviceImp;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.mapper.KdMapper;
import com.ry.pojo.Kd;
import com.ry.service.ExpressService;
@Service("expressService")
public class ExpressServiceImp implements ExpressService{
	
	@Autowired
	private KdMapper mapper;
	/**
	 * 分页查询
	 */
	@Override
	public PageInfo<Kd> selectByPage(Kd org, Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Kd> selectByPage = mapper.selectByPage(org);
		return new PageInfo<Kd>(selectByPage);
	
	}
	/**
	 * 通过id查询判断是否有该用户
	 */
	 
	@Override
	public Kd selectById(Integer id) {
		Kd k = mapper.selectByPrimaryKey(id);
		
		
		return k;
	}
	/**
	 * 通过id判断
	 * 如果有id修改
	 * 没有id插入
	 */
	@Override
	public boolean saveOrUpdate(Kd org) {
		boolean status=false;
		int num=0;
		if(org.getId()!=null){
			num=mapper.updateByPrimaryKeySelective(org);
		}else{
			num=mapper.insertSelective(org);
		}
		if(num!=0){
			status=true;
		}
		
		return status;
	}
	@Override
	public boolean deleteById(Kd org) {
		boolean status=false;
		int delete = mapper.deleteByPrimaryKey(org.getId());
		if(delete>1){
			status=true;
		}
		return status;
	}
	@Override
	public boolean deleteByIds(Integer[] ids) {
		boolean status=false;
		int deleteByIds = mapper.deleteByIds(ids);
		if(deleteByIds>0){
			status=true;
		}
		
		return status;
	}
	

}
