package com.controller.xlw;

import com.pojo.xlw.Card;
import com.pojo.xlw.Lost;
import com.pojo.xlw.ResponseBo;
import com.service.xlw.CardService;
import com.service.xlw.LostCardService;
import com.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author level
 * @create 2019/5/12 - 11:34
 */
@Controller
@RequestMapping("make")
public class MakeController {

    @Resource
    public LostCardService lostCardServiceImpl;
    @Resource
    public CardService cardServiceImpl;
    //领取一卡通
    @RequestMapping("recive")
    public String f(Lost lost){
        Card card=new Card();
        card.setCode(lost.getCode());
        card.setPower("可用");
        cardServiceImpl.updateCard(card);
        lost.setRecive("可领取");
        lostCardServiceImpl.updataLost(lost);
        return "/make/make";
    }
    //查询所有可以补办的
    @RequestMapping("table")
    @ResponseBody
    public List aaaa(Lost lost){
        List<Lost> losts = lostCardServiceImpl.selectByRecive(lost.getRecive());
        return losts;
    }
    //生成报表
    @RequestMapping("/excel")
    @ResponseBody
    public ResponseBo achievementExcel() {
        try {
            Lost lost=new Lost();
            lost.setRecive("不可领取");
            List<Lost> losts  = this.lostCardServiceImpl.selectByRecive(lost.getRecive());
            return FileUtils.createExcelByPOIKit("补办表", losts, Lost.class);
        } catch (Exception e) {
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }
    //查询所有需要补办
    @RequestMapping("make")
    public String make(Model model){
        List<Lost> list = lostCardServiceImpl.queryAll();
        model.addAttribute("losts",list);
        return "make/make";
    }
    //json显示所有进行挂失的同学
    @RequestMapping("status")
    @ResponseBody
    public List status(){
        List<Lost> losts = lostCardServiceImpl.queryAll();
        System.out.println(losts);
        return  losts;
    }
    //json点击通过
    @RequestMapping("pass")
    public String status1(Lost lost){
        lost.setHandle("通过");
        lost.setReviewe("已审核");
        Card card=new Card();
        card.setCode(lost.getCode());
        card.setPower("不可用");
        lost.setRecive("不可领取");
        cardServiceImpl.updateCard(card);
        lostCardServiceImpl.updataLost(lost);
        List<Lost> losts = lostCardServiceImpl.queryAll();
        System.out.println(losts);
        return  "/make/make";
    }
   // json点击未通过
    @RequestMapping("fall")

    public String status2(Lost lost){
        lost.setHandle("未通过");
        lost.setReviewe("已审核");
        Card card=new Card();
        card.setCode(lost.getCode());
        card.setPower("可用");
        cardServiceImpl.updateCard(card);
        lostCardServiceImpl.updataLost(lost);
        List<Lost> losts = lostCardServiceImpl.queryAll();
        System.out.println(losts);
        return  "/make/make";
    }
    // json条件查询待审核和已审核
    @RequestMapping("selbtn1")
    @ResponseBody
    public List status3(Lost lost, Model model){
        List<Lost> a = lostCardServiceImpl.selectByReviewe(lost);
        return  a;
    }
}
