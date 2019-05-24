package com.service.impl.zj;


import com.dao.zj.DelMapper;
import com.service.zj.DelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DelServiceImpl implements DelService {
    @Resource
    private DelMapper delMapper;
    @Override
    public int show(int codeid, int courseid) {
        return delMapper.delCourse(codeid,courseid);
    }

    @Override
    public int setcount(int id) {
        return delMapper.updcount(id);
    }
}
