package com.service.ymy;


import com.pojo.ymy.Rexam;

import java.util.List;

public interface RexamService {
    //增加
    void addRexam(Rexam rexam);
    //删
    void deleteRexamById(Integer id);
    //改
    void updateRexam(Rexam rexam);
    //根据id查
    Rexam queryById(Integer id);
    //查所有
    List<Rexam> queryAllRexam();
    //根据学号查询
    List<Rexam> rexamList(Integer code);
    //修改状态
    void updateStatus(Rexam rexam);

    //根据学号查询
    Rexam quaryRexam(Integer code);
}
