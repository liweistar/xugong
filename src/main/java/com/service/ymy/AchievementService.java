package com.service.ymy;


import com.pojo.ymy.Achievement;

import java.util.List;

public interface AchievementService {

    //增加
    void addAchievement(Achievement achievement);
    //删
    void deleteAchievementById(Integer id);
    //改
    void updateAchievement(Achievement achievement);
    //根据id查
    Achievement queryById(Integer id);
    //查所有
    List<Achievement> queryAllAchievement();
    //根据学号查询
    Achievement achievementList(Integer code);
    //更改成绩根据学号
    void mianA(Achievement achievement);
}
