package com.service.impl.xlw;

import com.dao.xlw.CardMapper;
import com.dao.xlw.LostMapper;
import com.pojo.xlw.Card;
import com.pojo.xlw.CardExample;
import com.pojo.xlw.Lost;
import com.pojo.xlw.LostExample;
import com.service.xlw.LostCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author level
 * @create 2019/5/12 - 11:03
 */
@Service
public class LostCardServiceImpl implements LostCardService {
    @Resource
    public LostMapper lostMapper;
    @Resource
    public CardMapper cardMapper;
    @Override
    public void addLostCard(Lost lost) {
        lostMapper.insert(lost);
    }

    @Override
    public List<Lost> queryAll() {
        LostExample example=new LostExample();
        List<Lost> losts = lostMapper.selectByExample(example);
        return losts;
    }

    @Override
    public List<Lost> queryByCode(int a) {
        LostExample example=new LostExample();
        LostExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(a);
        List<Lost> losts = lostMapper.selectByExample(example);
        return losts;
    }

    @Override
    public void updataLost(Lost lost) {
        LostExample example=new LostExample();
        LostExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(lost.getCode());
        lostMapper.updateByExampleSelective(lost,example);
    }

    @Override
    public List<Lost> selectByReviewe(Lost lost) {
        LostExample example=new LostExample();
        LostExample.Criteria criteria = example.createCriteria();
        criteria.andRevieweEqualTo(lost.getReviewe());
        List<Lost> losts = lostMapper.selectByExample(example);
        return losts;
    }

    @Override
    public List<Card> selectByPower(String a, int b) {
        CardExample example=new CardExample();
        CardExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(b).andPowerEqualTo(a);
        List<Card> list = cardMapper.selectByExample(example);

        return list;
    }

    @Override
    public List<Lost> selectByRecive(String a) {
        LostExample example=new LostExample();
        LostExample.Criteria criteria = example.createCriteria();
        criteria.andReciveEqualTo(a);
        List<Lost> losts=lostMapper.selectByExample(example);
        return losts;
    }

    @Override
    public void delete(int a) {
        LostExample example=new LostExample();
        LostExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(a);
        lostMapper.deleteByExample(example);
    }
}
