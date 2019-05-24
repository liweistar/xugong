package com.service.impl.zj;

import com.dao.zj.SelectMapper;
import com.pojo.zj.Selectcourse;
import com.service.zj.SelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Resource
    private SelectMapper selectMapper;

    @Override
    public int ins(Selectcourse selectcourse) {
        return selectMapper.insselect(selectcourse);
    }

    @Override
    public int setcount(int id) {
        return selectMapper.updcount(id);
    }

    @Override
    public Selectcourse show(Selectcourse selectcourse) {
        return selectMapper.selBysc(selectcourse);
    }

    @Override
    public List<Selectcourse> showt(int codeid) {
        return selectMapper.selTwo(codeid);
    }

    @Override
    public int insH(Selectcourse selectcourse) {
        return selectMapper.insHis(selectcourse);
    }

    @Override
    public List<Selectcourse> showhis(int codeid) {
        return selectMapper.selByhis(codeid);
    }


}
