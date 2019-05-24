package com.dao.xlw;

import com.pojo.xlw.Lost;
import com.pojo.xlw.LostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LostMapper {
    int countByExample(LostExample example);

    int deleteByExample(LostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lost record);

    int insertSelective(Lost record);

    List<Lost> selectByExample(LostExample example);

    Lost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lost record, @Param("example") LostExample example);

    int updateByExample(@Param("record") Lost record, @Param("example") LostExample example);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}