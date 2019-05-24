package com.dao.ymy;


import com.pojo.ymy.Rebuild;
import com.pojo.ymy.RebuildExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RebuildMapper {
    int countByExample(RebuildExample example);

    int deleteByExample(RebuildExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rebuild record);

    int insertSelective(Rebuild record);

    List<Rebuild> selectByExample(RebuildExample example);

    Rebuild selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rebuild record, @Param("example") RebuildExample example);

    int updateByExample(@Param("record") Rebuild record, @Param("example") RebuildExample example);

    int updateByPrimaryKeySelective(Rebuild record);

    int updateByPrimaryKey(Rebuild record);

    List<Rebuild> queryAllRebuild();
}