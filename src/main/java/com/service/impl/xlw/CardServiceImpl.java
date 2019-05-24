package com.service.impl.xlw;

import com.dao.xlw.CardMapper;
import com.pojo.xlw.Card;
import com.pojo.xlw.CardExample;
import com.service.xlw.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author level
 * @create 2019/5/7 - 11:58
 */
@Service
public class CardServiceImpl implements CardService {
    @Resource
    public CardMapper cardMapper;

    @Override
    public Card cardList(Integer id) {
        CardExample example = new CardExample();
        CardExample.Criteria criteria=example.createCriteria();
        criteria.andCodeEqualTo(id);
        List<Card> cards = cardMapper.selectByExample(example);
        return cards.get(0);

    }


    @Override
    public void delete(int id) {
        CardExample example=new CardExample();
        CardExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(id);
        cardMapper.deleteByExample(example);
    }

    @Override
    public void chongZhi(Card card) {
        CardExample example=new CardExample();
        CardExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(card.getCode());
        cardMapper.updateByExample(card,example);
    }

    @Override
    public void updateCard(Card card) {
        CardExample example=new CardExample();
        CardExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(card.getCode());
        cardMapper.updateByExampleSelective(card,example);

    }
}
