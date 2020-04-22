package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.BmessageDto;
import com.ry.mapper.BMessageMapper;
import com.ry.mapper.SMessagetypeMapper;
import com.ry.pojo.BMessage;
import com.ry.pojo.BMessageExample;
import com.ry.pojo.BMessageExample.Criteria;
import com.ry.pojo.BMessageKey;
import com.ry.pojo.BMessageWithBLOBs;
import com.ry.pojo.SMessagetype;
import com.ry.service.BmessageService;
@Service
public class Bmessageimp implements BmessageService{
@Autowired
BMessageMapper mapper;
@Autowired 
SMessagetypeMapper mapper2;
	@Override
	public PageInfo<BmessageDto> selectall(BmessageDto bd, Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
			List<BmessageDto> selectnews = mapper.selectnews(bd);
			
		return new PageInfo<BmessageDto>(selectnews);
	}

	@Override
	public boolean insertlb(SMessagetype smtt) {	
	 boolean flg=false;
	int insertSelective = mapper2.insertSelective(smtt);
	if(insertSelective>0){
		flg=true;
	}
		return flg;
	}

	@Override
	public List<SMessagetype> selectxw() {
			List<SMessagetype> selectByExample = mapper2.selectidname();
		return selectByExample;
	}

	

	@Override
	public boolean insertandupdadtaxw(BMessageWithBLOBs bm, SMessagetype smt) {
		boolean flg=false;
		int insertSelective = mapper.insertSelective(bm);
		int update2 = mapper2.updateByPrimaryKeySelective(smt);
		if(insertSelective>0&&update2>0){
			flg=true;
		}
		return flg;
	}

	@Override
	public BmessageDto selectalls(int a) {
		BmessageDto selectsy = mapper.selectsy(a);
		return selectsy;
	}

	@Override
	public boolean updatabiji(BMessageWithBLOBs bm, SMessagetype smt) {
		boolean flg=false;
		int updateByPrimaryKeyWithBLOBs = mapper.updateByPrimaryKeyWithBLOBs(bm);
		int updateByPrimaryKeySelective = mapper2.updateByPrimaryKeySelective(smt);
		if(updateByPrimaryKeyWithBLOBs>0&&updateByPrimaryKeySelective>0){
			flg=true;
		}
		return flg;
	}

	@Override
	public boolean deleteid(int a) {
		boolean flg=false;
		BMessageKey key=new BMessageKey();
		key.setId(a);
		int deleteByPrimaryKey = mapper.deleteByPrimaryKey(key);
		if(deleteByPrimaryKey>0){
			flg=true;
		}
		return flg;
	}

	@Override
	public boolean deletes(int[] ids) {
		boolean deletes = mapper.deletes(ids);
		return deletes;
	}

	@Override
	public List<BMessageWithBLOBs> selectAllBmessge() {
		
		return mapper.selectAllMessage();
	}

}
