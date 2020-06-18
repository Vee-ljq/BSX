package com.ry.mapper;

import com.ry.pojo.BGoodstaste;
import com.ry.pojo.BGoodstasteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BGoodstasteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    long countByExample(BGoodstasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    int deleteByExample(BGoodstasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    int insert(BGoodstaste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    int insertSelective(BGoodstaste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    List<BGoodstaste> selectByExample(BGoodstasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") BGoodstaste record, @Param("example") BGoodstasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodstaste
     *
     * @mbg.generated Tue Dec 31 15:31:46 CST 2019
     */
    int updateByExample(@Param("record") BGoodstaste record, @Param("example") BGoodstasteExample example);
	//显示该商品所有的口味
	List<BGoodstaste> selectTasteByGoodsid(Integer goodsid);
}