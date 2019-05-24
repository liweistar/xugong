package com.controller.ymy;
import com.pojo.xlw.ResponseBo;
import com.pojo.ymy.Achievement;
import com.service.ymy.AchievementService;
import com.utils.FileUtils;
import com.utils.Suan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/achievement")
public class AchievementController {
    @Resource
    private AchievementService achievementService;

    /**
     * 查询所有考试成绩信息
     * @param model
     * @return
     */
    @RequestMapping("/allAchievement")
    public String list(Model model, HttpSession session) {
        List<Achievement> list = achievementService.queryAllAchievement();
        session.setAttribute("list",list);
        return "achievement/allAchievement";
    }

    /**
     * json数据交互
     * @return
     */
    @RequestMapping("/achievementjson")
    public @ResponseBody
    List<Achievement> json(){
        List<Achievement> achievements = achievementService.queryAllAchievement();
        return achievements;
    }

    /**
     * 增加成绩
     * @return
     */
    @RequestMapping("toAddAchievement")
    public String toAddEvaluate() {
        return "achievement/addAchievement";
    }

    /**
     * 增加学生成绩
     * @param achievement
     * @return
     */
    @RequestMapping("/addAchievement")
    public String addAchievement(Model model,Achievement achievement) {
        Suan suan = new Suan();
        achievement.setPoint(suan.suan(achievement.getKeone(),achievement.getKetwo(),achievement.getKethree(),achievement.getKefour(),achievement.getKefive()));
        achievementService.addAchievement(achievement);
        return "redirect:/achievement/allAchievement";
    }

    /**
     * 删除成绩
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public String deleteAchievement(int id) {
        achievementService.deleteAchievementById(id);
        return "redirect:/achievement/allAchievement";
    }

    /**
     * 修改成绩
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("toUpdateAchievement")
    public String toUpdateEvaluate(Model model, int id) {
        model.addAttribute("achievement", achievementService.queryById(id));
        return "achievement/updateAchievement";
    }

    @RequestMapping("/updateAchievement")
    public String updateAchievement(Model model, Achievement achievement) {
        Suan suan = new Suan();
        achievement.setPoint(suan.suan(achievement.getKeone(),achievement.getKetwo(),achievement.getKethree(),achievement.getKefour(),achievement.getKefive()));
        achievementService.updateAchievement(achievement);
        return "redirect:/achievement/allAchievement";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/getAllById")
    @ResponseBody
    public Achievement queryById(int id) {
        Achievement achievement = achievementService.queryById(id);
        return achievement;
    }

    /**
     * 报表
     * @return
     */
    @RequestMapping("/excel")
    @ResponseBody
    public ResponseBo achievementExcel() {
        try {
            List<Achievement> list = this.achievementService.queryAllAchievement();
            return FileUtils.createExcelByPOIKit("成绩表", list, Achievement.class);
        } catch (Exception e) {
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }



    /**
     * 按照学号查询
     */

    //查找学号
    @RequestMapping("/achievement")
    public String achievement(Model model, Integer code) {
        Achievement achievement = achievementService.achievementList(code);
        model.addAttribute("achievement", achievement);
        return "achievement/studentAchievement";
    }
    //查找所有json
    @RequestMapping("/json")
    @ResponseBody
    public List<Achievement> achievements(Integer code) {
        Achievement achievement = achievementService.achievementList(code);
        List<Achievement> list=new ArrayList<>();
        list.add(achievement);
        return list;
    }
    
}
