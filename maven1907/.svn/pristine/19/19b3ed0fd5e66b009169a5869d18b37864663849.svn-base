package com.ry.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ry.dto.BmessageDto;
import com.ry.pojo.BMessage;
import com.ry.pojo.BMessageWithBLOBs;
import com.ry.pojo.SMessagetype;

public interface BmessageService {
	PageInfo<BmessageDto> selectall(BmessageDto bd,Integer pageNum,Integer pageSise);
	
	boolean insertlb(SMessagetype smtt);
	
	List<SMessagetype> selectxw();
	
	boolean insertandupdadtaxw(BMessageWithBLOBs bm,SMessagetype smt);
	  BmessageDto selectalls(int a);
	  
	  boolean updatabiji(BMessageWithBLOBs bm,SMessagetype smt);
	  boolean deleteid(int a);
	  
	  boolean deletes(int [] ids);

	/**查询所有新闻
	 * @return
	 */
	  List<BMessageWithBLOBs> selectAllBmessge();
}
