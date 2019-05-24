package com.service.xlw;


import com.pojo.xlw.Card;

/**
 * @author level
 * @create 2019/5/7 - 11:57
 */
public interface CardService {
    //
    Card cardList(Integer id);

    void delete(int id);

    void chongZhi(Card card);

    void updateCard(Card card);
}
