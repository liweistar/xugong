package com.service.impl.ymy;


import com.dao.ymy.AchievementMapper;
import com.pojo.ymy.Achievement;
import com.pojo.ymy.AchievementExample;
import com.service.ymy.AchievementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {
    @Resource
    private AchievementMapper achievementMapper;
    //增加
    @Override
    public void addAchievement(Achievement achievement) {
        achievementMapper.insert(achievement);
    }

    //删除
    @Override
    public void deleteAchievementById(Integer id) {
        achievementMapper.deleteByPrimaryKey(id);
    }

    //修改
    @Override
    public void updateAchievement(Achievement achievement) {
        achievementMapper.updateByPrimaryKey(achievement);
    }

    //根据id查询
    @Override
    public Achievement queryById(Integer id) {
        return achievementMapper.selectByPrimaryKey(id);
    }

    //查询所有
    @Override
    public List<Achievement> queryAllAchievement() {
        return achievementMapper.queryAllAchievement();
    }

    //根据学号查询
    @Override
    public Achievement achievementList(Integer code) {
        AchievementExample example = new AchievementExample();
        AchievementExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Achievement> achievements = achievementMapper.selectByExample(example);
        return achievements.get(0);
    }
    //免修修改成绩
    @Override
    public void mianA(Achievement achievement) {
        AchievementExample example=new AchievementExample();
        AchievementExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(achievement.getCode());
        achievementMapper.updateByExample(achievement,example);
    }
}
