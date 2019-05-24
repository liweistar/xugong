package com.dao.ymy;


import com.pojo.ymy.Stuel;
import com.pojo.ymy.StuelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuelMapper {
    int countByExample(StuelExample example);

    int deleteByExample(StuelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stuel record);

    int insertSelective(Stuel record);

    List<Stuel> selectByExample(StuelExample example);

    Stuel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stuel record, @Param("example") StuelExample example);

    int updateByExample(@Param("record") Stuel record, @Param("example") StuelExample example);

    int updateByPrimaryKeySelective(Stuel record);

    int updateByPrimaryKey(Stuel record);

    List<Stuel> queryAllStuel();

}