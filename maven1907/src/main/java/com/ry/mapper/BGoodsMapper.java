package com.ry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ry.dto.BGoodsViewDto;
import com.ry.dto.GoodsDto;
import com.ry.dto.OrdersDto;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsExample;
import com.ry.pojo.BGoodsKey;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.ViewAddr;

public interface BGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    long countByExample(BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int deleteByExample(BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int deleteByPrimaryKey(BGoodsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int insert(BGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int insertSelective(BGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    List<BGoodsWithBLOBs> selectByExampleWithBLOBs(BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    List<BGoods> selectByExample(BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    BGoodsWithBLOBs selectByPrimaryKey(BGoodsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int updateByExampleSelective(@Param("record") BGoodsWithBLOBs record, @Param("example") BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int updateByExampleWithBLOBs(@Param("record") BGoodsWithBLOBs record, @Param("example") BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int updateByExample(@Param("record") BGoods record, @Param("example") BGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(BGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int updateByPrimaryKeyWithBLOBs(BGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_goods
     *
     * @mbg.generated Wed Dec 25 10:53:59 GMT+08:00 2019
     */
    int updateByPrimaryKey(BGoods record);

    
    //******王龙虎添加************************
   int deleteByIds(int [] ids);

    
    
    
    
    
    
    
	/**查询订单类型
	 * @param sg
	 * @return
	 */
	List<GoodsDto> selectAllOrderTypeOrId(GoodsDto sg);
	
	/**根据id
	 * @param id
	 * @return
	 */
	GoodsDto selectById(Integer id);

//查询出所有Goods
	List<BGoods> selectByGoodIdOrName(BGoods goods);
//显示所有省份列表
	List<ViewAddr> selectAllProvence();
//通过省份id查询出所属的所有城市
	List<ViewAddr> selectAllCityBuProid(Integer provenceid);
//通过省份id查询出所属的所有城市
	List<ViewAddr> selectAllXianByCityid(Integer cityid);

	/**模糊查询商品
	 * @param goodsname
	 * @return
	 */
	List<GoodsDto> selectByGoodsName(String goodsname);

	//累计销量
	int countAllOrderNum(Integer goodsid);
	//累计评价数量
	int countAllCommentNum(Integer goodsid);
	//月销量
	int countMonthOrder(OrdersDto orderdto);
	/**
	 * 通过在搜索框中搜索条件之后筛选响应的商品
	 * @param tiaojian
	 * @return
	 */
	List<BGoodsWithBLOBs> selectByTiaojian(String tiaojian);


}