package com.controller.ymy;


import com.pojo.xlw.ResponseBo;
import com.pojo.xlw.Studentinformation;
import com.pojo.ymy.Exam;
import com.service.xlw.StudentinformationService;
import com.service.ymy.ExamService;
import com.utils.FileUtils;
import com.utils.Suan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Resource
    private ExamService examService;

    @Resource
    private StudentinformationService studentinformationService;
    /**
     * 查询所有考试安排
     * @param
     * @return
     */
    @RequestMapping("/allExam")
    public String list() {
        return "exam/allExam";
    }

    /**
     * json数据交互
     * @return
     */
    @RequestMapping("/examjson")
    public @ResponseBody
    List<Exam> json(){
        List<Exam> exams = examService.queryAllExam();
        return exams;
    }

    /**
     * 报表
     * @return
     */
    @RequestMapping("/excel")
    @ResponseBody
    public ResponseBo examExcel() {
        try {
            List<Exam> list = this.examService.queryAllExam();
            return FileUtils.createExcelByPOIKit("考试安排表", list, Exam.class);
        } catch (Exception e) {
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    /**
     * 增加考试安排
     * @return
     */
    @RequestMapping("toAddExam")
    public String toAddExam() {
        return "exam/addExam";
    }

    /**
     * 增加考试安排
     * @param exam
     * @return
     */
    @RequestMapping("/addExam")
    public String addExam(Model model, Exam exam) {
        List<Studentinformation> list = studentinformationService.queryAllStudentinformation();
        for (Studentinformation aa:list){
            exam.setCode(aa.getCodeid());
            exam.setName(aa.getName());
            examService.addExam(exam);
        }

        return "redirect:/exam/allExam";
    }

    /**
     * 删除成绩
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public String deleteExam(int id) {
        examService.deleteExamById(id);
        return "redirect:/exam/allExam";
    }


    /**
     * 修改考试安排
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("toUpdateExam")
    public String toUpdateExam(Model model, int id) {
        model.addAttribute("exam", examService.queryById(id));
        return "exam/updateExam";
    }

    @RequestMapping("/updateExam")
    public String updateExam(Model model, Exam exam) {
        examService.updateExam(exam);
        return "redirect:/exam/allExam";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/getAllById")
    @ResponseBody
    public Exam queryById(int id) {
        Exam exam = examService.queryById(id);
        return exam;
    }


    /**
     * 按照学号查询
     */

    //查找学号
    @RequestMapping("/exam")
    public String exam(Model model, Integer code) {
        List<Exam> exam = examService.examList(code);
        model.addAttribute("exam", exam.get(0));
        return "exam/studentExam";
    }
    //查找所有json
    @RequestMapping("/json")
    @ResponseBody
    public List<Exam> exams(Integer code) {
        List<Exam> list = examService.examList(code);
        return list;
    }
}
