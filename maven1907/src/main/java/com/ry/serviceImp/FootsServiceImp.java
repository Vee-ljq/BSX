package com.ry.serviceImp;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.BGoodsViewDto;
import com.ry.mapper.BGoodsviewMapper;
import com.ry.pojo.BGoodsview;
import com.ry.service.FootsService;
@Service("footsService")
public class FootsServiceImp implements FootsService{
	@Autowired
	private BGoodsviewMapper mapper;
	@Override
	public boolean getBGoodsId(BGoodsview bGoodsview) {
		boolean status=false;
		
		int insertSelective = mapper.insertSelective(bGoodsview);
		if(insertSelective>0){
			status=true;
		}
		
		return status;
	}
	@Override
	public List<BGoodsViewDto> selectGoodsView(BGoodsViewDto bg) {
		
		
		
		return mapper.selectGoodsViews(bg) ;
	}

	@Override
	public List<BGoodsViewDto> selectByTime(BGoodsViewDto bg) {
		
		return mapper.selectByTime(bg);
		
	}
	@Override
	public boolean deleteById(Integer id) {
		boolean status=false;
		int deleteByPrimaryKey = mapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey>0){
			status=true;
		}
		
		return status;
	}

	@Override
	public List<BGoodsViewDto> selectCuidGoodsView() {
		List<BGoodsViewDto> bGoodsViewDtos = mapper.selectCuidGoodsView();
		return bGoodsViewDtos;
	}
	@Override
	public boolean insertfoot(BGoodsview bfoot) {
		boolean status=false;
		int insertSelective = mapper.insert(bfoot);
		if(insertSelective>0){
			status=true;
		}
		return status;
	}


}
