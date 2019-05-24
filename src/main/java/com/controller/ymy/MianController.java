package com.controller.ymy;


import com.pojo.ymy.Achievement;
import com.pojo.ymy.Mian;
import com.service.ymy.AchievementService;
import com.service.ymy.MianService;
import com.utils.Suan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mian")
public class MianController {

    @Resource
    private MianService mianService;
    @Resource
    private AchievementService achievementService;

    /**
     * 按照学号查询
     */

    //查找学号
    @RequestMapping("/mian")
    public String achievement(Model model, Integer code) {
        List<Mian> mian = mianService.mianList(code);
        if (mian.size() == 0) {
            model.addAttribute("wu", "无");
        } else {
            model.addAttribute("mian", mian.get(0));
        }
        return "mian/studentMian";
    }

    //查找所有json
    @RequestMapping("/json")
    @ResponseBody
    public List<Mian> mians(Integer code) {
        List<Mian> list = mianService.mianList(code);
        return list;
    }

    /**
     * 增加成绩
     *
     * @return
     */
    @RequestMapping("toAddMian")
    public String toAddEvaluate(Model model, Integer code) {
        model.addAttribute("code", code);
        return "mian/addMian";
    }

    /**
     * 增加免修
     *
     * @param mian
     * @return
     */
    @RequestMapping("/addMian")
    public String addAchievement(Model model, Mian mian) {
        mian.setStatus("审核中");
        mian.setTime(new Date());
        mianService.addMian(mian);
        model.addAttribute("code", mian.getCode());
        return "redirect:/mian/mian?code=" + mian.getCode();
    }


    /**
     * 查询免修申请
     *
     * @param model
     * @return
     */
    @RequestMapping("/allMian")
    public String list(Model model, HttpSession session) {
        List<Mian> list = mianService.queryAllMian();
        model.addAttribute("list", list);
        return "mian/allMian";
    }

    /**
     * json数据交互
     *
     * @return
     */
    @RequestMapping("/mianjson")
    public @ResponseBody
    List<Mian> json() {
        List<Mian> mians = mianService.queryAllMian();
        return mians;
    }

    /**
     * 修改审核状态
     * 同时将申请科目成绩改为100
     *
     * @param model
     * @param mian
     * @param achievement
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public List<Mian> updateStatus(Model model, Mian mian, Achievement achievement) {
        int a = mian.getCode();

        Mian mian1 = mianService.quaryMian(a);
        mian1.setStatus("通过");
        mianService.updateStatus(mian1);
        List<Mian> mianList = mianService.queryAllMian();

        if (mian1.getKemu().equals("英语")) {
            Achievement achievement1 = achievementService.achievementList(a);
            achievement1.setKefour(100.0);
            //调用工具类计算绩点
            Suan suan = new Suan();
            achievement1.setPoint(suan.suan(achievement1.getKeone(), achievement1.getKetwo(), achievement1.getKethree(), achievement1.getKefour(), achievement1.getKefive()));
            achievementService.updateAchievement(achievement1);
        } else if (mian1.getKemu().equals("高数")) {
            Achievement achievement1 = achievementService.achievementList(a);
            achievement1.setKefive(100.0);
            Suan suan = new Suan();
            achievement1.setPoint(suan.suan(achievement1.getKeone(), achievement1.getKetwo(), achievement1.getKethree(), achievement1.getKefour(), achievement1.getKefive()));
            achievementService.updateAchievement(achievement1);
        } else if (mian1.getKemu().equals("计算机导论")) {
            Achievement achievement1 = achievementService.achievementList(a);
            achievement1.setKeone(100.0);
            Suan suan = new Suan();
            achievement1.setPoint(suan.suan(achievement1.getKeone(), achievement1.getKetwo(), achievement1.getKethree(), achievement1.getKefour(), achievement1.getKefive()));
            achievementService.updateAchievement(achievement1);
        } else if (mian1.getKemu().equals("c++")) {
            Achievement achievement1 = achievementService.achievementList(a);
            achievement1.setKetwo(100.0);
            Suan suan = new Suan();
            achievement1.setPoint(suan.suan(achievement1.getKeone(), achievement1.getKetwo(), achievement1.getKethree(), achievement1.getKefour(), achievement1.getKefive()));
            achievementService.updateAchievement(achievement1);
        } else if (mian1.getKemu().equals("java框架")) {
            Achievement achievement1 = achievementService.achievementList(a);
            achievement1.setKethree(100.0);
            Suan suan = new Suan();
            achievement1.setPoint(suan.suan(achievement1.getKeone(), achievement1.getKetwo(), achievement1.getKethree(), achievement1.getKefour(), achievement1.getKefive()));
            achievementService.updateAchievement(achievement1);
        }
        return mianList;
    }
}
