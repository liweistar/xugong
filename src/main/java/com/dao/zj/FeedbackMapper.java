package com.dao.zj;


import com.pojo.zj.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    int insFb(@Param("teaname") String teaname, @Param("content") String content);
    List<Feedback> selFb(String teaname);
}
