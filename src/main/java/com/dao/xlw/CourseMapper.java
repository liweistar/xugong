package com.dao.xlw;

import com.pojo.xlw.Course;
import com.pojo.xlw.CourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer courseid);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    //zj
    List<Course> selBycourse(String coursepower);
    List<Course> selAll(@Param("coursepower") String coursepower, @Param("selcount") int selcount);
    List<Course> selBybi(String coursetype);//显示必修课
    List<Course> selBytc(String courseteacher);//显示教师对应课程
    List<Course> selBych(@Param("coursetype") String coursetype,@Param("coursepower")String coursepower);//显示重修选课
}