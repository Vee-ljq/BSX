package com.ry.mapper;

import com.ry.dto.BGoodsViewDto;
import com.ry.pojo.BGoodsview;
import com.ry.pojo.BGoodsviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BGoodsviewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    long countByExample(BGoodsviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int deleteByExample(BGoodsviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int insert(BGoodsview record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int insertSelective(BGoodsview record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    List<BGoodsview> selectByExample(BGoodsviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    BGoodsview selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") BGoodsview record, @Param("example") BGoodsviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int updateByExample(@Param("record") BGoodsview record, @Param("example") BGoodsviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int updateByPrimaryKeySelective(BGoodsview record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goodsview
     *
     * @mbg.generated Fri Dec 27 16:07:32 CST 2019
     */
    int updateByPrimaryKey(BGoodsview record);

    /**
     * 查询客户浏览商品的内容
     * @param bg
     * @return
     */
    	List<BGoodsViewDto> selectGoodsViews(BGoodsViewDto bg);


	List<BGoodsViewDto> selectByTime(BGoodsViewDto bg);

    	/**
    	 * 查看当前用户的之前足迹浏览商品
    	 * @return
    	 */
	List<BGoodsViewDto> selectCuidGoodsView();

	/**
	 * 商品流量统计分析
	 * @return
	 */
	List<BGoodsViewDto> goodsFlow();

}