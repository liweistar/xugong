package com.dao.zj;

import org.apache.ibatis.annotations.Param;

public interface DelMapper {
    int delCourse(@Param("codeid") int codeid, @Param("courseid") int courseid);
    int updcount(int id);
}
