package com.ry.serviceImp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.OrgDto;
import com.ry.mapper.SOrganizationMapper;
import com.ry.pojo.SOrganization;
import com.ry.pojo.SOrganizationExample;
import com.ry.pojo.SOrganizationExample.Criteria;
import com.ry.service.OrgService;

@Service("orgService")
public class OrgServiceImp implements OrgService {

	@Autowired
	private SOrganizationMapper mapper;
	
	public PageInfo<OrgDto> selectByPage(SOrganization org,
			Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrgDto> selectByPage = mapper.selectByPage(org);
		return new PageInfo<OrgDto>(selectByPage);
		
	}
	public boolean savaOrUpdateOrg(SOrganization org) {
		boolean state = false;
		int num = 0;
		if(org.getId()!=null){
			//更新
			num = mapper.updateByPrimaryKeySelective(org);
		}else{
			//插入
			num = mapper.insertSelective(org);
		}
		if (num==1) {
			state=true;
		}
		return state;
	}
	public SOrganization selectById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	public boolean deleteById(Integer id) {
		boolean state = false;
		int num = mapper.deleteByPrimaryKey(id);
		if(num==1){
			state=true;
		}
		return state;
	}
	public boolean deleteByIds(Integer[] ids) {
		boolean state = false;
		int num = mapper.deleteByIds(ids);
		//影响行数等于ids的长度才是删除成功
		if(num==ids.length){
			state=true;
		}
		return state;
	}
	public List<SOrganization> selectParantOrgs() {
		SOrganizationExample example = new SOrganizationExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(0);
		List<SOrganization> orgs = mapper.selectByExample(example );
		return orgs;
	}
	public List<SOrganization> selectAllPid() {
		List<SOrganization> selectByExample = mapper.selectByExample(null);
		return selectByExample;
	}
	

}
