package com.ry.mapper;

import com.ry.pojo.STastetype;
import com.ry.pojo.STastetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface STastetypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    long countByExample(STastetypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int deleteByExample(STastetypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int insert(STastetype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int insertSelective(STastetype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    List<STastetype> selectByExample(STastetypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    STastetype selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") STastetype record, @Param("example") STastetypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int updateByExample(@Param("record") STastetype record, @Param("example") STastetypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int updateByPrimaryKeySelective(STastetype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tastetype
     *
     * @mbg.generated Sat Dec 28 14:23:44 CST 2019
     */
    int updateByPrimaryKey(STastetype record);
}