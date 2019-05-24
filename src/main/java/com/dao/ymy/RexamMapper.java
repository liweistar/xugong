package com.dao.ymy;

import com.pojo.ymy.Rexam;
import com.pojo.ymy.RexamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RexamMapper {
    int countByExample(RexamExample example);

    int deleteByExample(RexamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rexam record);

    int insertSelective(Rexam record);

    List<Rexam> selectByExample(RexamExample example);

    Rexam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rexam record, @Param("example") RexamExample example);

    int updateByExample(@Param("record") Rexam record, @Param("example") RexamExample example);

    int updateByPrimaryKeySelective(Rexam record);

    int updateByPrimaryKey(Rexam record);

    List<Rexam> queryAllRexam();
}