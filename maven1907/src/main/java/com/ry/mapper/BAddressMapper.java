package com.ry.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ry.dto.AddressDto;
import com.ry.pojo.BAddress;
import com.ry.pojo.BAddressExample;

public interface BAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    long countByExample(BAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int deleteByExample(BAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int insert(BAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int insertSelective(BAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    List<BAddress> selectByExample(BAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    BAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") BAddress record, @Param("example") BAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int updateByExample(@Param("record") BAddress record, @Param("example") BAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int updateByPrimaryKeySelective(BAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_address
     *
     * @mbg.generated Wed Dec 25 17:47:03 CST 2019
     */
    int updateByPrimaryKey(BAddress record);

  //通过custid来查询的地址信息
    List<AddressDto> selectAddrByCusid(Integer custid);
  //设为默认地址  
   int  updateAsDefautlAdd(Integer defaultid);
   //修改非默认地址的isDefault字段
   int updateNotAsDefautlAdd (Integer defaultid);

    /**
     * 通过用户的id将用户的所有的地址遍历出来
     * @param id
     * @return
     */
	List<AddressDto> selectAddressByCusid(Map map);
	/**
	 * 将数据库中其他的isdefault设为0
	 * @param address
	 */
	void updateOtherMoren(BAddress address);

}