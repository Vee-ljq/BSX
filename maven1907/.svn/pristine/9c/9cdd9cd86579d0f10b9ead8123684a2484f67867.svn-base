package com.ry.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.mapper.BMessageMapper;
import com.ry.pojo.BMessage;
import com.ry.pojo.BMessageExample;
import com.ry.pojo.BMessageKey;
import com.ry.pojo.BMessageExample.Criteria;
import com.ry.pojo.BMessageWithBLOBs;
import com.ry.service.RZWnewService;
@Service("rzwnewservice")
public class RZWnewServiceImp implements RZWnewService {

	@Autowired
	private BMessageMapper bMessageMapper;
	
	@Override
	public PageInfo<BMessageWithBLOBs> selectById(BMessageWithBLOBs bloBs,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BMessageWithBLOBs> selectByExample = bMessageMapper.selectRZW(bloBs);
		PageInfo<BMessageWithBLOBs> pageInfo = new PageInfo<BMessageWithBLOBs>(selectByExample);
		return pageInfo;
	}

	@Override
	public BMessageWithBLOBs selectByPrimarykey(BMessageKey key) {
		BMessageWithBLOBs selectByPrimaryKey = bMessageMapper.selectByPrimaryKey(key);
		return selectByPrimaryKey;
	}

	@Override
	public boolean updaterzw(BMessageWithBLOBs bloBs) {
		int updateByPrimaryKeySelective = bMessageMapper.updateByPrimaryKeySelective(bloBs);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public BMessageWithBLOBs selectRuanying(BMessageKey key) {
		BMessageWithBLOBs selectByPrimaryKey = bMessageMapper.selectByPrimaryKey(key);
		return selectByPrimaryKey;
	}

}
