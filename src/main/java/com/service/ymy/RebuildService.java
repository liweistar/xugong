package com.service.ymy;


import com.pojo.ymy.Rebuild;

import java.util.List;

public interface RebuildService {
    //增加
    void addRebuild(Rebuild rebuild);
    //删
    void deleteRebuildById(Integer id);
    //改
    void updateRebuild(Rebuild rebuild);
    //根据id查
    Rebuild queryById(Integer id);
    //查所有
    List<Rebuild> queryAllRebuild();
    //根据学号查询
    List<Rebuild> rebuildList(Integer code);
    //修改状态
    void updateStatus(Rebuild rebuild);
    //根据学号查询
    Rebuild quaryRebuild(Integer code);
}
