package com.ry.service;

import java.util.List;
import java.util.Map;

import com.ry.dto.AddressDto;
import com.ry.pojo.BAddress;
import com.ry.pojo.ViewAddr;

public interface AddressService {

	/**查询省
	 * @return
	 */
	List<ViewAddr> selectByprovice();
	
	/**市
	 * @return
	 */
	List<ViewAddr> selectBycity(Integer id);

	/**县
	 * @return
	 */
	List<ViewAddr> selectByCode(Integer id);

	/**修改地址
	 * @param addr
	 * @return
	 */
	boolean saveBAddress(BAddress addr);
	/**
	 * 通过用户的id将该用户的所有地址都显示出来
	 * @param id
	 * @return
	 */
	List<AddressDto> selectAddressByCusid(Map map);
	/**
	 * 通过地址的id来更新数据库
	 * @param address
	 * @return
	 */
	boolean updateAddressById(BAddress address);
	/**
	 * 插入地址
	 * @param address
	 * @return
	 */
	boolean insertAddress(BAddress address);
	/**
	 * 通过地址的id删除地址
	 * @param id
	 * @return
	 */
	boolean deleteById(Integer id);
	/**
	 * 如果用户点击了设为默认，将数据库中的isdefault设为1
	 * @param address
	 * @return
	 */
	boolean updateByMoren(BAddress address);
	/**
	 * 用户点击了设为默认之后，数据库中除了ciid的其他isdefault都应该为0
	 * @param address
	 * @return
	 */
	boolean updateOtherNotMoren(BAddress address);
}
