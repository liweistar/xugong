package com.dao.xlw;

import com.pojo.xlw.Studentinformation;
import com.pojo.xlw.StudentinformationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentinformationMapper {
    int countByExample(StudentinformationExample example);

    int deleteByExample(StudentinformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Studentinformation record);

    int insertSelective(Studentinformation record);

    List<Studentinformation> selectByExample(StudentinformationExample example);

    Studentinformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Studentinformation record, @Param("example") StudentinformationExample example);

    int updateByExample(@Param("record") Studentinformation record, @Param("example") StudentinformationExample example);

    int updateByPrimaryKeySelective(Studentinformation record);

    int updateByPrimaryKey(Studentinformation record);
    List<Studentinformation> selectAll();
}