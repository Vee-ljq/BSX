package com.ry.service;

import java.util.List;
import java.util.Map;

import com.ry.dto.BillDto;
import com.ry.pojo.BOrdermain;

public interface BillService {

	/**查询所有的购买商品
	 * @return
	 */
	List<BillDto> selectAllGoods(Integer cusid);

	/**查询总消费
	 * @param id
	 * @return
	 */
	BillDto selectSum(Integer id);

	/**删除
	 * @param goodsid
	 * @return
	 */
	boolean deleteBillList(BOrdermain bord);

	/**查询固定时间内的消费记录
	 * @param id
	 * @return
	 */
	List<BillDto> selectGoodsByDate(Map map);

}
