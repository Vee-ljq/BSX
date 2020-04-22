package com.ry.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ry.dto.CommentDto;
import com.ry.pojo.BComment;

public interface BCommentService {

	PageInfo<CommentDto> selectCommentByPage(BComment comment,Integer pageNum,Integer pageSize);
	boolean deleteCommentById(Integer id);
	boolean deleteCommentByIds(Integer[] ids);
	//通过商品的id来查询当前商品累计评价
	Integer selectByComment(Integer id);
	/**
	 * 选择所有的评价的数量
	 * @return
	 */
	Integer selectAllComment(Integer id);
	/**
	 * 查询所有的好评的数量
	 * @return
	 */
	Integer selectBestComment(Map map);
	/**
	 * 查看所有的中评的数量
	 * @return
	 */
	Integer selectMidComment(Map map);
	/**
	 * 查看所有的差评的数量
	 * @return
	 */
	Integer selectBadComment(Map map);
	/**
	 * 查询所有的评价以及用户的头像
	 * @return
	 */
	PageInfo<CommentDto> selectAllCommentContent(Integer id,Integer pageNum,Integer pageSize);
       boolean  insertcomment(BComment bComment);

}
