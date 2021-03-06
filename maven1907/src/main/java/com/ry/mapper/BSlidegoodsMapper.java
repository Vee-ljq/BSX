package com.ry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ry.dto.slidegoodsDto;
import com.ry.pojo.BSlidegoods;
import com.ry.pojo.BSlidegoodsExample;

public interface BSlidegoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    long countByExample(BSlidegoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int deleteByExample(BSlidegoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int insert(BSlidegoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int insertSelective(BSlidegoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    List<BSlidegoods> selectByExample(BSlidegoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    BSlidegoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") BSlidegoods record, @Param("example") BSlidegoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int updateByExample(@Param("record") BSlidegoods record, @Param("example") BSlidegoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int updateByPrimaryKeySelective(BSlidegoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_slidegoods
     *
     * @mbg.generated Sat Dec 28 16:26:32 CST 2019
     */
    int updateByPrimaryKey(BSlidegoods record);

	/**轮播图
	 * @return
	 */
	List<slidegoodsDto> selectSlidegoods();
}