package com.ry.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.ry.dto.CommentDto;
import com.ry.mapper.BCommentMapper;
import com.ry.pojo.BComment;
import com.ry.service.BCommentService;
import com.ry.serviceImp.BCommentServiceImp;
import com.ry.utils.MD5Utils;
import com.ry.utils.NowDate;

public class test {
	
	@Autowired
	private BCommentMapper mapper;
	@Test
	public void test01(){
		String aString=MD5Utils.string2MD5("202cb962ac59075b964b07152d234b70");
		System.out.println(aString);
	}
	@Test
	public void test02(){
		NowDate now=new NowDate();
		System.out.println(now.nowDay());
		
	}
	
}
