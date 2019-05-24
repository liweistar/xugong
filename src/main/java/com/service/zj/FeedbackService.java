package com.service.zj;


import com.pojo.zj.Feedback;

import java.util.List;

public interface FeedbackService {
    int ins(String teaname, String content);
    List<Feedback> show(String teaname);

}
