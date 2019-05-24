package com.service.xlw;

import com.pojo.xlw.Card;
import com.pojo.xlw.Lost;

import java.util.List;

/**
 * @author level
 * @create 2019/5/12 - 11:02
 */
public interface LostCardService {
    //增加
    void addLostCard(Lost lost);

    List<Lost> queryAll();

    List<Lost> queryByCode(int a);

    void updataLost(Lost lost);

    List<Lost> selectByReviewe(Lost lost);

    List<Card> selectByPower(String a, int b);

    List<Lost> selectByRecive(String a);

    void delete(int a);
}
