package com.controller.zj;


import com.pojo.xlw.Users;
import com.service.zj.DelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DelController {
    @Resource
    private DelService delService;

    @RequestMapping("delcourse")
    public String DelCourse(HttpServletRequest req, HttpSession session, int id) {
        Users user = (Users) req.getSession().getAttribute("users1");
        int index = delService.show(user.getId(), id);
        if (index > 0) {
            delService.setcount(id);
            return "redirect:sezlected.jsp";
        } else {
            return "error";
        }
    }
}
