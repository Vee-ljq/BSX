package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.mapper.SRoleMapper;
import com.ry.pojo.SRole;
import com.ry.service.RoleService;
/**
 * 角色相关业务
 * @author 孙大壮
 *
 */
@Service("roleService")
public class RoleServiceImp implements RoleService {

	@Autowired
	private SRoleMapper mapper;

	public List<SRole> selectAllId() {
		List<SRole> selectByExample = mapper.selectByExample(null);
		return selectByExample;
	}

	public PageInfo<SRole> selectByPage(SRole role,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SRole> selectAllId = mapper.selectByPage(role);
		PageInfo<SRole> pageInfo = new PageInfo<SRole>(selectAllId);
		return pageInfo;
	}

	public void updateRole(SRole role) {
		if(role!=null&&role.getId()!=null){
			mapper.updateByPrimaryKeySelective(role);
		}else{
			mapper.insert(role);
		}
	}
	
	public void deleteRole(Integer id) {
		mapper.deleteByPrimaryKey(id);
		
	}

	public SRole selectById(Integer id) {
		SRole selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	
}
