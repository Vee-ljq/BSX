package com.ry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ry.dto.BmessageDto;
import com.ry.pojo.BMessage;
import com.ry.pojo.BMessageExample;
import com.ry.pojo.BMessageKey;
import com.ry.pojo.BMessageWithBLOBs;

public interface BMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    long countByExample(BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int deleteByExample(BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int deleteByPrimaryKey(BMessageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int insert(BMessageWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int insertSelective(BMessageWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    List<BMessageWithBLOBs> selectByExampleWithBLOBs(BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    List<BMessage> selectByExample(BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    BMessageWithBLOBs selectByPrimaryKey(BMessageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") BMessageWithBLOBs record, @Param("example") BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") BMessageWithBLOBs record, @Param("example") BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int updateByExample(@Param("record") BMessage record, @Param("example") BMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int updateByPrimaryKeySelective(BMessageWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(BMessageWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_message
     *
     * @mbg.generated Fri Dec 27 11:44:35 CST 2019
     */
    int updateByPrimaryKey(BMessage record);
    /**
     * 在数据库中查询RZW
     * 
     */
    List<BMessageWithBLOBs> selectRZW(BMessageWithBLOBs  bloBs);
    
    
    /*
     * 
     * 
     * */
   List<BmessageDto> selectnews(BmessageDto bd);
    
   BmessageDto selectsy(int a);
   
   boolean deletes(int [] ids);
   List<BMessageWithBLOBs> selectAllMessage();
}