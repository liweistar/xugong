package com.controller.xlw;

import com.pojo.xlw.Admin;
import com.pojo.xlw.Student;
import com.pojo.xlw.Users;
import com.service.xlw.AdminService;
import com.service.xlw.LoginUserService;
import com.service.xlw.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author level
 * @create 2019/5/15 - 15:41
 */
@Controller
@RequestMapping("/login")
public class LoginUserController {
    @Resource
    private AdminService adminServiceImpl;
    @Resource
    private StudentService studentServiceImpl;
    @Resource
    public LoginUserService loginUserService;

    @RequestMapping("loginUser")
    public String a(Users users, HttpSession session) {
        Users users1 = loginUserService.login(users);
        if (users1 != null && "学生".equals(users1.getUser())) {
            session.setAttribute("users2", users1.getUsername());
            session.setAttribute("users1", users1);
            return "redirect:/login/student.jsp";

        } else if (users1 != null && "管理员".equals(users1.getUser())) {
            session.setAttribute("users2", users1.getUsername());
            session.setAttribute("users1", users1);
            return "redirect:/login/admin.jsp";
        } else if (users1 != null && "教师".equals(users1.getUser())) {
            session.setAttribute("users2", users1.getUsername());
            return "redirect:/login/teacher.jsp";
        } else {
            session.setAttribute("fall", "登陆失败，请重新登录");
            return "redirect:/login.jsp";
        }
    }

}
