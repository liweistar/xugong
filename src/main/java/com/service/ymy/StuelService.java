package com.service.ymy;




import com.pojo.ymy.Stuel;

import java.util.List;

public interface StuelService {
    //增
    void addStuel(Stuel stuel);
    //删
    void deleteStuelById(Integer id);
    //改
    void updateStuel(Stuel stuel);
    //根据id查
    Stuel queryById(Integer id);
    //查所有
    List<Stuel> queryAllStuel();
    //根据学号查询
    Stuel stuelList(Integer code);
    //学生增加评价
    void addStuele(Stuel stuel);
}
