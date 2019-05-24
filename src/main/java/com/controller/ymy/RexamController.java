package com.controller.ymy;


import com.pojo.ymy.Exam;
import com.pojo.ymy.Rexam;
import com.service.ymy.ExamService;
import com.service.ymy.RexamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("rexam")
public class RexamController {
    @Resource
    private RexamService rexamService;

    @Resource
    private ExamService examService;
    /**
     * 按照学号查询
     */
    @RequestMapping("/rexam")
    public String Rexam(Model model, Integer code) {
        List<Rexam> rexams = rexamService.rexamList(code);
        if (rexams.size() == 0) {
            model.addAttribute("wu", "无");
        } else {
            model.addAttribute("rexam", rexams.get(0));
        }

        return "rexam/studentRexam";
    }

    //查找所有json
    @RequestMapping("/json")
    @ResponseBody
    public List<Rexam> rexams(Integer code) {
        List<Rexam> list = rexamService.rexamList(code);
        return list;
    }

    /**
     * 增加重考
     * @return
     */
    @RequestMapping("toAddRexam")
    public String toAddRexam(Model model, Integer code) {
        model.addAttribute("code", code);
        return "rexam/addRexam";
    }

    /**
     * 增加重考
     * @param rexam
     * @return
     */
    @RequestMapping("/addRexam")
    public String addRexam(Model model, Rexam rexam) {
        rexam.setStatus("审核中");
        rexam.setTime(new Date());
        rexamService.addRexam(rexam);
        model.addAttribute("code", rexam.getCode());
        return "redirect:/rexam/rexam?code=" + rexam.getCode();
    }

    /**
     * 查询重考申请
     * @param model
     * @return
     */
    @RequestMapping("/allRexam")
    public String list(Model model, HttpSession session) {
        List<Rexam> list = rexamService.queryAllRexam();
        model.addAttribute("list", list);
        return "rexam/allRexam";
    }

    /**
     * json数据交互
     *
     * @return
     */
    @RequestMapping("/rexamjson")
    public @ResponseBody
    List<Rexam> json() {
        List<Rexam> rexams = rexamService.queryAllRexam();
        return rexams;
    }

    /**
     * 修改审核状态
     * 同时将申请科目编排到考试安排中
     * @param model
     * @param rexam
     * @param exam
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public List<Rexam> updateStatus(Model model, Rexam rexam, Exam exam) {


        Rexam rexam1 = rexamService.quaryRexam(rexam.getCode());
        rexam1.setStatus("通过");
        rexam1.setTime(new Date());
        rexamService.updateStatus(rexam1);
        if (rexam1!=null) {
            exam.setCode(rexam1.getCode());
            exam.setName(rexam1.getName());
            exam.setKemu(rexam1.getRkemu());
            exam.setTime("待定");
            exam.setStatus("待考");
            examService.addExam(exam);
        }
        List<Rexam> rexamList = rexamService.queryAllRexam();
        return rexamList;
    }
}
