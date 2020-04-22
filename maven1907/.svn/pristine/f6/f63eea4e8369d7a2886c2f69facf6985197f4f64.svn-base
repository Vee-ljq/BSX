package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.CommentDto2;
import com.ry.mapper.BCommentMapper;
import com.ry.pojo.BComment;
import com.ry.service.BCommentService2;


@Service
public class BCommentServiceimp2 implements BCommentService2{
@Autowired
private  BCommentMapper mapper;
	@Override
	public List<CommentDto2> selectall() {
			List<CommentDto2> selectAll = mapper.selectAll();
		return selectAll;
	}

}
