package com.controller.xlw;

import com.pojo.xlw.Card;
import com.service.xlw.CardService;
import com.service.xlw.LostCardService;
import com.service.xlw.StudentinformationService;
import com.pojo.xlw.Lost;
import com.pojo.xlw.Studentinformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author level
 * @create 2019/5/7 - 12:02
 */
@Controller
@RequestMapping("/card")
public class CardController {

    @Resource
    public CardService cardServiceImpl;
    @Resource
    public StudentinformationService studentinformationServiceImpl;
    @Resource
    public LostCardService lostCardServiceImpl;
    //查找学号
    @RequestMapping("/card")
    public String card(Model model, Integer code) {
        Card card = cardServiceImpl.cardList(code);
        model.addAttribute("card", card);
    return "/card/allcard";
    }
    //查找所有json
    @RequestMapping("/card1")
    @ResponseBody
    public List<Card> card1(Integer code) {
        Card card = cardServiceImpl.cardList(code);
        List<Card> list=new ArrayList<>();
        list.add(card);
        return list;
    }

    @RequestMapping("/chongzhi")
    @ResponseBody
    public List<Card> chongzhi1(Model model, Card card) {
        int aa=card.getCode();
        Card card1 = cardServiceImpl.cardList(aa);
        card1.setMoney(card1.getMoney()+card.getQian());
        Date date=new Date(System.currentTimeMillis());
        card1.setDate(date);
        cardServiceImpl.chongZhi(card1);
        Card card2=cardServiceImpl.cardList(aa);
        List<Card> cards=new ArrayList<>();
        cards.add(card2);
        return cards;
    }
    //拿到学生学号
    @RequestMapping("lost")
    public String lost(HttpSession session, Card card, Model model){
        List<Lost> losts = lostCardServiceImpl.queryByCode(card.getCode());

        if (losts.size()==1&&"未通过".equals(losts.get(0).getHandle())) {
            model.addAttribute("shibai", "请点击完成，重新申请");
        }
        List<Studentinformation> s = studentinformationServiceImpl.queryByCodeid(card.getCode());
        Studentinformation a = s.get(0);
        session.setAttribute("lost", a);
        return "lostcard/lostcard";
    }
}
