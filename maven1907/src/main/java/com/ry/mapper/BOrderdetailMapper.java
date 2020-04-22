package com.ry.mapper;

import com.ry.dto.OrdersDto;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.BOrderdetailExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BOrderdetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    long countByExample(BOrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int deleteByExample(BOrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int insert(BOrderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int insertSelective(BOrderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    List<BOrderdetail> selectByExample(BOrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    BOrderdetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int updateByExampleSelective(@Param("record") BOrderdetail record, @Param("example") BOrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int updateByExample(@Param("record") BOrderdetail record, @Param("example") BOrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int updateByPrimaryKeySelective(BOrderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_orderdetail
     *
     * @mbg.generated Mon Dec 23 15:07:15 CST 2019
     */
    int updateByPrimaryKey(BOrderdetail record);
    
    List<BOrderdetail>  selectByGoodsidAndSubstring(Map map);
    
  //更新明细totalPrice
  	int updateDetailTotalPriById(Integer mainid);

}