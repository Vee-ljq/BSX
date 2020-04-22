package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.BFloorgoodsDto;
import com.ry.dto.CommentDto;
import com.ry.mapper.BFloorgoodsMapper;
import com.ry.mapper.BGoodsMapper;
import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BFloorgoodsExample;
import com.ry.pojo.BFloorgoodsExample.Criteria;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsKey;
import com.ry.service.BFloorgoodsService;
@Service("bFloorgoodsService")
public class BFloorgoodsServiceImp implements BFloorgoodsService {

	@Autowired
	private BFloorgoodsMapper bfgoodsMapper;
	@Autowired
	private BGoodsMapper bGoodsMapper;
	@Override
	public PageInfo<BFloorgoodsDto> selectbfByPage(BGoods bgoods,
			Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BFloorgoodsDto> page = bfgoodsMapper.selectbfByPage(bgoods);
		 PageInfo<BFloorgoodsDto> info = new PageInfo<BFloorgoodsDto>(page);
		return info;
	}
	@Override
	public BFloorgoodsDto selectEditOrAdd(Integer id) {
		BFloorgoodsDto bfDto = bfgoodsMapper.selectEditOrAdd(id);
		return bfDto;
	}
	@Override
	public List<BFloorgoodsDto> selectgoodsno() {
		List<BFloorgoodsDto> selectgoodsno = bfgoodsMapper.selectgoodsno();
		return selectgoodsno;
	}
	@Override
	public boolean updateBykey(BFloorgoodsDto bfgoodsDto) {
		
		boolean status = false;
		int num = bfgoodsMapper.updateBykey(bfgoodsDto);
		if(num>0){
			status = true;
		}
		return status;
	}
	@Override
	public boolean updateBygoodsno(BFloorgoodsDto bfgoodsDto) {
		boolean status = false;
		int num = bfgoodsMapper.updateBygoodsno(bfgoodsDto);
		if(num>0){
			status = true;
		}
		return status;
	}
	 // 在bfloorgoods中添加今日推荐商品
	@Override
	public boolean insertShangjia(BFloorgoodsDto bfgoodsDto) {
		boolean status = false;
		int num = bfgoodsMapper.insertShangjia(bfgoodsDto);
		if (num>0) {
			status = true;
		}
		return status;
	}
	// 从bfloorgoods中删除今日推荐商品
	@Override
	public boolean deleteshangjia(BFloorgoodsDto dto) {
		boolean status = false;
		int num = bfgoodsMapper.deleteShangjia(dto);
		if (num>0) {
			status = true;
		}
		return status;
	}
	@Override
	public List<BFloorgoods> selectBFloorgoods() {
		List<BFloorgoods> lbf = bfgoodsMapper.selectBFloorgoods();
		return lbf;
	}
	

}
