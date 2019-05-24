package com.controller.ymy;


import com.pojo.xlw.Studentinformation;
import com.pojo.ymy.Stuel;
import com.service.xlw.StudentinformationService;
import com.service.ymy.StuelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
   @Resource
    private StuelService stuelService;

   @Resource
    private StudentinformationService studentinformationService;
    /**
     * 查询所有评价信息
     * @param model
     * @return
     */
    @RequestMapping("/allEvaluate")
    public String list(Model model) {
        return "evaluate/allEvaluate";
    }

    /**
     * json数据交互
     * @return
     */
    @RequestMapping("/json.action")
    public @ResponseBody
    List<Stuel> json(){
        List<Stuel> stuelList = stuelService.queryAllStuel();
        return stuelList;
    }

    /**
     * 增加学生评价 到addEvaluate.jsp
     * @return
     */
    @RequestMapping("toAddEvaluate")
    public String toAddEvaluate() {
        return "evaluate/addEvaluate";
    }

    /**
     * 增加学生评价
     * @param stuel
     * @return
     */
    @RequestMapping("/addEvaluate")
    public String addEvaluate(Stuel stuel) {
        List<Studentinformation> list = studentinformationService.queryAllStudentinformation();
        for (Studentinformation aa:list) {
            stuel.setCode(aa.getCodeid());
            stuel.setStuname(aa.getName());
            stuel.setElnr("");
            stuel.setTime(new Date());
            stuelService.addStuel(stuel);
        }
        return "redirect:/evaluate/allEvaluate";
    }

    /**
     * 删除评价
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public String deleteEvaluate(int id) {
        stuelService.deleteStuelById(id);
        return "redirect:/evaluate/allEvaluate";
    }

    /**
     * 修改评价
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("toUpdateEvaluate")
    public String toUpdateEvaluate(Model model, int id) {
        model.addAttribute("evaluate", stuelService.queryById(id));
        return "evaluate/updateEvaluate";
    }

    @RequestMapping("/updateEvaluate")
    public String updateEvaluate(Model model, Stuel stuel) {
        stuel.setElnr("");
        stuel.setTime(new Date());
        stuelService.updateStuel(stuel);
        return "redirect:/evaluate/allEvaluate";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/getAllById")
    @ResponseBody
     public Stuel queryById(int id) {
        Stuel stuel = stuelService.queryById(id);
        return stuel;
    }


    /**
     * 按照学号查询
     */

    //查找学号
    @RequestMapping("/evaluate")
    public String evaluate(Model model, Integer code) {
        Stuel stuel = stuelService.stuelList(code);
        model.addAttribute("stuel", stuel);
        return "evaluate/studentEvaluate";
    }
    //查找所有json
    @RequestMapping("/evaluatejson")
    @ResponseBody
    public List<Stuel> stuels(Integer code) {
        Stuel stuel = stuelService.stuelList(code);
        List<Stuel> list=new ArrayList<>();
        list.add(stuel);
        return list;
    }

    /**
     * 填写评价
     * @param model
     * @param stuel
     * @return
     */
    @RequestMapping("/addStuel")
    @ResponseBody
    public List<Stuel> addStuel(Model model,Stuel stuel) {
        int aa=stuel.getCode();
        Stuel stuel1 = stuelService.stuelList(aa);
        stuel1.setElnr(stuel.getElnr());
        stuelService.addStuele(stuel1);
        Stuel stuel2=stuelService.stuelList(aa);
        List<Stuel> stuels=new ArrayList<>();
        stuels.add(stuel2);
        return stuels;
    }
}
