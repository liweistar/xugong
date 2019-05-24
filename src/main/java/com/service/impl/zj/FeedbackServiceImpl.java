package com.service.impl.zj;


import com.dao.zj.FeedbackMapper;
import com.pojo.zj.Feedback;
import com.service.zj.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public int ins(String teaname, String content) {
        return feedbackMapper.insFb(teaname,content);
    }

    @Override
    public List<Feedback> show(String teaname) {
        return feedbackMapper.selFb(teaname);
    }
}
