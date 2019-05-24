package com.service.ymy;


import com.pojo.ymy.Mian;

import java.util.List;

public interface MianService {
    //增加
    void addMian(Mian mian);
    //删
    void deleteMianById(Integer id);
    //改
    void updateMian(Mian mian);
    //根据id查
    Mian queryById(Integer id);
    //查所有
    List<Mian> queryAllMian();
    //根据学号查询
    List<Mian> mianList(Integer code);
    //修改状态
    void updateStatus(Mian mian);

    //根据学号查询
    Mian quaryMian(Integer code);
}
