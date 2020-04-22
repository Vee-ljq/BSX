package com.ry.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.BMessage;
import com.ry.pojo.BMessageKey;
import com.ry.pojo.BMessageWithBLOBs;

public interface RZWnewService {

	/**
	 * 在数据库中查询出1.2.3数据
	 * @return
	 */
	PageInfo<BMessageWithBLOBs> selectById(BMessageWithBLOBs bloBs,Integer pageNum,Integer pageSize);

	/**
	 * 通过rzw的id来查询整条对象
	 * @param id
	 * @return
	 */
	BMessageWithBLOBs selectByPrimarykey(BMessageKey key);

	/**
	 * 更新软赢科技
	 * @param bloBs
	 * @return
	 */
	boolean updaterzw(BMessageWithBLOBs bloBs);
	/**
	 * 通过message的id来查询整个message
	 * @param i
	 * @return
	 */
	BMessageWithBLOBs selectRuanying(BMessageKey key);

}
