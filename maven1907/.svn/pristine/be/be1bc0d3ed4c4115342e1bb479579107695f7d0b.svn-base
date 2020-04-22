package com.ry.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.CommentDto;
import com.ry.mapper.BCommentMapper;
import com.ry.pojo.BComment;
import com.ry.pojo.BCommentExample;
import com.ry.pojo.BCommentExample.Criteria;
import com.ry.service.BCommentService;
@Service("bcommentService")
public class BCommentServiceImp implements BCommentService {

	@Autowired
	private BCommentMapper bCommentMapper;
	@Override
	public PageInfo<CommentDto> selectCommentByPage(BComment comment,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<CommentDto> page = bCommentMapper.selectCommentByPage(comment);
		 PageInfo<CommentDto> info = new PageInfo<CommentDto>(page);
		return info;
		
	}
	@Override
	public boolean deleteCommentById(Integer id) {
		boolean status = false;
		int num = bCommentMapper.deleteByPrimaryKey(id);
		if (num>0) {
			status = true;
		}
		return status;
	}
	@Override
	public boolean deleteCommentByIds(Integer[] ids) {
		boolean status = false;
		 int num=bCommentMapper.deleteCommentByIds(ids);
		if (num==ids.length) {
			status = true;
		}
		return status;
	}
	@Override
	public Integer selectByComment(Integer id) {
		BCommentExample example = new BCommentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andGoodsidEqualTo(id);
		Integer countByExample = bCommentMapper.countByExample(example );
		return countByExample;
	}
	@Override
	public Integer selectAllComment(Integer id) {
		BCommentExample example = new BCommentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andGoodsidEqualTo(id);
		Integer countByExample = bCommentMapper.countByExample(example );
		return countByExample;
	}
	@Override
	public Integer selectBestComment(Map map) {
		int selectBMBcount = bCommentMapper.selectBMBcount(map);
		return selectBMBcount;
	}
	@Override
	public Integer selectMidComment(Map map) {
		int selectBMBcount = bCommentMapper.selectBMBcount(map);
		return selectBMBcount;
	}
	@Override
	public Integer selectBadComment(Map map) {
		int selectBMBcount = bCommentMapper.selectBMBcount(map);
		return selectBMBcount;
	}
	@Override
	public PageInfo<CommentDto> selectAllCommentContent(Integer id,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<CommentDto> commentDtos = bCommentMapper.selectCommentAndCusotmer(id);
		PageInfo<CommentDto> pageInfo = new PageInfo<CommentDto>(commentDtos);
		return pageInfo;
	}
	@Override
	public boolean insertcomment(BComment bComment) {
		boolean status = false;
		int num =bCommentMapper.insertSelective(bComment);
		if (num>0) {
			status = true;
		}
		return status;
	}
}
