package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.BTjgoodsDto;
import com.ry.mapper.BGoodsMapper;

import com.ry.mapper.BTjgoodsMapper;
import com.ry.pojo.BTjgoodsWithBLOBs;

import com.ry.mapper.SGoodstypeMapper;
import com.ry.mapper.SUserMapper;
import com.ry.pojo.BGoodsWithBLOBs;

import com.ry.pojo.SGoodstype;
import com.ry.pojo.SGoodstypeExample;
import com.ry.pojo.SGoodstypeExample.Criteria;

import com.ry.pojo.SUser;
import com.ry.pojo.SUserExample;

import com.ry.service.STHgoodsService;

@Service("sthgoodsservice")
public class STHgoodsServiceImp implements STHgoodsService {
	
	@Autowired
	private BTjgoodsMapper bTjgoodsMapper;
	@Autowired
	private SGoodstypeMapper sGoodstypeMapper;

	@Autowired 
	private SUserMapper userMapper;
	@Autowired
	private BGoodsMapper bGoodsMapper;


	//查询活动信息
	@Override
	public PageInfo<BTjgoodsDto> selectactivitiesByPage(
			BTjgoodsDto bTjgoodsDto, Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<BTjgoodsDto> activitiesList = bTjgoodsMapper.selectactivitiesByPage(bTjgoodsDto);
		PageInfo<BTjgoodsDto> pageInfo = new PageInfo<BTjgoodsDto>(activitiesList); 
		return pageInfo;
	}

	
	@Override
	public List<SGoodstype> selectGoodsType() {
		SGoodstypeExample example = new SGoodstypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(0);
		List<SGoodstype> liGoodstypes = sGoodstypeMapper.selectByExample(example );
		return liGoodstypes;
	}
	@Override
	public List<SGoodstype> selectByYiid(Integer yijiid) {
		SGoodstypeExample example = new SGoodstypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(yijiid);
		List<SGoodstype> selectByExample = sGoodstypeMapper.selectByExample(example );
		return selectByExample;
	}
	@Override
	public List<SUser> selectAllUser() {
		SUserExample example = new SUserExample();
		com.ry.pojo.SUserExample.Criteria createCriteria = example.createCriteria();
		List<SUser> selectByExample = userMapper.selectByExample(example);
		return selectByExample;
	}
	@Override
	public boolean insertGoods(BGoodsWithBLOBs bGoods) {
		int insertSelective = bGoodsMapper.insertSelective(bGoods);
		if(insertSelective==1){
			return true;
		}else{
			return false;
		}
		
	}


	//显示对应活动的相关信息，用来修改 
	@Override
	public BTjgoodsDto selectActivitiesInfoById(Integer id) {
		BTjgoodsDto goodsInfo = bTjgoodsMapper.selectActivitiesInfoById(id);
		return goodsInfo;
	}

	//修改活动内容
	//添加或修改活动
	@Override
	public void AddOrupdateActivities(BTjgoodsWithBLOBs bTjgoodsWithBLOBs) {
		if(bTjgoodsWithBLOBs!=null && bTjgoodsWithBLOBs.getId()!=null){
			bTjgoodsMapper.updateActivitiesById(bTjgoodsWithBLOBs);	
		}else {
			bTjgoodsMapper.insertSelective(bTjgoodsWithBLOBs);
		}
			
	}
}
