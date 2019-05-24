package com.controller.xlw;

import com.pojo.xlw.Card;
import com.pojo.xlw.ResponseBo;
import com.pojo.xlw.Studentinformation;
import com.pojo.xlw.Users;
import com.service.xlw.CardService;
import com.service.xlw.StudentinformationService;
import com.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author level
 * @create 2019/5/6 - 22:08
 */
@Controller
public class StudentinformationController {
    @Resource
    public StudentinformationService studentinformationService;
    @Resource
    public CardService cardService;


    @RequestMapping("/studentinformation2")
    public String list(Model model, int codeid) {
        List<Studentinformation> s = studentinformationService.queryByCodeid(codeid);
        if (s.size() == 0) {
            model.addAttribute("fail", "学号为" + codeid + "的学生已被删除，一卡通已被注销");
            return "/admincurd/allStudentInformation";
        } else {
            return null;
        }
    }

    @RequestMapping("/studentinformation")
    public String list(Model model) {
        return "/admincurd/allStudentInformation";

    }

    @RequestMapping("/studentinformation1")
    public String list1(Model model, Integer codeid) {
        List<Studentinformation> list = studentinformationService.queryByCodeid(codeid);
        Studentinformation s = list.get(0);
        model.addAttribute("studentinformation", s);
        return "/studentquery/studentquery";
    }

    @RequestMapping("/deletesi")
    public String delete(Model model, int codeid) {
        studentinformationService.deleteStudentinformationById(codeid);
        cardService.delete(codeid);
        studentinformationService.deleteUser(String.valueOf(codeid));
        return "redirect:/studentinformation2?codeid=" + codeid;
    }

    @RequestMapping("/toupdatasi")
    public String toupdata(Model model, Integer id) {
        model.addAttribute("studentinformation", studentinformationService.queryById(id));
        return "/admincurd/updateStudentInformation";
    }

    @RequestMapping("/updatasi")
    public String updata(Model model, Studentinformation studentinformation) {
        studentinformationService.updateStudentinformation(studentinformation);

        return "redirect:/studentinformation";
    }

    @RequestMapping("/adddatasi")
    //增加学生的同时增加，此学生的账号和默认密码，增加一张一卡通
    public String add(Model model, Studentinformation studentinformation) {
        studentinformationService.addStudentinformation(studentinformation);
        Users u=new Users();
        u.setUser("学生");
        u.setUsername(String.valueOf(studentinformation.getCodeid()));
        u.setPassword(String.valueOf(123456));
        studentinformationService.addLoginUser(u);
        Card c=new Card();
        c.setCode(studentinformation.getCodeid());
        c.setPower("可用");
        c.setMoney(0);
        c.setName(studentinformation.getName());
        c.setSpeciality(studentinformation.getSpeciality());

        Date date=new Date(System.currentTimeMillis());
        c.setDate(date);
        studentinformationService.addCard(c);
        return "redirect:/studentinformation";
    }

    @RequestMapping("/toadddatasi")
    public String toadd(Model model, Studentinformation studentinformation) {

        return "/admincurd/addStudentInformation";
    }

    @RequestMapping("/json.action")
    @ResponseBody
    public List json() {
        Map<String,Object> hashMap = new HashMap<String,Object>();
        List<Studentinformation> s = studentinformationService.queryAllStudentinformation();
        return s;
    }
    @RequestMapping("/addinfo")
    @ResponseBody
    public String json1() {

        return "admin";
    }
    @RequestMapping("/excel")
    @ResponseBody
    public ResponseBo achievementExcel() {
        try {
            List<Studentinformation> list = this.studentinformationService.queryAllStudentinformation();
            return FileUtils.createExcelByPOIKit("成绩表", list, Studentinformation.class);
        } catch (Exception e) {
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/json")
    @ResponseBody
    public Studentinformation json(Integer code) {
        Studentinformation s = studentinformationService.queryByCodeidd(code);
        List<Studentinformation> list= new ArrayList<>();
        list.add(s);
        return list.get(0);
    }
}
