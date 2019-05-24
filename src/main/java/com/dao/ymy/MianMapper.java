package com.dao.ymy;


import com.pojo.ymy.Mian;
import com.pojo.ymy.MianExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MianMapper {
    int countByExample(MianExample example);

    int deleteByExample(MianExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mian record);

    int insertSelective(Mian record);

    List<Mian> selectByExample(MianExample example);

    Mian selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mian record, @Param("example") MianExample example);

    int updateByExample(@Param("record") Mian record, @Param("example") MianExample example);

    int updateByPrimaryKeySelective(Mian record);

    int updateByPrimaryKey(Mian record);

    List<Mian> queryAllMian();
}