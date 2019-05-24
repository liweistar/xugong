package com.controller.zj;


import com.pojo.xlw.Studentinformation;
import com.pojo.xlw.Users;
import com.pojo.zj.Selectcourse;
import com.service.xlw.StudentinformationService;
import com.service.zj.SelectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SelectController {
    @Resource
    private SelectService selectService;
    @Resource
    private StudentinformationService studentinformationServiceImpl;

    @RequestMapping("select")
    public String select(int id, Selectcourse selectcourse, HttpServletRequest req, HttpSession session) {
        Users user = (Users) req.getSession().getAttribute("users1");

        selectcourse.setCodeid(user.getId());
        selectcourse.setCourseid(id);
        Selectcourse sc = selectService.show(selectcourse);
        if (sc != null) {
            return "error1";

        } else {
            selectService.ins(selectcourse);
            selectService.insH(selectcourse);
            selectService.setcount(id);
            return "redirect:selCourse.jsp";
        }
    }

    @RequestMapping("selected")
    @ResponseBody
    public List<Selectcourse> show(HttpServletRequest req) {
        Users user = (Users) req.getSession().getAttribute("users1");
        return selectService.showt(user.getId());
    }

    @RequestMapping("history")
    @ResponseBody
    public List<Selectcourse> showhis(HttpServletRequest req) {
        Users user = (Users) req.getSession().getAttribute("users1");
        return selectService.showhis(user.getId());
    }
}
